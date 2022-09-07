package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AboutMeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        actionBar();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("userName","Asmaa");
        editor.putString("userEmail","asmaa.kmotawie@gmail.com");
        editor.putString("userPhone","01060066848");
        editor.commit();

        Button edit = findViewById(R.id.edit);
        //TextView nameEdit = findViewById(R.id.edit_name);
        //TextView emailEdit = findViewById(R.id.edit_email);
        //TextView phoneEdit = findViewById(R.id.edit_phone);

        edit.setOnClickListener(view -> {
            TextView name_view = findViewById(R.id.name);
            name_view.setText("Asmaa");
        });
    }

    private void actionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);}
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void preference(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mEditor = sharedPreferences.edit();
    }
}