package com.shaharH.secretTLV.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.shaharH.secretTLV.Adapters.RecyclerviewAdapter;
import com.shaharH.secretTLV.Callback.CallbackNotifyDataChange;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.R;
import com.shaharH.secretTLV.Models.ApartmentRepository;
import com.shaharH.secretTLV.Utils.FilterActivity;

import java.util.ArrayList;


public class ApartmentsListActivity extends AppCompatActivity {
    private RecyclerView main_RV_apartments;
    private RecyclerviewAdapter recyclerviewAdapter, recyclerviewAdapterFilter;

    private MaterialButton sort_BTN;
//    private MaterialButton filter_BTN;
//    private MaterialButton map_BTN;

    private FilterActivity filterActivity;
    private ArrayList<Apartment> filterList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartments_list);


        findViews();
        recyclerviewAdapter = new RecyclerviewAdapter(this, ApartmentRepository.getInstance().getApartments());
        initRVA(recyclerviewAdapter);
        initButtons();
    }


    private void initButtons() {
        initSort();
//        initFilter();
    }

/*
    private void initFilter() {
        filterActivity = new FilterActivity();
        filter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ApartmentsListActivity.this, FilterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                setNewAdapter(filterActivity.getFilterList());
                //Log.i("ApartmentsListActivity", "back from intent");
               //setNewAdapter(filterActivity.getFilterList());
            }
        });
        filterActivity.setCallbackFilterListReady(new FilterActivity.CallbackFilterListReady() {
            @Override
            public void setFilterList(ArrayList<Apartment> filterList) {
                setNewAdapter(filterList);
            }
        });
    }


    private void setNewAdapter(ArrayList<Apartment> filterList) {
        if (!(filterList==null)) {
            recyclerviewAdapterFilter = new RecyclerviewAdapter(this,filterList);
            initRVA(recyclerviewAdapterFilter);
        }
    }

 */

    private void initSort() {
        sort_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenuSort = new PopupMenu(ApartmentsListActivity.this, sort_BTN);

                // Inflating popup menu from popup_menu.xml file
                popupMenuSort.getMenuInflater().inflate(R.menu.sort_menu, popupMenuSort.getMenu());
                popupMenuSort.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.lowToHigh:
                                ApartmentRepository.getInstance().sortLTH();
                                main_RV_apartments.getAdapter().notifyDataSetChanged();
                                break;
                            case R.id.highToLow:
                                ApartmentRepository.getInstance().sortHTL();
                                main_RV_apartments.getAdapter().notifyDataSetChanged();
                                break;
                        }
                        return false;
                    }
                });
                // Showing the popup menu
                popupMenuSort.show();
            }
        });
    }

    private void initRVA(RecyclerviewAdapter recyclerviewAdapter) {
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
                //     main_RV_apartments.getAdapter().notifyItemChanged(position);
            }
        });

        main_RV_apartments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        main_RV_apartments.setHasFixedSize(true);
        main_RV_apartments.setItemAnimator(new DefaultItemAnimator());
        main_RV_apartments.setNestedScrollingEnabled(false);
        main_RV_apartments.setAdapter(recyclerviewAdapter);

        //register to notify about childEventListener(fireBase)
        ApartmentRepository.getInstance().setCallbackNotifyDataChange(callbackNotifyDataChange);
    }

    private void findViews() {
        main_RV_apartments = findViewById(R.id.main_RV_apartments);
        sort_BTN = findViewById(R.id.sort_BTN);
        //       filter_BTN = findViewById(R.id.filter_BTN);
        //       map_BTN =  findViewById(R.id.map_BTN);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ApartmentRepository.getInstance().getOriginalList();
        finish();
    }


    CallbackNotifyDataChange callbackNotifyDataChange = new CallbackNotifyDataChange() {
        @Override
        public void notifyDataChange() {
            main_RV_apartments.getAdapter().notifyDataSetChanged();
        }
    };


}