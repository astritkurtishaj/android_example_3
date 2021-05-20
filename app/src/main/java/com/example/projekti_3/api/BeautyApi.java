package com.example.projekti_3.api;

import com.example.projekti_3.models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeautyApi {


    String BASE_URL = "http://makeup-api.herokuapp.com/api/v1/";



    @GET("products.json?")
    Call<ArrayList<Product>> getProduct(@Query("brand") String brand);


}
