package com.shaharH.secretTLV.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.textview.MaterialTextView;
import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.Models.ImagesManager;
import com.shaharH.secretTLV.R;
import com.shaharH.secretTLV.Utils.ApartmentManager;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ApartmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String IMAGE_NOT_PROVIDED = "https://cdn.w600.comps.canstockphoto.com/apartment-building-tower-clip-art-vector_csp39700164.jpg";
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private Activity activity;
    private ApartmentClickedListener apartmentClickedListener;

    public ApartmentAdapter(Activity activity, ArrayList<Apartment> apartments) {
        this.activity = activity;
        this.apartments = apartments;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_apartment_item_rv, parent, false);
        return new ApartmentViewHolder(view);
    }

    //onBindViewHolder - Connects between the data and the viewHolder
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //onBindViewHolder() get a generic viewHolder, we need to create a specific one
        //we do casting to the view holder(we make holder a specific one that handle in movies)
        ApartmentViewHolder apartVH = (ApartmentViewHolder) holder;
        Apartment currApart = apartments.get(position);
        // apartVH - the current view
        //currApart - the current DATA

        String price = "" + currApart.getMH_price() + "₪";
        String address = currApart.getMH_street() + " " + (currApart.getOP_streetNum() != ApartmentManager.STREET_NUM_NOT_PROVIDED ? currApart.getOP_streetNum() : "");
        DecimalFormat df = new DecimalFormat("#.#");
        String roomNum = df.format(currApart.getMH_numOfRoom());
        String floorNum = currApart.getOP_floor() != ApartmentManager.FLOOR_NOT_PROVIDED ? "" + currApart.getOP_floor() : "-";
        String squareMetreNum = currApart.getOP_square_meter() != ApartmentManager.SQUARE_METER_NOT_PROVIDED ? "" + currApart.getOP_square_meter() : "-";
        ImagesManager imagesManager = currApart.getOP_ImagesManager();
        String urlPic = imagesManager.getAllImages().isEmpty() ? IMAGE_NOT_PROVIDED : imagesManager.getAllImages().get(imagesManager.getImageDisplayedPos());

        //upload the data to the views:
        apartVH.apAdapter_TXT_price.setText(price);
        apartVH.apAdapter_TXT_address.setText(address);
        apartVH.apAdapter_TXT_roomsNum.setText(roomNum);
        apartVH.apAdapter_TXT_floorNum.setText(floorNum);
        apartVH.apAdapter_TXT_squareMetreNum.setText(squareMetreNum);

        Glide
                .with(activity)
                .load(urlPic)
                .into(apartVH.apAdapter_IMG_apartment);

        if (currApart.getFavorite())
            apartVH.apAdapter_IMG_favorite.setImageResource(R.drawable.heart_filled);
        else
            apartVH.apAdapter_IMG_favorite.setImageResource(R.drawable.heart_empty);
    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    public void setApartmentClickedListener(ApartmentClickedListener apartmentClickedListener) {
        this.apartmentClickedListener = apartmentClickedListener;
    }

    public interface ApartmentClickedListener {
        public void isFavoriteClicked(Apartment apartment, int position);
        public void isCardClicked(Apartment apartment, int position);
        public void isLeftClicked(Apartment apartment, int position,int imagePos);
        public void isRightClicked(Apartment apartment, int position,int imagePos);
    }

    //inner class
    public class ApartmentViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView apAdapter_IMG_apartment;
        private MaterialTextView apAdapter_TXT_price;
        private MaterialTextView apAdapter_TXT_address;
        private MaterialTextView apAdapter_TXT_roomsNum;
        private MaterialTextView apAdapter_TXT_floorNum;
        private MaterialTextView apAdapter_TXT_squareMetreNum;
        private AppCompatImageView apAdapter_IMG_favorite;
        private Button apAdapter_BTN_leftIMG;
        private Button apAdapter_BTN_rightIMG;


        //this constructor has input of itemView
        //this itemView is a specific view of one item
        //in the constructor we connect between the views and the items
        public ApartmentViewHolder(@NonNull View itemView) {
            super(itemView);
            findItemViews();
            initViews();
        }

        private void initViews() {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    apartmentClickedListener.isCardClicked(apartments.get(getAdapterPosition()), getAdapterPosition());
                }
            });

            apAdapter_IMG_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    apartmentClickedListener.isFavoriteClicked(apartments.get(getAdapterPosition()), getAdapterPosition());
                }
            });

            apAdapter_BTN_leftIMG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                   // int imagePos = apartments.get(getAdapterPosition()).getOP_ImagesManager().
                    //apartmentClickedListener.isRightClicked(apartments.get(getAdapterPosition()), getAdapterPosition(),);
                }
            });

        }

        private void findItemViews() {
            apAdapter_IMG_apartment = itemView.findViewById(R.id.apAdapter_IMG_apartment);
            apAdapter_TXT_price = itemView.findViewById(R.id.apAdapter_TXT_price);
            apAdapter_TXT_address = itemView.findViewById(R.id.apAdapter_TXT_address);
            apAdapter_TXT_roomsNum = itemView.findViewById(R.id.apAdapter_TXT_roomsNum);
            apAdapter_TXT_floorNum = itemView.findViewById(R.id.apAdapter_TXT_floorNum);
            apAdapter_TXT_squareMetreNum = itemView.findViewById(R.id.apAdapter_TXT_squareMetreNum);
            apAdapter_IMG_favorite = itemView.findViewById(R.id.apAdapter_IMG_favorite);
            apAdapter_BTN_leftIMG = itemView.findViewById(R.id.apAdapter_BTN_leftIMG);
            apAdapter_BTN_rightIMG = itemView.findViewById(R.id.apAdapter_BTN_rightIMG);
        }
    }
}
