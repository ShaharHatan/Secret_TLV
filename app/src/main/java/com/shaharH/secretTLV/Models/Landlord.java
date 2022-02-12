package com.shaharH.secretTLV.Models;

public class Landlord {
    private static int counter = 0;
    private int accountId = 1100;
    private String name;
    private String phoneNumber;

    public Landlord(String name, String phoneNumber) {
        accountId += (++counter);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Landlord(){
    }

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
