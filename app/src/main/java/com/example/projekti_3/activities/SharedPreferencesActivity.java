package com.example.projekti_3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projekti_3.R;
import com.example.projekti_3.preferences.Preferences;

public class SharedPreferencesActivity extends AppCompatActivity {

    Button btnSaveData, btnRecoverData, btnClearData;
    EditText etName, etSurname, etSalary;
    CheckBox checkBoxRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        findViewById();

        boolean isChecked = Preferences.getBoolean(SharedPreferencesActivity.this,"checkbox");
        checkBoxRemember.setChecked(isChecked);
        etName.setText(Preferences.getString(SharedPreferencesActivity.this,"name"));
        etSurname.setText(Preferences.getString(SharedPreferencesActivity.this,"surname"));

        checkBoxRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked){
                    Preferences.saveString(SharedPreferencesActivity.this, "name", etName.getText().toString());
                    Preferences.saveString(SharedPreferencesActivity.this,"surname",etSurname.getText().toString());
                    Preferences.saveBoolean(SharedPreferencesActivity.this,"checkbox",true);
                }else {
                    Preferences.saveString(SharedPreferencesActivity.this, "name", "");
                    Preferences.saveString(SharedPreferencesActivity.this,"surname","");
                    Preferences.saveBoolean(SharedPreferencesActivity.this,"checkbox",false);
                }
            }
        });


        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etName.getText().length() > 0 && etSurname.getText().length() > 0 && etSalary.getText().length() > 0) {
                    Preferences.saveString(SharedPreferencesActivity.this, "name", etName.getText().toString());
                    Preferences.saveString(SharedPreferencesActivity.this, "surname", etSurname.getText().toString());
                    Preferences.saveDouble(SharedPreferencesActivity.this, "salary", Double.parseDouble(etSalary.getText().toString()));
                }else {
                    Toast.makeText(SharedPreferencesActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                }
            }
        });



        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etSurname.setText("");
                etSalary.setText("");
            }
        });

        btnRecoverData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salary = String.valueOf(Preferences.getDouble(SharedPreferencesActivity.this, "salary"));
                etName.setText(Preferences.getString(SharedPreferencesActivity.this,"name"));
                etSurname.setText(Preferences.getString(SharedPreferencesActivity.this,"surname"));
                etSalary.setText(salary);

            }
        });


    }

    private void findViewById() {
        btnSaveData = findViewById(R.id.btnSaveData);
        btnRecoverData = findViewById(R.id.btnRecoverData);
        btnClearData = findViewById(R.id.btnClearData);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etSalary = findViewById(R.id.etSalary);
        checkBoxRemember = findViewById(R.id.cbRemember);
    }
}