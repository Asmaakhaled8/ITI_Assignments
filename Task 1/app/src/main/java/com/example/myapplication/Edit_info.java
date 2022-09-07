package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Edit_info extends AppCompatActivity {

    private Button mSave;
    private EditText mNewName;
    private EditText mNewEmail;
    private EditText mNewPhone;
    private TextView mName_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        actionBar();
        initiate();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("userName",mNewName.getText().toString());
                editor.putString("userEmail",mNewEmail.getText().toString());
                editor.putString("userPhone",mNewPhone.getText().toString());
                editor.commit();
                mName_text.setText(mNewName.getText().toString());
            }
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

    private void initiate(){
        mNewName = findViewById(R.id.save_name);
        mNewEmail = findViewById(R.id.save_email);
        mNewPhone = findViewById(R.id.save_phone);
        mSave = findViewById(R.id.save);
        mName_text = findViewById(R.id.name);
    }
}