package com.example.spotrkom.screens.fragments.main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotrkom.R;
import com.example.spotrkom.screens.activities.main.TableUserActivity;


public class MainFragment extends Fragment{

    private View view;

    private TextView btnTableUsers;
    private Button btnOpenModalAddPoint;

    private int countProgress = 0;
    private int count = 0;
    private ProgressBar progressBar;
    private TextView tvPercentProgress;

    private TextView tvPointNow;
    private TextView tvPointStay;
    private TextView tvPointTarget;

    private Dialog modalAddPoint;
    private EditText etAddPoint;
    private Button btnAddPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        // инициализация кнопок на главном экране
        btnTableUsers = view.findViewById(R.id.btn_table_users);
        btnOpenModalAddPoint = view.findViewById(R.id.btnOpenModalAddPoint);
        // инициализация элементов в модалке
        modalAddPoint = new Dialog(getContext());
        modalAddPoint.setContentView(R.layout.modal_add_point);
        etAddPoint = modalAddPoint.findViewById(R.id.etAddPoint);
        btnAddPoint = modalAddPoint.findViewById(R.id.btnAddPoint);
        // инициализация элементов в прогрессБаре
        progressBar = view.findViewById(R.id.pBar_next_lvl);
        tvPercentProgress = view.findViewById(R.id.tvPercentProgress);
        // инициализация списка с очками
        tvPointNow = view.findViewById(R.id.tvPointNow);
        tvPointStay = view.findViewById(R.id.tvPointStay);
        tvPointTarget = view.findViewById(R.id.tvPointTarget);
        // работа с элементами
        tvPointTarget.setText("2000");
        tvPointNow.setText("200");
        updateData();
        addPoint();
        initClickListener();


        return view;
    }

    public void onClickOpenActivityTableUser() {
        Intent intent = new Intent(MainFragment.this.getContext(), TableUserActivity.class);
        getActivity().startActivity(intent);

    }


    private void addPoint(){
        btnAddPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etAddPoint.getText().toString().isEmpty()){
                    count = count + Integer.parseInt(etAddPoint.getText().toString());
                    updateData();
                    modalAddPoint.dismiss();
                    etAddPoint.setText("");
                } else {
                    Toast.makeText(getContext(), "Введите кол-во очков", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateData(){
        if (count > 2000){
            count = 0;
        }else {
            tvPointNow.setText(String.valueOf(count));
            tvPointStay.setText(String.valueOf(Integer.parseInt(tvPointTarget.getText().toString()) - Integer.parseInt(tvPointNow.getText().toString())));
            countProgress = (int) ((Float.parseFloat(tvPointNow.getText().toString()) * 100) / Float.parseFloat(tvPointTarget.getText().toString()));;
            progressBar.setProgress(countProgress);
            tvPercentProgress.setText(countProgress + "%");
        }
    }

    public void onClickAddProgress() {
        progressBar.setMax(100);
        count++;
        updateData();
    }

    public void onClickOpenModalAddPoint() {
        modalAddPoint.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        modalAddPoint.show();
    }


    private void initClickListener(){

        btnTableUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOpenActivityTableUser();
            }
        });

        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddProgress();
            }
        });

        btnOpenModalAddPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOpenModalAddPoint();
            }
        });

    }

}