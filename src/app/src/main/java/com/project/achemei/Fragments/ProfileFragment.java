package com.project.achemei.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.project.achemei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private EditText tvPhone;
    private EditText tvAddress;
    private EditText tvAbout;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //Ativar a Action Bar na Fragment
        setHasOptionsMenu(true);

        tvPhone = (EditText) view.findViewById(R.id.company_et_phone);
        tvAddress = (EditText) view.findViewById(R.id.company_et_address);
        tvAbout = (EditText) view.findViewById(R.id.company_et_about);

        //Desativa a edição nas EditTexts
        tvPhone.setEnabled(false);
        tvAddress.setEnabled(false);
        tvAbout.setEnabled(false);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_edit) {

            tvPhone.setEnabled(true);
            tvAddress.setEnabled(true);
            tvAbout.setEnabled(true);
        }
        return super.onOptionsItemSelected(item);
    }
}
