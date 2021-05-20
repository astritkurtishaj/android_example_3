package com.example.projekti_3.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.projekti_3.R;
import com.example.projekti_3.adapters.ProductAdapter;
import com.example.projekti_3.api.BeautyApi;
import com.example.projekti_3.models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeautyActivity extends AppCompatActivity {

    String brand = "maybelline";
    ConstraintLayout popupDialog;
    ProgressBar progressBar;
    ListView listView;
    ArrayList<Product> arrayList = new ArrayList<>();
    ProductAdapter adapter;
    Button btnTryAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);

        listView = findViewById(R.id.lvBeautyProducts);
        progressBar = findViewById(R.id.progressBar);
        popupDialog = findViewById(R.id.popupDialog);
        btnTryAgain = findViewById(R.id.btnTryAgain);


        makeApiCallAndLoadDataIntoListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(BeautyActivity.this,ProductDetailsActivity.class);
                Product product = arrayList.get(position);
                intent.putExtra("productObject", product);
                startActivity(intent);

            }
        });

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeApiCallAndLoadDataIntoListView();
                popupDialog.setVisibility(View.GONE);
            }
        });
    }

    private void makeApiCallAndLoadDataIntoListView() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BeautyApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BeautyApi api = retrofit.create(BeautyApi.class);

        Call<ArrayList<Product>> call = api.getProduct(brand);

        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {

                arrayList = response.body();
                adapter = new ProductAdapter(BeautyActivity.this,arrayList);
                listView.setAdapter(adapter);

                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable throwable) {
                popupDialog.setVisibility(View.VISIBLE);

            }
        });

    }

}