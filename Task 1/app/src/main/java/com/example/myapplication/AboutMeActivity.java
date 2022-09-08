package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AboutMeActivity extends AppCompatActivity {
    TextView name;
    TextView editName;
    TextView editPhone;
    TextView editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        actionBar();
        initialize();
        updateFields();

        Button edit = findViewById(R.id.edit);
        edit.setOnClickListener(view -> {
            startActivity(new Intent(AboutMeActivity.this,Edit_info.class));
        });
    }
    private void actionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);}
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateFields();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initialize()
    {
        name = findViewById(R.id.name);
        editName = findViewById(R.id.edit_name);;
        editPhone = findViewById(R.id.edit_phone);;
        editEmail = findViewById(R.id.edit_email);;
    }
    private void updateFields()
    {
        name.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("userName",""));
        editEmail.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("userEmail",""));
        editPhone.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("userPhone",""));
        editName.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("userName",""));
    }
}