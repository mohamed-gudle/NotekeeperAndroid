package com.example.notekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

public class NotelistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notelist);


       initializeDisplayContent();
    }
    private void initializeDisplayContent(){
        ListView noteList=findViewById(R.id.notelist);
        List<NoteInfo> notes=DataManager.getInstance().getNotes();
        ArrayAdapter<NoteInfo> notesAdapter=new ArrayAdapter<NoteInfo>(this,R.layout.activity_notelist,notes);
        noteList.setAdapter(notesAdapter);
        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(NotelistActivity.this,NoteActivity.class);
                startActivity(intent);
            }
        });

    }
}
