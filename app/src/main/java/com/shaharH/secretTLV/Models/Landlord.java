package com.shaharH.secretTLV.Models;

import java.util.ArrayList;

public class Landlord {
    private String uid;
    private String name;
    private String phoneNumber;
    private ArrayList<Integer> apartmentsUid = new ArrayList<>();


    public Landlord(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Landlord(){
    }

    public Landlord setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public Landlord setName(String name) {
        this.name = name;
        return this;
    }

    public Landlord setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Landlord setApartmentsUid(int apartmentsUid) {
        this.apartmentsUid.add(apartmentsUid);
        return this;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Integer> getApartmentsUid() {
        return apartmentsUid;
    }
}
