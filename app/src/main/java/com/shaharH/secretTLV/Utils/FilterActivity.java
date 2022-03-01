package com.shaharH.secretTLV.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.shaharH.secretTLV.Activities.ApartmentsListActivity;
import com.shaharH.secretTLV.Callback.CallbackNotifyDataChange;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.Models.ApartmentRepository;
import com.shaharH.secretTLV.R;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {
    private CallbackFilterListReady callbackFilterListReady;
    private ApartmentsListActivity activity;
    private static ArrayList<Apartment> filterList;

    private Button filter_BTN;
    private TextInputLayout maxPrice_TIL;
    private TextInputLayout minPrice_TIL;
    private CheckBox images_CBX;
    private CheckBox storage_CBX;
    private CheckBox terrace_CBX;
    private CheckBox airConditioning_CBX;
    private CheckBox elevator_CBX;
    private CheckBox parking_CBX;

    public interface CallbackFilterListReady {
        void setFilterList(ArrayList<Apartment> filterList);
    }

    public void setCallbackFilterListReady(CallbackFilterListReady callbackFilterListReady) {
        this.callbackFilterListReady = callbackFilterListReady;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        findViews();
        filterList = new ArrayList<>(ApartmentRepository.getInstance().getApartments());
        initViews();
    }

    private void initViews() {
        filter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FilterActivity", "init : " + filterList.size());
                setFilter();
                if (!(filterList == null))
                    //callbackFilterListReady.setFilterList(filterList);
                    finish();
            }
        });
    }

    public ArrayList<Apartment> getFilterList() {
        return filterList;
    }

    private void findViews() {
        parking_CBX = findViewById(R.id.parking_CBX);
        elevator_CBX = findViewById(R.id.elevator_CBX);
        airConditioning_CBX = findViewById(R.id.airConditioning_CBX);
        terrace_CBX = findViewById(R.id.terrace_CBX);
        storage_CBX = findViewById(R.id.storage_CBX);
        images_CBX = findViewById(R.id.images_CBX);
        minPrice_TIL = findViewById(R.id.minPrice_TIL);
        maxPrice_TIL = findViewById(R.id.maxPrice_TIL);
        filter_BTN = findViewById(R.id.filter_BTN);
    }

    private void setFilter() {
        if (parking_CBX.isChecked())
            filterParking();
        if (elevator_CBX.isChecked())
            filterElevator();
        if (airConditioning_CBX.isChecked())
            filterAirConditioning();
        if (terrace_CBX.isChecked())
            filterTerrace();
        if (storage_CBX.isChecked())
            filterStorage();
        if (images_CBX.isChecked())
            filterImages();
        if (!isEmpty(minPrice_TIL.getEditText())) {
            int minPrice = Integer.parseInt(minPrice_TIL.getEditText().getText().toString());
            filterMinPrice(minPrice);
        }
        if (!isEmpty(maxPrice_TIL.getEditText())) {
            int maxPrice = Integer.parseInt(maxPrice_TIL.getEditText().getText().toString());
            filterMinPrice(maxPrice);
        }
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void setActivity(ApartmentsListActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //only apartment with parking == true
    private void filterParking() {
        if (!(filterList == null)) {
            filterList.removeIf(apartment -> (!apartment.getParking_OP()));
            Log.i("FilterActivity", "parking : " + filterList.size());

        }
    }

    //only apartment with elevator == true
    private void filterElevator() {
        if (!(filterList == null)) {
            filterList.removeIf(apartment -> (!apartment.getElevators_OP()));
            Log.i("FilterActivity", "elevator : " + filterList.size());
        }
    }

    //only apartment with airConditioning == true
    private void filterAirConditioning() {
        if (!(filterList == null)) {
            filterList.removeIf(apartment -> (!apartment.getAir_conditioning_OP()));
            Log.i("FilterActivity", "airConditioning : " + filterList.size());
        }
    }

    //only apartment with terrace == true
    private void filterTerrace() {
        if (!(filterList == null)) {
            filterList.removeIf(apartment -> (!apartment.getTerrace_OP()));
            Log.i("FilterActivity", "terrace : " + filterList.size());
        }
    }

    //only apartment with storage == true
    private void filterStorage() {
        if (!(filterList == null)) {
            filterList.removeIf(apartment -> (!apartment.getStorage_OP()));
            Log.i("FilterActivity", "storage : " + filterList.size());
        }
    }

    private void filterImages() {
        if (!(filterList == null)) {
            filterList.removeIf(apartment -> (apartment.getImagesManager_OP().getNumOfImages() == 0));
            Log.i("FilterActivity", "filterImages : " + filterList.size());
        }
    }

    private void filterMinPrice(int minPrice) {
        if (!(filterList == null)){
            filterList.removeIf(apartment -> (apartment.getPrice_MH() < minPrice));
            Log.i("FilterActivity", "MinPrice : " + filterList.size());
        }
    }

    private void filterMaxPrice(int maxPrice) {
        if (!(filterList == null)){
            filterList.removeIf(apartment -> (apartment.getPrice_MH() > maxPrice));
            Log.i("FilterActivity", "MaxPrice : " + filterList.size());
        }
    }


}