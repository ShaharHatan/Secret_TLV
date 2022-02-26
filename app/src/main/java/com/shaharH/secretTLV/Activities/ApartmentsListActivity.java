package com.shaharH.secretTLV.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.shaharH.secretTLV.Adapters.RecyclerviewAdapter;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.R;
import com.shaharH.secretTLV.Models.ApartmentRepository;


public class ApartmentsListActivity extends AppCompatActivity {
    private RecyclerView main_RV_apartments;
    private RecyclerviewAdapter recyclerviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartments_list);

        findViews();
        setCallbackNotifyChange();
        initRV();
    }


    private void setCallbackNotifyChange() {
        ApartmentRepository.getInstance().setSynchronousDB(new ApartmentRepository.CallbackNotifyChange() {
            @Override
            public void notifyDataChange() {
                main_RV_apartments.getAdapter().notifyDataSetChanged();
            }
        });
    }





    private void initRV() {
        recyclerviewAdapter = new RecyclerviewAdapter(this, ApartmentRepository.getInstance().getApartments());
        recyclerviewAdapter.setRecyclerviewClickedListener(new RecyclerviewAdapter.RecyclerviewClickedListener() {
            /*
            @Override
            public void isFavoriteClicked(Apartment apartment, int position) {
                //save the opposite isFavorite
                FireBaseConnector.getInstance().favoriteClicked(apartment.setFavorite(!apartment.isFavorite()));
            }
             */

            @Override
            public void isCardClicked(Apartment apartment, int position) {

                //------------------intent---------------------------------
                Intent intent = new Intent(ApartmentsListActivity.this, ApartmentDetails.class);
                Bundle bundle = new Bundle();
                bundle.putInt("pos", position);
                intent.putExtra("currentApartmentPos", bundle);
                startActivity(intent);
       //         main_RV_apartments.getAdapter().notifyItemChanged(position);
            }
        });

        main_RV_apartments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        main_RV_apartments.setHasFixedSize(true);
        main_RV_apartments.setItemAnimator(new DefaultItemAnimator());
        main_RV_apartments.setNestedScrollingEnabled(false);
        main_RV_apartments.setAdapter(recyclerviewAdapter);

    }

    private void findViews() {
        main_RV_apartments = findViewById(R.id.main_RV_apartments);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}