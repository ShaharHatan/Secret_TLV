package com.shaharH.secretTLV.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.shaharH.secretTLV.R;

public class HomeActivity extends AppCompatActivity {
    private MaterialButton BTN_Sort;
    private MaterialButton BTN_Filter;
    private MaterialButton BTN_Map;
    private Button renter_BTN;
    private Button landlord_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViews();
        initViews();
    }

    private void initViews() {
        renter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ApartmentsListActivity.class);
                startActivity(intent);
            }
        });

        landlord_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddApartment.class);
                startActivity(intent);
            }
        });

    }

    private void findViews() {
        BTN_Sort = findViewById(R.id.BTN_Sort);
        BTN_Filter = findViewById(R.id.BTN_Filter);
        BTN_Map = findViewById(R.id.BTN_Map);
        landlord_BTN = findViewById(R.id.landlord_BTN);
        renter_BTN = findViewById(R.id.renter_BTN);
    }
}