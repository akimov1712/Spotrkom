package com.example.spotrkom.screens.fragments.information;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.spotrkom.R;
import com.example.spotrkom.adapters.ExerciseAdapter;
import com.example.spotrkom.adapters.RankAdapter;
import com.example.spotrkom.pojo.ExerciseModel;
import com.example.spotrkom.pojo.RanksModel;

import java.util.ArrayList;
import java.util.List;


public class TwoHandInformationFragment extends Fragment {

    private List<RanksModel> ranks;
    private List<ExerciseModel> exercises;

    private View view;
    private RecyclerView rcRanks;
    private RecyclerView rcExercise;
    private TextView tvPoint;
    private ExerciseAdapter adapterExercise;
    private RankAdapter adapterRanks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two_hand_information, container, false);
        tvPoint = view.findViewById(R.id.tvCountPoint);
        tvPoint.setText("Повторений");
        rcExercise = view.findViewById(R.id.rcExercise);
        rcRanks = view.findViewById(R.id.rcRanks);

        adapterRanks = new RankAdapter();
        ranks = new ArrayList<>();
        ranks.add(new RanksModel(R.color.three_hundred_bucks, "Новобранец", "1"));
        ranks.add(new RanksModel(R.color.open_the_door, "Любитель", "3"));
        ranks.add(new RanksModel(R.color.prodvinutiy, "Эксперт", "5"));
        ranks.add(new RanksModel(R.color.sportkom_legend, "Мастер", "10"));
        ranks.add(new RanksModel(R.color.grand_master, "Спортком лига", "15"));
        ranks.add(new RanksModel(R.color.danger_masters, "Грандмастер", "21"));
        adapterRanks.setRanksList(ranks);
        rcRanks.setAdapter(adapterRanks);


        adapterExercise = new ExerciseAdapter();
        exercises = new ArrayList<>();
        exercises.add(new ExerciseModel(R.drawable.image_pull_up, "Подтягивание"));
        exercises.add(new ExerciseModel(R.drawable.image_output_two, "Выход на две"));
        adapterExercise.setExerciseList(exercises);
        rcExercise.setAdapter(adapterExercise);

        return view;
    }
}