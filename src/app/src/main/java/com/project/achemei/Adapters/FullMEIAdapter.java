package com.project.achemei.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.achemei.Models.Employee;
import com.project.achemei.R;

import java.util.ArrayList;

/**
 * Created by fabio on 27/10/2017.
 */

public class FullMEIAdapter extends RecyclerView.Adapter<FullMEIAdapter.FullMEIViewHolder>{

    private ArrayList<Employee> listaEmployees;
    private LayoutInflater layoutInflater;

    public FullMEIAdapter(Context c, ArrayList<Employee> list) {
        this.listaEmployees = list;
        this.layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FullMEIAdapter.FullMEIViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_mei, parent, false);
        return new FullMEIAdapter.FullMEIViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FullMEIAdapter.FullMEIViewHolder holder, int position) {
        holder.tvEmployeeName.setText(listaEmployees.get(position).getName());
        holder.tvIdentification.setText(listaEmployees.get(position).getRg());
        holder.tvActivity.setText(listaEmployees.get(position).getSpecialty());
    }

    @Override
    public int getItemCount() {
        return listaEmployees.size();
    }

    class FullMEIViewHolder extends RecyclerView.ViewHolder {

        private TextView tvEmployeeName;
        private TextView tvIdentification;
        private TextView tvActivity;
        private ImageView ivEmployee;

        FullMEIViewHolder(View itemView) {
            super(itemView);

            tvEmployeeName = (TextView) itemView.findViewById(R.id.tv_employee_name);
            tvIdentification = (TextView) itemView.findViewById(R.id.tv_identification);
            tvActivity = (TextView) itemView.findViewById(R.id.tv_activity);
            ivEmployee = (ImageView)itemView.findViewById(R.id.iv_employee);
        }
    }
}