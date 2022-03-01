package com.shaharH.secretTLV.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shaharH.secretTLV.Callback.FilledInFragment;
import com.shaharH.secretTLV.Fragments.FragmentPart0;
import com.shaharH.secretTLV.Fragments.FragmentPart1;
import com.shaharH.secretTLV.Fragments.FragmentPart2;
import com.shaharH.secretTLV.Fragments.FragmentPart3;
import com.shaharH.secretTLV.Fragments.FragmentPart4;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.Models.Landlord;
import com.shaharH.secretTLV.Utils.FireBaseConnector;
import com.shaharH.secretTLV.R;
import com.shaharH.secretTLV.Utils.ImagesManager;


public class AddApartment extends AppCompatActivity {
    public static final int NUM_OF_VIEWS = 5;
    private RatingBar myRatingBar;
    private MaterialButton continue_BTN;
    private FilledInFragment[] fragments = new FilledInFragment[NUM_OF_VIEWS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartment);

        findViews();
        initFragments();
        initContinueBTN();
    }

    private void initFragments() {
        //Details 0 : neighborhood, street, street number, floor
        fragments[0] = new FragmentPart0();
        //Details 1: kind, number of rooms, sqm, price
        fragments[1] = new FragmentPart1();
        //Details 2: parking, elevator, air conditioning, terrace, storage
        fragments[2] = new FragmentPart2();
        //Details 3: images arrayList
        fragments[3] = new FragmentPart3();
        //Details 4: landlord name, landLord phone number
        fragments[4] = new FragmentPart4();


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.theFrame, (FragmentPart0) fragments[0])
                .commit();
    }

    private void initContinueBTN() {
        continue_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) myRatingBar.getRating();
                //the user fill all the necessary fields
                if (fragments[position].checkFillInFields()) {
                    myRatingBar.setRating(++position);
                    //The user has more information to provide
                    if (position <= NUM_OF_VIEWS-1) {
                            continue_BTN.setText("Finish");
                        //replace the fragment to the next one
                        loadNextFragment(position);
                    } else {
                        //The user has provided all the information
                        //and now we will create an apartment
                        createNewApartment();
                        finish();
                    }
                }
            }
        });
    }

    private void createNewApartment() {
        FragmentPart0 f0 = (FragmentPart0) fragments[0];
        FragmentPart1 f1 = (FragmentPart1) fragments[1];
        FragmentPart2 f2 = (FragmentPart2) fragments[2];
        FragmentPart3 f3 = (FragmentPart3) fragments[3];
        FragmentPart4 f4 = (FragmentPart4) fragments[4];

        Apartment apartment = new Apartment()
                .setStreet_MH(f0.getStreet())
                .setStreetNum_OP(f0.getStreetNun())
                .setFloor_OP(f0.getFloor())
                .setPrice_MH(f1.getPrice())
                .setNumOfRoom_MH(f1.getNumOfRooms())
                .setApartmentLandlord_MH(new Landlord().setUid(getUser()).setName(f4.getLandlordName()).setPhoneNumber(f4.getLandlordNum()))
                .setImagesManager_OP(new ImagesManager().setAllImages(f3.getUrlList()))
                .setApartmentKind_MH(f1.getKind())
                .setNeighborhood_MH(f0.getNeighborhood())
                .setParking_OP(f2.isParking())
                .setElevators_OP(f2.isElevator())
                .setAir_conditioning_OP(f2.isAirConditioning())
                .setTerrace_OP(f2.isTerrace())
                .setStorage_OP(f2.isStorage())
                .setSquare_meter_OP(f1.getSqm());

        FireBaseConnector.getInstance().addApartment(apartment);
    }

    private void loadNextFragment(int position) {
        //replace the fragment to the next one
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.theFrame, (Fragment) fragments[position])
                /*The user can later reverse the transaction and bring
                 back the previous fragment by pressing the Back button */
                .addToBackStack(null)
                .commit();
    }

    private void findViews() {
        myRatingBar = findViewById(R.id.myRatingBar);
        continue_BTN = findViewById(R.id.continue_BTN);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        int theRating = (int) myRatingBar.getRating();
        if (theRating == 0)
            finish();
        else
            myRatingBar.setRating(--theRating);
    }

    private String getUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            return user.getUid();
    }
}