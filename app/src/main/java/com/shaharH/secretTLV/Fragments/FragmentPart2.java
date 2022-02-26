package com.shaharH.secretTLV.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.shaharH.secretTLV.Callback.FilledInFragment;
import com.shaharH.secretTLV.R;


public class FragmentPart2 extends Fragment implements FilledInFragment {
    private CheckBox storage_CBX;
    private CheckBox terrace_CBX;
    private CheckBox airConditioning_CBX;
    private CheckBox elevator_CBX;
    private CheckBox parking_CBX;

    private boolean storage;
    private boolean terrace;
    private boolean airConditioning;
    private boolean elevator;
    private boolean parking;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_part2, container, false);

        findViews(view);

        return view;
    }


    private void findViews(View view) {
        storage_CBX = view.findViewById(R.id.storage_CBX);
        terrace_CBX = view.findViewById(R.id.terrace_CBX);
        airConditioning_CBX = view.findViewById(R.id.airConditioning_CBX);
        elevator_CBX = view.findViewById(R.id.elevator_CBX);
        parking_CBX = view.findViewById(R.id.parking_CBX);
    }

    @Override
    public Boolean checkFillInFields() {
        setParking();
        setTerrace();
        setAirConditioning();
        setElevator();
        setStorage();

        return true;
    }

    public boolean isStorage() {
        return storage;
    }

    public boolean isTerrace() {
        return terrace;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public boolean isElevator() {
        return elevator;
    }

    public boolean isParking() {
        return parking;
    }

    private void setStorage() {
        storage = storage_CBX.isChecked();
    }

    private void setTerrace() {
        terrace = terrace_CBX.isChecked();
    }

    private void setAirConditioning() {
        airConditioning = airConditioning_CBX.isChecked();
    }

    private void setElevator() {
        elevator = elevator_CBX.isChecked();
    }

    private void setParking() {
        parking = parking_CBX.isChecked();
    }
}