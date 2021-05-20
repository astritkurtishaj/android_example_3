package com.example.projekti_3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projekti_3.R;
import com.example.projekti_3.adapters.ProductAdapter;

public class MainActivity extends AppCompatActivity {

    Button btnStaticFragments, btnDynamicFragments, btnSharedPreferences, btnWebView, btnJSonParser,
            btnCurrentLocation, btnBeautyProducts,  btnSideMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStaticFragments = findViewById(R.id.btnStaticFragment);
        btnDynamicFragments = findViewById(R.id.btnDynamicFragments);
        btnSharedPreferences = findViewById(R.id.btnSharedPreferences);
        btnWebView = findViewById(R.id.btnWebView);
        btnJSonParser = findViewById(R.id.btnJSonParser);
        btnCurrentLocation = findViewById(R.id.btnCurrentLocation);
        btnBeautyProducts = findViewById(R.id.btnBeautyProducts);
        btnSideMenu = findViewById(R.id.btnSideMenu);


        btnStaticFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaticFragmentHolderActivity.class);
                startActivity(intent);
            }
        });

        btnDynamicFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DynamicFragmentHolderActivity.class);
                startActivity(intent);
            }
        });

        btnSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
            }
        });

        btnJSonParser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JSonParserActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentLocationActivity.class);
                startActivity(intent);
            }
        });

        btnBeautyProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BeautyActivity.class);
                startActivity(intent);
            }
        });

        btnSideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SideMenuActivity.class);
                startActivity(intent);
            }
        });




    }
}