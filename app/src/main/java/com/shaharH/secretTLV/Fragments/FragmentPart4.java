package com.shaharH.secretTLV.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.shaharH.secretTLV.Callback.FilledInFragment;
import com.shaharH.secretTLV.R;


public class FragmentPart4 extends Fragment implements FilledInFragment {
    private TextInputLayout landlordName_TIL;
    private TextInputLayout landlordNum_TIL;
    private TextView errorMessage_TXT;

    private String landlordName;
    private String landlordNum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_part4, container, false);

        findViews(view);
        initViews();

        return view;
    }

    private void initViews() {
    }

    private void findViews(View view) {
        landlordNum_TIL = view.findViewById(R.id.landlordNum_TIL);
        landlordName_TIL = view.findViewById(R.id.landlordName_TIL);
        errorMessage_TXT = view.findViewById(R.id.errorMessage_TXT);
    }

    @Override
    public Boolean checkFillInFields() {
        setLandlordName();
        setLandlordNum();
        errorMessage_TXT.setText("");
        if (landlordName == null) {
            errorMessage_TXT.setText("Please enter the contact name");
            return false;
        } else if (!checkOnlyAlphabet(landlordName)) {
            errorMessage_TXT.setText("Please enter the contact name - alphabet only");
            return false;
        }
        if (landlordNum == null) {
            errorMessage_TXT.setText("Please enter the contact number");
            return false;
        } else if (checkValidPhoneNumPrefix(landlordNum)) {
            errorMessage_TXT.setText("Phone number must start with the digit 0" +
                    "\nPlease enter valid contact number");
            return false;
        }
        return true;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public String getLandlordNum() {
        return landlordNum;
    }

    private void setLandlordName() {
        if (isEmpty(landlordName_TIL.getEditText()))
            landlordName = null;
        else
            landlordName = landlordName_TIL.getEditText().getText().toString();
    }

    private void setLandlordNum() {
        if (isEmpty(landlordNum_TIL.getEditText()))
            landlordNum = null;
        else
            landlordNum = landlordNum_TIL.getEditText().getText().toString();
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private boolean checkOnlyAlphabet(String str) {
        if (!str.matches("[a-zA-Z]+"))
            return false;
        return true;
    }

    private boolean checkValidPhoneNumPrefix(String str) {
        if (str.charAt(0) != 0)
            return false;
        return true;
    }

}