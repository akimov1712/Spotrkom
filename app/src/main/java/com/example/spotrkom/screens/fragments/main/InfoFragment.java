package com.example.spotrkom.screens.fragments.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotrkom.R;
import com.example.spotrkom.screens.fragments.information.AmericanInformationFragment;
import com.example.spotrkom.screens.fragments.information.MainInformationFragment;
import com.example.spotrkom.screens.fragments.information.TwoHandInformationFragment;
import com.google.android.material.tabs.TabLayout;


public class InfoFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        replaceFragment(new MainInformationFragment());
        clickListenerTabMenu();

        return view;
    }

    private void clickListenerTabMenu(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new MainInformationFragment();
                        break;
                    case 1:
                        fragment = new AmericanInformationFragment();
                        break;
                    case 2:
                        fragment = new TwoHandInformationFragment();
                        break;
                }
                replaceFragment(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_info, fragment);
        fragmentTransaction.commit();
    }

}