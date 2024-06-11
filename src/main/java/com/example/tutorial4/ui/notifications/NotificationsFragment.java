package com.example.tutorial4.ui.notifications;

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
import com.example.tutorial4.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TextView counter;
    private Button increment;
    //int count = 0;
    private NotificationsViewModel notificationsViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(getActivity()).get(NotificationsViewModel.class);

        //binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        //View root = binding.getRoot();

        increment = root.findViewById(R.id.count_button_nt);
        counter = root.findViewById(R.id.count_txt_nt);
        counter.setText(Integer.toString(notificationsViewModel.counter));

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        if(increment != null) {
            increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notificationsViewModel.counter++;
                    counter.setText(Integer.toString(notificationsViewModel.counter));
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