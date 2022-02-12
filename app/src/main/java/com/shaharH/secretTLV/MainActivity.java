package com.shaharH.secretTLV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.shaharH.secretTLV.Adapters.ApartmentAdapter;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.Models.ImagesManager;
import com.shaharH.secretTLV.Utils.ApartmentManager;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView main_RV_apartments;
    private ApartmentAdapter apartmentAdapter;
    private ArrayList<Apartment> apartments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initRV();

    }

    private void initRV() {
        apartmentAdapter = new ApartmentAdapter(this, ApartmentManager.generateApartment());
        apartmentAdapter.setApartmentClickedListener(new ApartmentAdapter.ApartmentClickedListener() {
            @Override
            public void isFavoriteClicked(Apartment apartment, int position) {
                //save the opposite isFavorite
                apartment.setFavorite(!apartment.getFavorite());
               //notify that the specific view changed
                main_RV_apartments.getAdapter().notifyItemChanged(position);
            }

            @Override
            public void isCardClicked(Apartment apartment, int position) {
                //------------------intent---------------------------------

                //notify that the specific view changed
                main_RV_apartments.getAdapter().notifyItemChanged(position);
            }

            @Override
            public void isLeftClicked(Apartment apartment, int position) {
                ImagesManager imagesManager = apartment.getOP_ImagesManager();
                int currDisplay = imagesManager.getImageDisplayedPos();

                //currDisplay = max
                if(imagesManager.isDisplayedFirst())
                    return;
                imagesManager.setImageDisplayedPos(--currDisplay);
                main_RV_apartments.getAdapter().notifyItemChanged(position);
            }

            @Override
            public void isRightClicked(Apartment apartment, int position) {
                ImagesManager imagesManager = apartment.getOP_ImagesManager();
                int currDisplay = imagesManager.getImageDisplayedPos();

                //currDisplay = max
                if(imagesManager.isDisplayedLast())
                    return;
                imagesManager.setImageDisplayedPos(++currDisplay);
                main_RV_apartments.getAdapter().notifyItemChanged(position);
            }
        });


        main_RV_apartments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        main_RV_apartments.setHasFixedSize(true);
        main_RV_apartments.setItemAnimator(new DefaultItemAnimator());
        main_RV_apartments.setNestedScrollingEnabled(false);
        main_RV_apartments.setAdapter(apartmentAdapter);
    }


    private void findViews() {
        main_RV_apartments = findViewById(R.id.main_RV_apartments);
    }
}