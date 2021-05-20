package com.example.projekti_3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projekti_3.R;
import com.example.projekti_3.models.Product;
import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {

    ImageView ivProduct;
    TextView tvProductName, tvProductDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ivProduct = findViewById(R.id.ivProduct);
        tvProductName = findViewById(R.id.tvProductName);
        tvProductDescription = findViewById(R.id.tvProductDescription);


        Product product = (Product) getIntent().getSerializableExtra("productObject");

        Picasso.get().load(product.getImageUrl()).placeholder(R.mipmap.ic_launcher).into(ivProduct);
        tvProductName.setText("Product Name:\n" + product.getName());
        tvProductDescription.setText("Product Description:\n" + product.getDescription());



    }
}