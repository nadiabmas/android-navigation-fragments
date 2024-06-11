package com.example.tutorial4.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tutorial4.R;
import com.example.tutorial4.databinding.FragmentDashboardBinding;
//import com.example.tutorial4.databinding.FragmentNotificationsBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private TextView counter;
    private Button increment;
    //int count = 0;
    private DashboardViewModel dashboardViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(getActivity()).get(DashboardViewModel.class);

        //binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //View root = binding.getRoot();

        increment = root.findViewById(R.id.count_button_db);
        counter = root.findViewById(R.id.count_txt_db);
        counter.setText(Integer.toString(dashboardViewModel.counter));

        if(increment != null) {
            //final TextView textView = binding.textNotifications;
            //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dashboardViewModel.counter++;
                    counter.setText(Integer.toString(dashboardViewModel.counter));
                }

            });
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}