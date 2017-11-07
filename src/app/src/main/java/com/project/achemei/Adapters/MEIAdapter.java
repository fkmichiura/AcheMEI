package com.project.achemei.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.project.achemei.Models.MEIS;
import com.project.achemei.R;

import java.util.ArrayList;
import java.util.List;

public class MEIAdapter extends RecyclerView.Adapter<MEIAdapter.MEIViewHolder> implements SectionIndexer {

    private ArrayList<MEIS> listaMEIs;
    private ArrayList<Integer> sectionPositions;
    private LayoutInflater layoutInflater;

    public MEIAdapter(Context c, ArrayList<MEIS> list) {
        this.listaMEIs = list;
        this.layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MEIAdapter.MEIViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_mei, parent, false);
        return new MEIAdapter.MEIViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MEIAdapter.MEIViewHolder holder, int position) {
        holder.tvCategory.setText(listaMEIs.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return listaMEIs.size();
    }

    @Override
    public Object[] getSections() {
        List<String> sections = new ArrayList<>(26);
        sectionPositions = new ArrayList<>(26);
        for (int i = 0, size = listaMEIs.size(); i < size; i++) {
            String section = String.valueOf(listaMEIs.get(i).getNome().charAt(0)).toUpperCase();
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

    class MEIViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCategory;

        MEIViewHolder(View itemView) {
            super(itemView);

            tvCategory = (TextView) itemView.findViewById(R.id.tv_employee_name);
        }
    }

    public void setFilter(List<MEIS> list) {

        listaMEIs = new ArrayList<>();
        listaMEIs.addAll(list);
        notifyDataSetChanged();
    }

}
