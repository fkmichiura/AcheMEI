package com.project.achemei.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.project.achemei.Activities.CompanyListActivity;
import com.project.achemei.Models.Atividades;
import com.project.achemei.R;

import java.util.ArrayList;
import java.util.List;

public class AtividadesAdapter extends RecyclerView.Adapter<AtividadesAdapter.ProfileViewHolder> implements SectionIndexer {

    private ArrayList<Atividades> listaAtividades;
    private ArrayList<Integer> sectionPositions;
    private LayoutInflater layoutInflater;
    private Context context;

    public AtividadesAdapter(Context c, ArrayList<Atividades> list) {
        this.listaAtividades = list;
        this.layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = c;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_activity, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        Atividades current = listaAtividades.get(position);

        holder.tvCompanyName.setText(current.getNome());
    }

    @Override
    public int getItemCount() {
        return listaAtividades.size();
    }

    @Override
    public Object[] getSections() {
        List<String> sections = new ArrayList<>(26);
        sectionPositions = new ArrayList<>(26);

        for (int i = 0; i < listaAtividades.size(); i++) {
            String section = String.valueOf(listaAtividades.get(i).getNome().charAt(0)).toUpperCase();
            if (!sections.contains(section)) {
                sections.add(section);
                sectionPositions.add(i);
            }
        }
        return sections.toArray(new String[0]);
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return sectionPositions.get(sectionIndex);
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    public void setFilter(List<Atividades> list) {

        listaAtividades = new ArrayList<>();
        listaAtividades.addAll(list);
        notifyDataSetChanged();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCompanyName;

        ProfileViewHolder(View itemView) {
            super(itemView);

            tvCompanyName = (TextView) itemView.findViewById(R.id.tv_category);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context.getApplicationContext(), CompanyListActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}

