package com.shaharH.secretTLV.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.shaharH.secretTLV.Callback.FilledInFragment;
import com.shaharH.secretTLV.Fragments.FragmentPart0;
import com.shaharH.secretTLV.Fragments.FragmentPart1;
import com.shaharH.secretTLV.Fragments.FragmentPart2;
import com.shaharH.secretTLV.Fragments.FragmentPart3;
import com.shaharH.secretTLV.Fragments.FragmentPart4;
import com.shaharH.secretTLV.R;


public class AddApartment extends AppCompatActivity {
    private RatingBar myRatingBar;
    private FilledInFragment[] fragments = new FilledInFragment[5];
    private Button continue_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartment);

        findViews();
        initFragments();
        initViews();
    }


    private void initFragments() {
        fragments[0] = new FragmentPart0();
        fragments[1] = new FragmentPart1();
        fragments[2] = new FragmentPart2();
        fragments[3] = new FragmentPart3();
        fragments[4] = new FragmentPart4();


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.theFrame, (FragmentPart0) fragments[0])
                .commit();
    }

    private void initViews() {

        continue_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) myRatingBar.getRating();
                //the user fill all the necessary fields
                if (fragments[position].checkFillInFields()) {
                    //Rating Bar ++
                    myRatingBar.setRating(++position);
                    if (position < 5)
                        //replace the fragment to the next one
                        loadNextFragment(position);
                    else
                        createNewApartment();
                }
            }
        });

    }

    private void createNewApartment() {
    }

    private void loadNextFragment(int position) {
        //replace the fragment to the next one
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.theFrame,(Fragment) fragments[position])
                /*The user can later reverse the transaction and bring
                 back the previous fragment by pressing the Back button */
                .addToBackStack(null)
                .commit();
    }

    private void findViews() {
        myRatingBar = findViewById(R.id.myRatingBar);
        continue_BTN = findViewById(R.id.continue_BTN);

    }
}