package com.example.projekti_3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.projekti_3.R;

import org.json.JSONException;
import org.json.JSONObject;

public class JSonParserActivity extends AppCompatActivity {

    String JSON_STRING = "{\"student\":{\"name\":\"Astrit Kurtishaj\",\"id\":\"7\",\"grade\":\"9.9\"}}";

    TextView tvStudentName, tvStudentId, tvStudentGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_son_parser_acivity);

        tvStudentName = findViewById(R.id.tvStudentName);
        tvStudentId = findViewById(R.id.tvStudentId);
        tvStudentGrade = findViewById(R.id.tvStudentGrade);

            try {

                JSONObject jsonObject = new JSONObject(JSON_STRING);
                JSONObject studentJsonObject = jsonObject.getJSONObject("student");


//                System.out.println("Student info: " +
//                        " ID: " + studentJsonObject.getString("id") +
//                        "Name: " + studentJsonObject.getString("name") +
//                        "Grade: "+ studentJsonObject.getString("grade"));


                tvStudentName.setText("Name: "+ studentJsonObject.getString("name"));
                tvStudentId.setText("Id: "+ studentJsonObject.getString("id"));
                tvStudentGrade.setText("Grade: "+studentJsonObject.getString("grade"));



            }catch (JSONException jsonException){
                jsonException.getMessage();
            }


    }
}
