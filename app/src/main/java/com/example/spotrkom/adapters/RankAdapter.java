package com.example.spotrkom.adapters;


import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotrkom.R;
import com.example.spotrkom.pojo.RanksModel;

import java.util.ArrayList;
import java.util.List;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {

    private List<RanksModel> ranksList;

    public RankAdapter() {
        ranksList = new ArrayList<>();
    }

    public void setRanksList(List<RanksModel> rankList) {
        this.ranksList = rankList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView indicatorColor;
        private TextView tvNameRank;
        private TextView tvPointRank;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            indicatorColor = itemView.findViewById(R.id.viewIndicator);
            tvNameRank = itemView.findViewById(R.id.tvNameRank);
            tvPointRank = itemView.findViewById(R.id.tvPointRank);
        }
    }

    @NonNull
    @Override
    public RankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank_information, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankAdapter.ViewHolder holder, int position) {
        RanksModel ranks = ranksList.get(position);

        holder.indicatorColor.setBackground(new ColorDrawable(ContextCompat.getColor(holder.itemView.getContext(), ranks.getIndicatorColor())));

        holder.tvNameRank.setText(ranks.getNameRank());
        holder.tvPointRank.setText(String.valueOf(ranks.getPoints()));
    }

    @Override
    public int getItemCount() {
        return ranksList.size();
    }
}
