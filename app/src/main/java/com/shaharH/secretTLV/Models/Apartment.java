package com.shaharH.secretTLV.Models;

import com.shaharH.secretTLV.Utils.ImagesManager;

public class Apartment {
    public static final int FLOOR_NOT_PROVIDED=-100 , STREET_NUM_NOT_PROVIDED=0,
            SQUARE_METER_NOT_PROVIDED=0,  NUM_OF_ROOMS_NOT_PROVIDED=0 , PRICE_NOT_PROVIDED=0;
    public enum APARTMENT_KIND{BUILDING,PENTHOUSE,MINI_PENTHOUSE,GARDEN_APARTMENT
        ,DUPLEX,STUDIO_APARTMENT,PRIVATE_HOUSE,BASEMENT_APARTMENT,VACATION_APARTMENT}
    public enum NEIGHBORHOOD{NAHALAT_YITZHAK,KFAR_SHALEM,YAD_ELIYAHU,SHKHUNAT_HATIKVA
        ,SHAPIRA,FLORENTIN,NEOT_AFEKA,HAKIRYA,OLD_JAFFA,AJAMI,LEV_HAIR,BAVLI,NEVE_TZEDEK
        ,HATZAFON_HAYASHAN,KEREM_HATEMANIM,REVIVIM,SHIKUN_DAN,TZAHALA,RAMAT_HAHAYAL
        ,KIKAR_HAMEDINA,HADAR_YOSEF,TEL_AVIV_UNIVERSITY,KOKHAV_HATZAFON
        ,RAMAT_AVIV,GANEI_SHARONA,NEVE_SHAANAN,SHIKUN_TZAMERET,MONTEFIORE,RAMAT_HATAYASIM,KIRYAT_MEIR}

    private boolean isFavorite = false;


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
    private Boolean parking_OP =false;
    private Boolean elevators_OP =false;
    private Boolean air_conditioning_OP =false;
    private Boolean terrace_OP =false;
    private Boolean storage_OP =false;


    public Apartment(){
    };

    public static String getEnumReadableName(Enum neighborhood){
        return neighborhood.toString().toLowerCase().replace("_", " ");
    }

    public String getStreet_MH() {
        return street_MH;
    }

    public Apartment setStreet_MH(String street_MH) {
        this.street_MH = street_MH;
        return this;
    }

    public NEIGHBORHOOD getNeighborhood_MH() {
        return neighborhood_MH;
    }

    public Apartment setNeighborhood_MH(NEIGHBORHOOD neighborhood_MH) {
        this.neighborhood_MH = neighborhood_MH;
        return this;
    }

    public int getStreetNum_OP() {
        return streetNum_OP;
    }

    public Apartment setStreetNum_OP(int streetNum_OP) {
        this.streetNum_OP = streetNum_OP;
        return this;
    }

    public int getFloor_OP() {
        return floor_OP;
    }

    public Apartment setFloor_OP(int floor_OP) {
        this.floor_OP = floor_OP;
        return this;
    }

    public boolean getFavorite() {
        return isFavorite;
    }

    public Apartment setFavorite(boolean favorite) {
        isFavorite = favorite;
        return this;
    }

    public int getPrice_MH() {
        return price_MH;
    }

    public Apartment setPrice_MH(int price_MH) {
        this.price_MH = price_MH;
        return this;
    }

    public double getNumOfRoom_MH() {
        return numOfRoom_MH;
    }

    public Apartment setNumOfRoom_MH(double numOfRoom_MH) {
        this.numOfRoom_MH = numOfRoom_MH;
        return this;
    }

       public Landlord getApartmentLandlord_MH() {
        return apartmentLandlord_MH;
    }

    public Apartment setApartmentLandlord_MH(Landlord apartmentLandlord_MH) {
        this.apartmentLandlord_MH = apartmentLandlord_MH;
        return this;
    }

    public ImagesManager getImagesManager_OP() {
        return imagesManager_OP;
    }

    public Apartment setImagesManager_OP(ImagesManager imagesManager_OP) {
        this.imagesManager_OP = imagesManager_OP;
        return this;
    }

    public APARTMENT_KIND getApartmentKind_MH() {
        return apartmentKind_MH;
    }

    public Apartment setApartmentKind_MH(APARTMENT_KIND apartmentKind_MH) {
        this.apartmentKind_MH = apartmentKind_MH;
        return this;
    }


    public Boolean getParking_OP() {
        return parking_OP;
    }

    public Apartment setParking_OP(Boolean parking_OP) {
        this.parking_OP = parking_OP;
        return this;
    }

    public Boolean getElevators_OP() {
        return elevators_OP;
    }

    public Apartment setElevators_OP(Boolean elevators_OP) {
        this.elevators_OP = elevators_OP;
        return this;
    }

    public Boolean getAir_conditioning_OP() {
        return air_conditioning_OP;
    }

    public Apartment setAir_conditioning_OP(Boolean air_conditioning_OP) {
        this.air_conditioning_OP = air_conditioning_OP;
        return this;
    }

    public Boolean getTerrace_OP() {
        return terrace_OP;
    }

    public Apartment setTerrace_OP(Boolean terrace_OP) {
        this.terrace_OP = terrace_OP;
        return this;
    }

    public Boolean getStorage_OP() {
        return storage_OP;
    }

    public Apartment setStorage_OP(Boolean storage_OP) {
        this.storage_OP = storage_OP;
        return this;
    }

    public int getSquare_meter_OP() {
        return square_meter_OP;
    }

    public Apartment setSquare_meter_OP(int square_meter_OP) {
        this.square_meter_OP = square_meter_OP;
        return this;
    }

    public String getFullAddress(){
       return street_MH + " " + (streetNum_OP != Apartment.STREET_NUM_NOT_PROVIDED ? streetNum_OP : "");
    }
}
