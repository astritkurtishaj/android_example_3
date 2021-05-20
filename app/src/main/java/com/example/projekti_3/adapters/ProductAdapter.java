package com.example.projekti_3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projekti_3.R;
import com.example.projekti_3.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    Context context;
    ArrayList<Product> arrayList;
    LayoutInflater layoutInflater;

    public ProductAdapter(Context context, ArrayList<Product> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = layoutInflater.inflate(R.layout.product_cell, null);
        ImageView ivProduct = view.findViewById(R.id.ivProduct);
        TextView tvBrandName = view.findViewById(R.id.tvBrandName);
        TextView tvProductName = view.findViewById(R.id.tvProductName);
        TextView tvProductPrice = view.findViewById(R.id.tvProductPrice);

        Product product = arrayList.get(position);

        Picasso.get().load(product.getImageUrl()).placeholder(R.mipmap.ic_launcher).into(ivProduct);

        tvBrandName.setText("Brand: " + product.getBrand());
        tvProductName.setText("Product Name: " + product.getName());
        tvProductPrice.setText("Product Price: "+product.getPrice());
        return view;
    }


}
