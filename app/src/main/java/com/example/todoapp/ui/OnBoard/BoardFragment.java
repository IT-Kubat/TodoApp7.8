package com.example.todoapp.ui.OnBoard;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todoapp.MainActivity;
import com.example.todoapp.Prefs;
import com.example.todoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {

    Button button;


    public BoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textTitle = view.findViewById(R.id.textTitle);
        ImageView imageView = view.findViewById(R.id.imageView);
        button = view.findViewById(R.id.btnStart);
        int pos = getArguments().getInt("pos");
        switch (pos){
            case 0:
                textTitle.setText("Hello");
                imageView.setImageResource(R.drawable.onboard_1);
                button.setVisibility(View.INVISIBLE);
                break;
            case 1:
                textTitle.setText("How are you?");
                imageView.setImageResource(R.drawable.onboard_2);
                button.setVisibility(View.INVISIBLE);
                break;
            case 2:
                textTitle.setText("I am great");
                imageView.setImageResource(R.drawable.onboard_3);
                button.setVisibility(View.VISIBLE);
                break;

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prefs.getInstance(getContext()).saveShown();
                startActivity(new Intent(getContext(),  MainActivity.class));
                getActivity().finish();

            }
        });

    }
}
