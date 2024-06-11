package com.example.tutorial4.ui.home;

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
import com.example.tutorial4.databinding.FragmentHomeBinding;
//import com.example.tutorial4.databinding.FragmentNotificationsBinding;
//import com.example.tutorial4.ui.notifications.NotificationsViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView counter;
    private Button increment;
    //int count = 0;
    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(getActivity()).get(HomeViewModel.class);

        //binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //TextView counter = binding.countTxtNt;
        //Button increment = binding.countButtonNt;
        increment = root.findViewById(R.id.count_button_hm);
        counter = root.findViewById(R.id.count_txt_hm);
        counter.setText(Integer.toString(homeViewModel.counter));

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        if(increment != null) {
            increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    homeViewModel.counter++;
                    counter.setText(Integer.toString(homeViewModel.counter));
                }

            });
        }
        else {
            System.out.println("Holy crap increment not found!!");
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}