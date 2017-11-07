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
import com.project.achemei.Adapters.MEIAdapter;
import com.project.achemei.Models.ListaMEIS;
import com.project.achemei.Models.MEIS;
import com.project.achemei.R;

import java.util.ArrayList;
import java.util.List;

import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompanyListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private static final String TAG = "CompanyListActivity";
    private ListaMEIS listaMEIS = new ListaMEIS();
    private MEIAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        //Barra de busca da Activity
        Toolbar searchBar = (Toolbar)findViewById(R.id.searchbar);
        searchBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_search){
                    SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
                    searchView.setQueryHint("O que você procura?");
                    searchView.setOnQueryTextListener(CompanyListActivity.this);
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

        switch (item.getItemId()){

            case R.id.item_profile:
                intent = new Intent(CompanyListActivity.this, ProfileActivity.class);
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
        List<MEIS> newList = new ArrayList<>();

        for (MEIS m : listaMEIS.getMeis()){

            String name = m.getNome().toLowerCase();

            if (name.contains(newText)) {
                newList.add(m);
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
        Call<ListaMEIS> requestCatalog = service.getMEIS(
                "0",
                "Fabio",
                "",
                "Android",
                "0000000000",
                "0000000000",
                "1");

        requestCatalog.enqueue(new Callback<ListaMEIS>() {
            @Override
            public void onResponse(Call<ListaMEIS> call, Response<ListaMEIS> response) {
                if(!response.isSuccessful()){
                    Log.i(TAG, "Erro: " + response.code());
                }
                else {
                    listaMEIS = response.body();

                    adapter = new MEIAdapter(CompanyListActivity.this, listaMEIS.getMeis());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(CompanyListActivity.this);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                    IndexFastScrollRecyclerView recyclerView = (IndexFastScrollRecyclerView)findViewById(R.id.fast_scroller_companies);
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

                    findViewById(R.id.loadingCompanyPanel).setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ListaMEIS> call, Throwable t) {
                Log.i(TAG, "Erro: " + t.getMessage());
            }
        });
    }
}