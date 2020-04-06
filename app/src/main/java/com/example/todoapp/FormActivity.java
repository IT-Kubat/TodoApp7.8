package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.todoapp.model.Work;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FormActivity extends AppCompatActivity {

//    FormActivity
//    добавляем туда ImageView для выбора картины из галерии
//    Нажимаем сохранить
//- загрузить картинки в Storage
//- получаете url картинки
//- сохраняете work String imageUrl
//- отправляете work в Firestore
//    Показывать в FirestoreFragment

    private EditText editTitle;
    private EditText editDesk;
    Work myWork = new Work();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editTitle = findViewById(R.id.editTitle);
        editDesk = findViewById(R.id.editDesk);
        edit();
    }

    public void onBtnSave(View view) {
        String title = editTitle.getText().toString().trim();
        String desc = editDesk.getText().toString().trim();
        Work work = new Work(title, desc);
        Intent intent = new Intent();
        intent.putExtra("title", title);
        intent.putExtra("desc", desc);
        setResult(RESULT_OK, intent);
        if (editTitle.getText().toString().matches("") || editDesk.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "Fill the Line", Toast.LENGTH_SHORT).show();
        } else if (myWork != null) {
            myWork.setTitle(title);
            myWork.setDescription(desc);
            App.getDatabase().workDao().update(myWork);

        } else {
            myWork = new Work(title, desc);
            App.getDatabase().workDao().insert(myWork);
            saveToFirestore(work);
        }
        finish();

    }

    private void saveToFirestore(Work work) {
        FirebaseFirestore.getInstance().collection("works").add(work).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(FormActivity.this, "Great", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void edit() {
        myWork = (Work) getIntent().getSerializableExtra("work");
        if (myWork != null) {
            editDesk.setText(myWork.getDescription());
            editTitle.setText(myWork.getTitle());
        }
    }
}
