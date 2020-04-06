package com.example.todoapp.ui.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.todoapp.R;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class NotesFragment extends Fragment {

    private EditText editText;
    private File file;

        public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tools,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.editText);
        File folder = new File(Environment.getExternalStorageDirectory(),"TodoApp");
        folder.mkdir();
        file = new File(folder, "note.txt");
        try {
            String text = FileUtils.readFileToString(file, "utf-8");
            editText.setText(text);
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("TAG","onPause");
        save();
    }

    private void save(){

            String text = editText.getText().toString();
        try {
            FileUtils.writeStringToFile(file, text, "utf-8");
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("TAG","onActivityResult Fragment");
        if (resultCode == Activity.RESULT_OK && resultCode ==101) {
            int size = data.getIntExtra("size", 14);
            editText.setTextSize(size);

        }
    }
}