package com.shaharH.secretTLV.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.shaharH.secretTLV.Callback.FilledInFragment;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.R;


public class FragmentPart0 extends Fragment implements FilledInFragment {
    private TextInputLayout street_TIL;
    private TextInputLayout streetNum_TIL;
    private Spinner neighborhood_spinner;
    private TextInputLayout floor_TIL;
    private TextView errorMessage_TXT;

    private String street;
    private int streetNun;
    private Apartment.NEIGHBORHOOD neighborhood;
    private int floor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_part0, container, false);

        findViews(view);
        initSpinner();

        return view;
    }

    private void findViews(View view) {
        street_TIL = view.findViewById(R.id.street_TIL);
        streetNum_TIL = view.findViewById(R.id.streetNum_TIL);
        neighborhood_spinner = view.findViewById(R.id.neighborhood_spinner);
        floor_TIL = view.findViewById(R.id.floor_TIL);
        errorMessage_TXT = view.findViewById(R.id.errorMessage_TXT);
    }

    private void initSpinner() {

        /*
        The ArrayAdapter will be responsible for rendering every item in the
        neighborhood string array to the screen when the Java dropdown menu is accessed
       */

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this.getContext(), R.array.neighborhood, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        neighborhood_spinner.setAdapter(adapter);
        neighborhood_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //0 is null in the spinner array
                //o is a neighborhood on the enum => (position-1) to get the value of the enum
                if (position == 0)
                    neighborhood = null;
                else {
                    neighborhood = Apartment.NEIGHBORHOOD.values()[position - 1];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                neighborhood = null;
            }
        });
    }

    @Override
    public Boolean checkFillInFields() {
        errorMessage_TXT.setText("");
        setStreet();
        setStreetNun();
        setFloor();

        if (street == null) {
            errorMessage_TXT.setText("Please enter street name");
            return false;
        } else if (!checkOnlyAlphabet(street)) {
            errorMessage_TXT.setText("Please enter valid street name - alphabet only");
            return false;
        }
        if (neighborhood == null) {
            errorMessage_TXT.setText("Please select a neighborhood from the list");
            return false;
        }
        return true;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNun() {
        return streetNun;
    }

    public Apartment.NEIGHBORHOOD getNeighborhood() {
        return neighborhood;
    }

    public int getFloor() {
        return floor;
    }

    private void setStreet() {
        if (isEmpty(street_TIL.getEditText()))
            street = null;
        else
            street = street_TIL.getEditText().getText().toString();
    }

    private void setStreetNun() {
        if (isEmpty(streetNum_TIL.getEditText()))
            streetNun = Apartment.STREET_NUM_NOT_PROVIDED;
        else
            streetNun = Integer.parseInt(streetNum_TIL.getEditText().getText().toString());
    }

    private void setFloor() {
        if (isEmpty(floor_TIL.getEditText()))
            floor = Apartment.FLOOR_NOT_PROVIDED;
        else
            floor = Integer.parseInt(floor_TIL.getEditText().getText().toString());
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private boolean checkOnlyAlphabet(String str) {
        if (!str.matches("[a-zA-Z]+"))
            return false;
        return true;
    }
}