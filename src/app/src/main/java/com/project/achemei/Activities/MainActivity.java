package com.project.achemei.Activities;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.achemei.Activities.Controllers.APIService;
import com.project.achemei.Adapters.AtividadesAdapter;
import com.project.achemei.Models.ListaAtividades;
import com.project.achemei.Models.Atividades;
import com.project.achemei.R;

import java.util.ArrayList;
import java.util.List;

import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = "MainActivity";
    private ListaAtividades atividades = new ListaAtividades();
    private AtividadesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Barra de busca da Activity
        Toolbar searchBar = (Toolbar) findViewById(R.id.searchbar);
        searchBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_search) {
                    SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
                    searchView.setQueryHint("O que você procura?");
                    searchView.setOnQueryTextListener(MainActivity.this);
                }
                return true;
            }
        });
        searchBar.inflateMenu(R.menu.menu_search);

        getAPIList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_title, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = null;

        switch (item.getItemId()) {

            case R.id.item_profile:
                intent = new Intent(MainActivity.this, ProfileActivity.class);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        List<Atividades> newList = new ArrayList<>();

        for (Atividades d : atividades.getDados()){

            String name = d.getNome().toLowerCase();

            if (name.contains(newText)) {
                newList.add(d);
            }
        }

        adapter.setFilter(newList);
        return true;
    }

    public void getAPIList(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ListaAtividades> requestCatalog = service.getAtividade(
                "0",
                "",
                "",
                "Android",
                "0000000000",
                "0000000000");

        requestCatalog.enqueue(new Callback<ListaAtividades>() {
            @Override
            public void onResponse(Call<ListaAtividades> call, Response<ListaAtividades> response) {

                if(!response.isSuccessful()){
                    Log.i(TAG, "<< Código de Erro: " + response.code());
                }
                else{
                    atividades = response.body();

                    adapter = new AtividadesAdapter(MainActivity.this, atividades.getDados());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                    IndexFastScrollRecyclerView recyclerView = (IndexFastScrollRecyclerView) findViewById(R.id.fast_scroller_recycler);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);

                    recyclerView.setIndexTextSize(12);
                    recyclerView.setIndexBarColor("#33334c");
                    recyclerView.setIndexBarCornerRadius(0);
                    recyclerView.setIndexBarTransparentValue((float) 0.4);
                    recyclerView.setIndexbarMargin(0);
                    recyclerView.setIndexbarWidth(40);
                    recyclerView.setPreviewPadding(0);
                    recyclerView.setIndexBarTextColor("#FFFFFF");
                    recyclerView.setIndexBarVisibility(true);

                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ListaAtividades> call, Throwable t) {
                Log.i(TAG, "<< Código de Erro: " + t.getMessage());
            }
        });
    }
}