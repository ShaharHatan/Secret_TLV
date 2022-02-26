package com.shaharH.secretTLV.Utils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shaharH.secretTLV.Models.Apartment;

import java.util.ArrayList;

public class FireBaseConnector {
    private static FireBaseConnector singletonDB;

    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference apartments_ref;
    private static DatabaseReference counterUid_ref;



    public interface Callback_int {
        void dataReady(int i);
    }

    public interface Callback_apartmentsList {
        void dataReady(ArrayList<Apartment> list);
    }

    public interface Callback_child_event {
        void apartmentAdd(Apartment newApartment);
        void apartmentChange(Apartment newApartment, int uid);
    }

    private FireBaseConnector() {
        singletonDB.firebaseDatabase = FirebaseDatabase.getInstance();
        apartments_ref = firebaseDatabase.getReference("Apartments");
        counterUid_ref = firebaseDatabase.getReference("counter Uid");

    }

    public static FireBaseConnector getInstance() {
        if (singletonDB == null) {
            singletonDB = new FireBaseConnector();
            Log.i("FireBaseConnector", "singletonDB == NULL");

        }
        return singletonDB;
    }

    public void addApartment(Apartment apartment) {
        apartment.setUid();
        apartments_ref.child("" + apartment.getUid()).setValue(apartment);
        //save the current uid
        counterUid_ref.setValue(apartment.getUid());
    }

    public static void getCounterUid(Callback_int callBack_int) {
        if (callBack_int != null) {
            counterUid_ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.getValue(Integer.class) != null)
                        callBack_int.dataReady(snapshot.getValue(Integer.class));
                    else
                        callBack_int.dataReady(0);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    //one time when program start
    public void getAllApartments(Callback_apartmentsList callbackList) {
        if (callbackList != null) {
            apartments_ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ArrayList<Apartment> apartments = new ArrayList<>();
                    //on every Child in the dataSnapshot we do the next:
                    for (DataSnapshot apartment : snapshot.getChildren()) {
                        try {

                            //add every child of car from the DB to the ArrayList car
                            apartments.add(apartment.getValue(Apartment.class));
                        } catch (Exception e) {
                            apartments = null;
                        }
                    }
                    Log.i("FireBaseConnector", ""+snapshot.getChildrenCount());
                    callbackList.dataReady(apartments);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }


    public void setCallbackChildEvent(Callback_child_event callback_child_event) {
        apartments_ref.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Apartment newApartment = snapshot.getValue(Apartment.class);

                Log.i("key",snapshot.getKey());
                Log.i("num of apartments", ""+snapshot.getChildrenCount());
                //Log.i("info", "" + newApartment.getUid());


                callback_child_event.apartmentAdd(newApartment);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                int uid = snapshot.child("uid").getValue(Integer.class);
                Apartment newApartment = snapshot.getValue(Apartment.class);

                callback_child_event.apartmentChange(newApartment, uid);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }





/*
    public void favoriteClicked(Apartment apartment){
        apartments_ref.child(""+apartment.getUid()).child("favorite").setValue(apartment.isFavorite());
    }
        */

}
