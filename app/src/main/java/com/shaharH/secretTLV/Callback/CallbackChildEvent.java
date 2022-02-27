package com.shaharH.secretTLV.Callback;

import com.shaharH.secretTLV.Models.Apartment;

public interface CallbackChildEvent {
    void apartmentAdd(Apartment newApartment);
    void apartmentChange(Apartment newApartment);
}
