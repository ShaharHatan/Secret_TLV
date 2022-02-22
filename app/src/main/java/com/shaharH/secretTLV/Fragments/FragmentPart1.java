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


public class FragmentPart1 extends Fragment implements FilledInFragment {

    private TextInputLayout price_TIL;
    private TextInputLayout sqm_TIL;
    private TextInputLayout numOsRooms_TIL;
    private Spinner kind_spinner;
    private TextView errorMessage_TXT;

    private int price;
    private int sqm;
    private double numOfRooms;
    private Apartment.APARTMENT_KIND kind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_part1, container, false);

        findViews(view);
        initSpinner();

        return view;
    }

    private void findViews(View view) {
        price_TIL = view.findViewById(R.id.price_TIL);
        sqm_TIL = view.findViewById(R.id.sqm_TIL);
        numOsRooms_TIL = view.findViewById(R.id.numOsRooms_TIL);
        kind_spinner = view.findViewById(R.id.kind_spinner);
        errorMessage_TXT = view.findViewById(R.id.errorMessage_TXT);
    }

    private void initSpinner() {
/*
        The ArrayAdapter will be responsible for rendering every item in the
        neighborhood string array to the screen when the Java dropdown menu is accessed
       */

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this.getContext(), R.array.apartment_kind, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kind_spinner.setAdapter(adapter);
        kind_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //0 is null in the spinner array
                //o is a neighborhood on the enum => (position-1) to get the value of the enum
                if (position == 0)
                    kind = null;
                else {
                    kind = Apartment.APARTMENT_KIND.values()[position - 1];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                kind = null;
            }
        });
    }

    @Override
    public Boolean checkFillInFields() {
        errorMessage_TXT.setText("");
        setPrice();
        setNumOfRooms();
        setSqm();

        if (kind == null) {
            errorMessage_TXT.setText("Please select apartment kind from the list");
            return false;
        }
        if (numOfRooms == Apartment.NUM_OF_ROOMS_NOT_PROVIDED) {
            errorMessage_TXT.setText("Please enter the number of rooms");
            return false;
        } else if (numOfRooms < 1) {
            errorMessage_TXT.setText("Number of rooms can't be lower then 1" +
                    "\nPlease enter a valid value");
            return false;
        } else if (!checkValidFloatingPoint(numOfRooms)) {
            errorMessage_TXT.setText("The number of rooms must be in format 1,1.5,2,2.5 ...." +
                    "\nPlease enter a valid value");
            return false;
        }
        if (price == Apartment.PRICE_NOT_PROVIDED) {
            errorMessage_TXT.setText("Please enter the price per month");
            return false;
        }
        return true;
    }

    public double getNumOfRooms() {
        return numOfRooms;
    }

    public Apartment.APARTMENT_KIND getKind() {
        return kind;
    }

    public int getPrice() {
        return price;
    }

    public int getSqm() {
        return sqm;
    }

    private void setPrice() {
        if (isEmpty(price_TIL.getEditText()))
            price = Apartment.PRICE_NOT_PROVIDED;
        else
            price = Integer.parseInt(price_TIL.getEditText().getText().toString());
    }

    private void setSqm() {
        if (isEmpty(sqm_TIL.getEditText()))
            sqm = Apartment.SQUARE_METER_NOT_PROVIDED;
        else
            sqm = Integer.parseInt(sqm_TIL.getEditText().getText().toString());
    }

    private void setNumOfRooms() {
        if (isEmpty(numOsRooms_TIL.getEditText()))
            numOfRooms = Apartment.NUM_OF_ROOMS_NOT_PROVIDED;
        else
            numOfRooms = Float.parseFloat(numOsRooms_TIL.getEditText().getText().toString());
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private boolean checkValidFloatingPoint(double num) {
        int temp = (int) num;
        num -= temp;
        return num == 0 || num == 0.5;
    }
}