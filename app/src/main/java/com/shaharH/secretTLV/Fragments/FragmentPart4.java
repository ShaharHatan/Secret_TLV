package com.shaharH.secretTLV.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shaharH.secretTLV.Callback.FilledInFragment;
import com.shaharH.secretTLV.R;


public class FragmentPart4 extends Fragment implements FilledInFragment {
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_part4, container,false);

        findViews(view);
        initViews();

        return view;
    }

    private void initViews() {
    }

    private void findViews(View view) {
    }


    @Override
    public Boolean checkFillInFields() {
        return null;
    }


}