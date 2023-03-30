package com.example.spotrkom.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotrkom.R;
import com.example.spotrkom.pojo.ExerciseModel;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private List<ExerciseModel> exerciseList;

    public ExerciseAdapter() {
        exerciseList = new ArrayList<>();
    }

    public void setExerciseList(List<ExerciseModel> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageExercise;
        TextView nameExercise;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageExercise = itemView.findViewById(R.id.ivExercise);
            nameExercise = itemView.findViewById(R.id.tvExercise);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise_information, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExerciseModel exercises = exerciseList.get(position);
        holder.imageExercise.setImageResource(exercises.getImageExercise());
        holder.nameExercise.setText(exercises.getNameExercise());
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

}
