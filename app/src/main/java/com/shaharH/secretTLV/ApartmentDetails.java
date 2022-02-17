package com.shaharH.secretTLV;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;
import com.shaharH.secretTLV.Models.Apartment;

public class ApartmentDetails extends AppCompatActivity {
    private Apartment apartment;
    private MaterialTextView apDetails_TXT_price;
    private MaterialTextView apDetails_TXT_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_details);

        findViews();
        getApartment();
        initViews();
    }

    private void getApartment() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("currentApartment");
        String json = bundle.getString("currentApartment");
        apartment = new Gson().fromJson(json, Apartment.class);
    }

    private void initViews() {
        apDetails_TXT_price.setText(""+apartment.getMH_price());
        apDetails_TXT_address.setText(apartment.getFullAddress());
    }

    private void findViews() {
        apDetails_TXT_price = findViewById(R.id.apDetails_TXT_price);
        apDetails_TXT_address = findViewById(R.id.apDetails_TXT_address);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}