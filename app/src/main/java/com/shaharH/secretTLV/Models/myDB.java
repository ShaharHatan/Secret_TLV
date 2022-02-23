package com.shaharH.secretTLV.Models;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class myDB {
    private static myDB singletonDB;

    private FirebaseUser user;
    private FirebaseDatabase database;
    private DatabaseReference apartments_reference;
    private DatabaseReference users_reference;

    private myDB(){
    };


    public static myDB getInstance() {
        if (singletonDB == null) {
            singletonDB = new myDB();
/*
            singletonDB.database = FirebaseDatabase.getInstance();
            singletonDB.apartments_reference = singletonDB.database.getReference("Apartments");
            singletonDB.users_reference = singletonDB.database.getReference("Users");
            singletonDB.user = FirebaseAuth.getInstance().getCurrentUser();
 */
        }
        return singletonDB;
    }

    public void addApartment(Apartment apartment) {
        apartments_reference.child("random id").setValue(apartment);
    }
}
