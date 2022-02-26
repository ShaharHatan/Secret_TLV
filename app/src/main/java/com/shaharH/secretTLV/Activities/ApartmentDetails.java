package com.shaharH.secretTLV.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.shaharH.secretTLV.Adapters.ViewPagerAdapter;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.R;
import com.shaharH.secretTLV.Models.ApartmentRepository;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ApartmentDetails extends AppCompatActivity {
    private Apartment apartment;

    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
//    private AppCompatImageView favorite_IMG;
    private Button contact_BTN;

    private MaterialTextView price_TXT, address_TXT, numOfRooms_TXT, floorNum_TXT, squareMetreNum_TXT, neighborhood_TXT, apartmentKind_TXT;
    private TextView storage_TXT, terrace_TXT, airConditioning_TXT, elevator_TXT, parking_TXT;
    private TextView landlordName_TXT;
    private MaterialButton landlordNum_BTN, landlordWhatsapp_BTN;

    //popup window
    private View popupView;
    private PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_details);

        findViews();
        getApartment();
        initPopUpWindow();
        initViews();
    }

    private void initPopUpWindow() {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.contact_popup_window, null);

        // create the popup window
        int width = 900;
        int height = 700;
        // focusable - lets taps outside the popup also dismiss it
        popupWindow = new PopupWindow(popupView, width, height, false);
    }

    private void getApartment() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("currentApartmentPos");
        int position = bundle.getInt("pos");
        apartment = ApartmentRepository.getInstance().getApartments().get(position);
    }

    /*
    private void initFavoriteIcon() {
        if (apartment.isFavorite())
            favorite_IMG.setImageResource(R.drawable.heart_filled);
        else
            favorite_IMG.setImageResource(R.drawable.heart_empty);
    }
     */

    private void initViews() {
        initSlideView();
/*
        initFavoriteIcon();
        favorite_IMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean currFavorite = apartment.isFavorite();
                //set local favorite
                apartment.setFavorite(!currFavorite);
                FireBaseConnector.getInstance().favoriteClicked(apartment);
                initFavoriteIcon();
            }
        });
 */

        price_TXT.setText("" + apartment.getPrice_MH() + " ₪");
        address_TXT.setText(apartment.getFullAddress() + " , Tel-Aviv");
        DecimalFormat df = new DecimalFormat("#.#");
        String roomNum = df.format(apartment.getNumOfRoom_MH());
        numOfRooms_TXT.setText(roomNum);
        floorNum_TXT.setText(apartment.getFloor_OP() != Apartment.FLOOR_NOT_PROVIDED ? "" + apartment.getFloor_OP() : "-");
        squareMetreNum_TXT.setText(apartment.getSquare_meter_OP() != Apartment.SQUARE_METER_NOT_PROVIDED ? "" + apartment.getSquare_meter_OP() : "-");
        neighborhood_TXT.setText(Apartment.getEnumReadableName(apartment.getNeighborhood_MH()));
        apartmentKind_TXT.setText(Apartment.getEnumReadableName(apartment.getApartmentKind_MH()));

        initCheckedIcon();

        contact_BTN.setOnClickListener(v -> {
            createContactPopUpWindow(v);
        });
    }

    private void initCheckedIcon() {
        int dStorage = apartment.getStorage_OP() == true ? R.drawable.checked : R.drawable.unchecked;
        storage_TXT.setCompoundDrawablesWithIntrinsicBounds(dStorage, 0, 0, 0);

        int dTerrace = apartment.getTerrace_OP() == true ? R.drawable.checked : R.drawable.unchecked;
        terrace_TXT.setCompoundDrawablesWithIntrinsicBounds(dTerrace, 0, 0, 0);

        int dAirConditioning = apartment.getAir_conditioning_OP() == true ? R.drawable.checked : R.drawable.unchecked;
        airConditioning_TXT.setCompoundDrawablesWithIntrinsicBounds(dAirConditioning, 0, 0, 0);

        int dElevator = apartment.getElevators_OP() == true ? R.drawable.checked : R.drawable.unchecked;
        elevator_TXT.setCompoundDrawablesWithIntrinsicBounds(dElevator, 0, 0, 0);

        int dParking = apartment.getParking_OP() == true ? R.drawable.checked : R.drawable.unchecked;
        parking_TXT.setCompoundDrawablesWithIntrinsicBounds(dParking, 0, 0, 0);

        storage_TXT.setCompoundDrawablePadding(25);
        terrace_TXT.setCompoundDrawablePadding(25);
        parking_TXT.setCompoundDrawablePadding(25);
        elevator_TXT.setCompoundDrawablePadding(25);
        airConditioning_TXT.setCompoundDrawablePadding(25);
    }

    private void initSlideView() {
        // Initializing the ViewPagerAdapter
        ArrayList<String> images = apartment.getImagesManager_OP().getAllImages();
        mViewPagerAdapter = new ViewPagerAdapter(this, images);
        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    private void createContactPopUpWindow(View view) {
        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        MaterialButton closePopUp_BTN = (MaterialButton) popupView.findViewById(R.id.closePopUp_BTN);

        closePopUp_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        landlordName_TXT = popupView.findViewById(R.id.landlordName_TXT);
        landlordNum_BTN = popupView.findViewById(R.id.landlordNum_BTN);
        landlordWhatsapp_BTN = popupView.findViewById(R.id.landlordWhatsapp_BTN);

        landlordName_TXT.setText(apartment.getApartmentLandlord_MH().getName());

        String number = apartment.getApartmentLandlord_MH().getPhoneNumber();

        landlordNum_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + apartment.getApartmentLandlord_MH().getPhoneNumber()));
                startActivity(callIntent);
            }
        });

        landlordWhatsapp_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact = number;
                String url = "https://api.whatsapp.com/send?phone=" + contact;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }

    private void findViews() {
        // Initializing the ViewPager Object
        mViewPager = findViewById(R.id.detailsImage_VP);
        price_TXT = findViewById(R.id.price_TXT);
        address_TXT = findViewById(R.id.address_TXT);
        numOfRooms_TXT = findViewById(R.id.numOfRooms_TXT);
        floorNum_TXT = findViewById(R.id.floorNum_TXT);
        squareMetreNum_TXT = findViewById(R.id.squareMetreNum_TXT);
        //favorite_IMG = findViewById(R.id.favorite_IMG);
        neighborhood_TXT = findViewById(R.id.neighborhood_TXT);
        apartmentKind_TXT = findViewById(R.id.apartmentKind_TXT);
        contact_BTN = findViewById(R.id.contact_BTN);
        storage_TXT = findViewById(R.id.storage_TXT);
        terrace_TXT = findViewById(R.id.terrace_TXT);
        airConditioning_TXT = findViewById(R.id.airConditioning_TXT);
        elevator_TXT = findViewById(R.id.elevator_TXT);
        parking_TXT = findViewById(R.id.parking_TXT);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
