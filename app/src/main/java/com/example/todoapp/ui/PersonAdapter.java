package com.example.todoapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapp.OnItemClickListener;
import com.example.todoapp.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    ArrayList<String>list;
    OnItemClickListener listener;
    public PersonAdapter(){
        list=new ArrayList<>();
        list.add("Nurzhamal");
        list.add("Pavel");
        list.add("Aigerim");
        list.add("Kubat");
        list.add("Kunduz");
        list.add("Mirkamil");
        list.add("Aiyma");
    }
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setOnClickListener(OnItemClickListener listener){
        this.listener= listener;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.name_of_person);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(getAdapterPosition());
                }
            });
        }
        public void bind(String s){
            textView.setText(s);
        }
    }
}
