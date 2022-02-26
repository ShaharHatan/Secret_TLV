package com.shaharH.secretTLV.Models;

import com.shaharH.secretTLV.Utils.ImagesManager;

import java.util.Comparator;

public class Apartment implements Comparable<Apartment> {
    public static final int FLOOR_NOT_PROVIDED = -100, STREET_NUM_NOT_PROVIDED = 0,
            SQUARE_METER_NOT_PROVIDED = 0, NUM_OF_ROOMS_NOT_PROVIDED = 0, PRICE_NOT_PROVIDED = 0;




    public enum APARTMENT_KIND {
        BUILDING, PENTHOUSE, MINI_PENTHOUSE, GARDEN_APARTMENT, DUPLEX, STUDIO_APARTMENT, PRIVATE_HOUSE, BASEMENT_APARTMENT, VACATION_APARTMENT;
    }


    public enum NEIGHBORHOOD {
        NAHALAT_YITZHAK, KFAR_SHALEM, YAD_ELIYAHU, SHKHUNAT_HATIKVA, SHAPIRA, FLORENTIN, NEOT_AFEKA, HAKIRYA, OLD_JAFFA, AJAMI, LEV_HAIR, BAVLI, NEVE_TZEDEK, HATZAFON_HAYASHAN, KEREM_HATEMANIM, REVIVIM, SHIKUN_DAN, TZAHALA, RAMAT_HAHAYAL, KIKAR_HAMEDINA, HADAR_YOSEF, TEL_AVIV_UNIVERSITY, KOKHAV_HATZAFON, RAMAT_AVIV, GANEI_SHARONA, NEVE_SHAANAN, SHIKUN_TZAMERET, MONTEFIORE, RAMAT_HATAYASIM, KIRYAT_MEIR;
    }

    private static int counterUid = 0;

    private int uid;
//    private boolean isFavorite;
    //apartment details - must have - MH

    private NEIGHBORHOOD neighborhood_MH;
    private APARTMENT_KIND apartmentKind_MH;
    private String street_MH;
    private int price_MH;
    private double numOfRoom_MH;
    private Landlord apartmentLandlord_MH;
    //apartment details - optional - OP

    private ImagesManager imagesManager_OP;
    private int streetNum_OP;
    private int floor_OP;
    private int square_meter_OP;
    private Boolean parking_OP;
    private Boolean elevators_OP;
    private Boolean air_conditioning_OP;
    private Boolean terrace_OP;
    private Boolean storage_OP;
    public Apartment() {

    }


    public static String getEnumReadableName(Enum neighborhood) {
        return neighborhood.toString().toLowerCase().replace("_", " ");
    }

    public String getFullAddress() {
        return street_MH + " " + (streetNum_OP != Apartment.STREET_NUM_NOT_PROVIDED ? streetNum_OP : "");
    }

    public static void initialCounterId(int counter) {
        counterUid = counter;
    }

    @Override
    public int compareTo(Apartment other) {
        if (uid < other.getUid())
            return -1;
        else if (uid > other.getUid())
            return 1;
        else
            return 0;
    }



    public boolean equals(Object other){
        //check if other is Apartment
        if(!(other instanceof Apartment))
            return false;

        //casting other
        Apartment a = (Apartment) other;
        //return true if uid == other.uid
        return uid==a.getUid();
    }






    //------------------------          set         --------------------------------
    public Apartment setStreet_MH(String street_MH) {
        this.street_MH = street_MH;
        return this;
    }

    public Apartment setNeighborhood_MH(NEIGHBORHOOD neighborhood_MH) {
        this.neighborhood_MH = neighborhood_MH;
        return this;
    }

    public Apartment setStreetNum_OP(int streetNum_OP) {
        this.streetNum_OP = streetNum_OP;
        return this;
    }

    public Apartment setFloor_OP(int floor_OP) {
        this.floor_OP = floor_OP;
        return this;
    }

    /*
    public Apartment setFavorite(boolean favorite) {
        isFavorite = favorite;
        return this;
    }
     */

    public Apartment setPrice_MH(int price_MH) {
        this.price_MH = price_MH;
        return this;
    }

    public Apartment setNumOfRoom_MH(double numOfRoom_MH) {
        this.numOfRoom_MH = numOfRoom_MH;
        return this;
    }

    public Apartment setApartmentLandlord_MH(Landlord apartmentLandlord_MH) {
        this.apartmentLandlord_MH = apartmentLandlord_MH;
        return this;
    }

    public Apartment setImagesManager_OP(ImagesManager imagesManager_OP) {
        this.imagesManager_OP = imagesManager_OP;
        return this;
    }

    public Apartment setApartmentKind_MH(APARTMENT_KIND apartmentKind_MH) {
        this.apartmentKind_MH = apartmentKind_MH;
        return this;
    }

    public Apartment setParking_OP(Boolean parking_OP) {
        this.parking_OP = parking_OP;
        return this;
    }

    public Apartment setElevators_OP(Boolean elevators_OP) {
        this.elevators_OP = elevators_OP;
        return this;
    }

    public Apartment setAir_conditioning_OP(Boolean air_conditioning_OP) {
        this.air_conditioning_OP = air_conditioning_OP;
        return this;
    }

    public Apartment setTerrace_OP(Boolean terrace_OP) {
        this.terrace_OP = terrace_OP;
        return this;
    }

    public Apartment setStorage_OP(Boolean storage_OP) {
        this.storage_OP = storage_OP;
        return this;
    }

    public Apartment setSquare_meter_OP(int square_meter_OP) {
        this.square_meter_OP = square_meter_OP;
        return this;
    }

    public Apartment setUid() {
        uid = ++counterUid;
        return this;
    }



    //------------------------          get         --------------------------------
    public String getStreet_MH() {
        return street_MH;
    }

    public NEIGHBORHOOD getNeighborhood_MH() {
        return neighborhood_MH;
    }

    public int getStreetNum_OP() {
        return streetNum_OP;
    }

    public int getFloor_OP() {
        return floor_OP;
    }

    /*
    public boolean isFavorite() {
        return isFavorite;
    }
     */

    public int getPrice_MH() {
        return price_MH;
    }

    public double getNumOfRoom_MH() {
        return numOfRoom_MH;
    }

    public Landlord getApartmentLandlord_MH() {
        return apartmentLandlord_MH;
    }

    public ImagesManager getImagesManager_OP() {
        return imagesManager_OP;
    }

    public APARTMENT_KIND getApartmentKind_MH() {
        return apartmentKind_MH;
    }

    public Boolean getParking_OP() {
        return parking_OP;
    }

    public Boolean getElevators_OP() {
        return elevators_OP;
    }

    public Boolean getAir_conditioning_OP() {
        return air_conditioning_OP;
    }

    public Boolean getTerrace_OP() {
        return terrace_OP;
    }

    public Boolean getStorage_OP() {
        return storage_OP;
    }

    public int getSquare_meter_OP() {
        return square_meter_OP;
    }

    public int getUid() {
        return uid;
    }

}
