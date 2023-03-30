package com.example.spotrkom.screens.fragments.information;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.spotrkom.R;
import com.example.spotrkom.adapters.RankAdapter;
import com.example.spotrkom.pojo.RanksModel;
import java.util.ArrayList;
import java.util.List;

public class MainInformationFragment extends Fragment {

    private List<RanksModel> ranks;

    private View view;
    private TextView tvPoint;
    private RecyclerView recyclerView;
    private RankAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_information, container, false);
        tvPoint = view.findViewById(R.id.tvCountPoint);

        recyclerView = view.findViewById(R.id.rcRanks);
        adapter = new RankAdapter();
        ranks = new ArrayList<>();
        ranks.add(new RanksModel(R.color.three_hundred_bucks, getString(R.string.three_hundred_bucks), "0-500"));
        ranks.add(new RanksModel(R.color.open_the_door, getString(R.string.open_the_door), "500-2000"));
        ranks.add(new RanksModel(R.color.prodvinutiy, getString(R.string.prodvinutiy), "2000-3500"));
        ranks.add(new RanksModel(R.color.sportkom_legend, getString(R.string.sportkom_legend), "3500-6000"));
        ranks.add(new RanksModel(R.color.grand_master, getString(R.string.grand_master), "6000-10000"));
        ranks.add(new RanksModel(R.color.danger_masters, getString(R.string.danger_masters), "10000+"));
        adapter.setRanksList(ranks);
        recyclerView.setAdapter(adapter);

        return view;
    }
}