package com.shaharH.secretTLV;

import android.app.Application;

import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.Utils.FireBaseConnector;
import com.shaharH.secretTLV.Models.ApartmentRepository;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //TODO: Change to init();
        FireBaseConnector.getInstance();
        //initial id counter on Apartment class
        FireBaseConnector.getCounterUid(new FireBaseConnector.Callback_int() {
            @Override
            public void dataReady(int i) {
                Apartment.initialCounterId(i);
            }
        });
        ApartmentRepository.init();
    }

}
