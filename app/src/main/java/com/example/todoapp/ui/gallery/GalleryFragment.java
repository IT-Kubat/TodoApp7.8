package com.example.todoapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.OnItemClickListener;
import com.example.todoapp.R;
import com.example.todoapp.ui.PersonAdapter;

import static com.example.todoapp.R.layout.fragment_gallery;

public class GalleryFragment extends Fragment {

    RecyclerView recyclerView;
    PersonAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view= LayoutInflater.from(getContext()).inflate(fragment_gallery,container,false);

        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.recyclerview);
        adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new OnItemClickListener() {
            @Override
            public void itemClick(int position) {

            }

            @Override
            public void itemLongClick(int position) {

            }

            });
    }
}