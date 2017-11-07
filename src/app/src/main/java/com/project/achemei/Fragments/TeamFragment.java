package com.project.achemei.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.achemei.Activities.Controllers.APIService;
import com.project.achemei.Activities.LoginActivity;
import com.project.achemei.Adapters.FullMEIAdapter;
import com.project.achemei.Models.ListaFullMEI;
import com.project.achemei.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment {

    private ListaFullMEI listaFullMEI = new ListaFullMEI();

    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team, container, false);

        getAPIList(view);

        // Inflate the layout for this fragment
        return view;
    }

    public void getAPIList(final View view){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ListaFullMEI> requestCatalog = service.getFullMEIS(
                "0",
                "Android",
                "0000000000",
                "0000000000");
        requestCatalog.enqueue(new Callback<ListaFullMEI>() {
            @Override
            public void onResponse(Call<ListaFullMEI> call, Response<ListaFullMEI> response) {
                if(!response.isSuccessful()){
                    Log.i(TAG, "Erro: " + response.code());
                }
                else {
                    listaFullMEI = response.body();

                    Log.i("TeamFragment", "FullMEIList Size: " + listaFullMEI.getListaFullMEIS().size());
                    /*
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_team);
                    FullMEIAdapter adapter = new FullMEIAdapter(getActivity(), );
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                    view.findViewById(R.id.loadingCompanyPanel).setVisibility(View.GONE);*/
                }
            }

            @Override
            public void onFailure(Call<ListaFullMEI> call, Throwable t) {
                Log.i(TAG, "Erro: " + t.getMessage());
            }
        });
    }
}
