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

public class AmericanInformationFragment extends Fragment {

    private List<RanksModel> ranks;
    private List<RanksModel> points;
    private List<ExerciseModel> exercises;

    private View view;
    private RecyclerView rcExercise;
    private RecyclerView rcRanks;
    private RecyclerView rcPoints;
    private TextView tvCountPointTablePoints;
    private TextView tvPoint;
    private TextView tvRank;
    private ExerciseAdapter adapterExercise;
    private RankAdapter adapterRanks;
    private RankAdapter adapterPoints;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_american_information, container, false);
        rcExercise = view.findViewById(R.id.rcExercise);
        rcPoints = view.findViewById(R.id.rcPoints);
        rcRanks = view.findViewById(R.id.rcRanks);
        tvPoint = view.findViewById(R.id.tvCountPoint);
        tvRank = view.findViewById(R.id.tvNameRank);
        tvCountPointTablePoints = view.findViewById(R.id.tvCountPointTablePoint);
        tvPoint.setText("Очков за игру");
        tvCountPointTablePoints.setText("Очков за\nупражнение");

        adapterRanks = new RankAdapter();
        ranks = new ArrayList<>();
        ranks.add(new RanksModel(R.color.three_hundred_bucks, "Новобранец", "5-30"));
        ranks.add(new RanksModel(R.color.open_the_door, "Любитель", "30-50"));
        ranks.add(new RanksModel(R.color.prodvinutiy, "Эксперт", "50-150"));
        ranks.add(new RanksModel(R.color.sportkom_legend, "Мастер", "150-250"));
        ranks.add(new RanksModel(R.color.grand_master, "Спортком лига", "250-350"));
        ranks.add(new RanksModel(R.color.danger_masters, "Грандмастер", "350+"));
        adapterRanks.setRanksList(ranks);
        rcRanks.setAdapter(adapterRanks);


        adapterExercise = new ExerciseAdapter();
        exercises = new ArrayList<>();
        exercises.add(new ExerciseModel(R.drawable.image_pull_up, "Подтягивание"));
        exercises.add(new ExerciseModel(R.drawable.image_c_pull_up, "Подтягивание\nдо груди"));
        exercises.add(new ExerciseModel(R.drawable.image_pull_up_reverse, "Подъем переворот"));
        exercises.add(new ExerciseModel(R.drawable.image_output_one, "Выход на одну"));
        exercises.add(new ExerciseModel(R.drawable.image_output_two, "Выход на две"));
        exercises.add(new ExerciseModel(R.drawable.image_output_two_force, "Выход силой"));
        adapterExercise.setExerciseList(exercises);
        rcExercise.setAdapter(adapterExercise);

        adapterPoints = new RankAdapter();
        points = new ArrayList<>();
        points.add(new RanksModel(R.color.three_hundred_bucks, "Подтягивание", "1"));
        points.add(new RanksModel(R.color.open_the_door, "Подтягивание\nдо груди", "1,5"));
        points.add(new RanksModel(R.color.prodvinutiy, "Подъем переворот", "3"));
        points.add(new RanksModel(R.color.sportkom_legend, "Выход на одну", "5"));
        points.add(new RanksModel(R.color.grand_master, "Выход на две", "10"));
        points.add(new RanksModel(R.color.danger_masters, "Выход силой", "15"));
        adapterPoints.setRanksList(points);
        rcPoints.setAdapter(adapterPoints);

        return view;
    }
}