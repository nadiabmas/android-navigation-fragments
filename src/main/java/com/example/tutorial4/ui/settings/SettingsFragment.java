package com.example.tutorial4.ui.settings;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tutorial4.R;
//import com.example.tutorial4.databinding.FragmentNotificationsBinding;
import com.example.tutorial4.databinding.FragmentSettingsBinding;
import com.example.tutorial4.ui.dashboard.DashboardViewModel;
import com.example.tutorial4.ui.home.HomeViewModel;
import com.example.tutorial4.ui.notifications.NotificationsViewModel;
//import com.example.tutorial4.ui.notifications.NotificationsViewModel;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private TextView counter;
    // Homework
    private TextView counterHm;
    private TextView counterDb;
    private TextView counterNt;

    private Button increment;
    //int count = 0;
    private SettingsViewModel settingsViewModel;
    // Homework
    private NotificationsViewModel notificationsViewModel;
    private HomeViewModel homeViewModel;
    private DashboardViewModel dashboardViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        //binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        settingsViewModel =
                new ViewModelProvider(getActivity()).get(SettingsViewModel.class);
        // Homework
        notificationsViewModel =
                new ViewModelProvider(getActivity()).get(NotificationsViewModel.class);
        homeViewModel =
                new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        dashboardViewModel =
                new ViewModelProvider(getActivity()).get(DashboardViewModel.class);

        increment = root.findViewById(R.id.count_button_st);
        counter = root.findViewById(R.id.count_txt_st);
        int counterTest = settingsViewModel.counter2;

        // HOMEWORK
        counterNt = root.findViewById(R.id.count_txt_st_nt);
        counterHm = root.findViewById(R.id.count_txt_st_hm);
        counterDb = root.findViewById(R.id.count_txt_st_db);
        int notCounter = notificationsViewModel.getCounter();
        int homeCounter = homeViewModel.getCounter();
        int dashCounter = dashboardViewModel.getCounter();

        System.out.println("settings counter is " + Integer.toString(counterTest)
                + " with numbers " + notCounter + "," + homeCounter + " and " + dashCounter);

        counter.setText(Integer.toString(settingsViewModel.counter2));
        counterNt.setText(Integer.toString(notCounter));
        counterHm.setText(Integer.toString(homeCounter));
        counterDb.setText(Integer.toString(dashCounter));

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        if(increment != null) {
            increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    settingsViewModel.counter2++;
                    counter.setText(Integer.toString(settingsViewModel.counter2));
                }

            });
        }
        return root;
    }


}