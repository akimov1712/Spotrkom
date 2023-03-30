package com.example.spotrkom.screens.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.spotrkom.R;
import com.example.spotrkom.screens.fragments.main.ChatFragment;
import com.example.spotrkom.screens.fragments.main.InfoFragment;
import com.example.spotrkom.screens.fragments.main.MainFragment;
import com.example.spotrkom.screens.fragments.main.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_menu);
        replaceFragment(new MainFragment());
        clickListenerBottomMenu();
    }

    private void clickListenerBottomMenu(){
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_house:
                    transitionFragmentMain();
                    break;
                case R.id.menu_info:
                    transitionFragmentInfo();
                    break;
                case R.id.menu_mess:
                    transitionFragmentMess();
                    break;
                case R.id.menu_user:
                    transitionFragmentProfile();
                    break;

            }

            return true;
        });
    }

    public void transitionFragmentMain(){
        replaceFragment(new MainFragment());
    }

    public void transitionFragmentInfo(){
        replaceFragment(new InfoFragment());
    }

    public void transitionFragmentMess(){
        replaceFragment(new ChatFragment());
    }

    public void transitionFragmentProfile(){
        replaceFragment(new ProfileFragment());
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}