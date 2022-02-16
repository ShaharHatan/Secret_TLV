package com.shaharH.secretTLV.Models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.shaharH.secretTLV.Adapters.RecyclerviewAdapter;
import com.shaharH.secretTLV.Utils.ImagesManager;
import com.shaharH.secretTLV.R;
import com.shaharH.secretTLV.Utils.ApartmentManager;
import java.util.ArrayList;


public class ApartmentsActivity extends AppCompatActivity {
    private RecyclerView main_RV_apartments;
    private RecyclerviewAdapter recyclerviewAdapter;
    private ArrayList<Apartment> apartments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartments);

        findViews();
        initRV();

    }

    private void initRV() {
        recyclerviewAdapter = new RecyclerviewAdapter(this, ApartmentManager.generateApartment());
        recyclerviewAdapter.setRecyclerviewClickedListener(new RecyclerviewAdapter.RecyclerviewClickedListener() {
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
         //       main_RV_apartments.getAdapter().notifyItemChanged(position);
            }

        });

        main_RV_apartments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        main_RV_apartments.setHasFixedSize(true);
        main_RV_apartments.setItemAnimator(new DefaultItemAnimator());
        main_RV_apartments.setNestedScrollingEnabled(false);
        main_RV_apartments.setAdapter(recyclerviewAdapter);
    }

    private void findViews() {
        main_RV_apartments = findViewById(R.id.main_RV_apartments);
    }
}