package com.shaharH.secretTLV.Models;

import com.shaharH.secretTLV.Utils.ImagesManager;

public class Apartment {
    public enum APARTMENT_KIND{BUILDING,PENTHOUSE,MINI_PENTHOUSE,GARDEN_APARTMENT
        ,DUPLEX,STUDIO_APARTMENT,PRIVATE_HOUSE,BASEMENT_APARTMENT,VACATION_APARTMENT}
    public enum NEIGHBORHOOD{NAHALAT_YITZHAK,KFAR_SHALEM,YAD_ELIYAHU,SHKHUNAT_HATIKVA
        ,SHAPIRA,FLORENTIN,NEOT_AFEKA,HAKIRYA,OLD_JAFFA,AJAMI,LEV_HAIR,BAVLI,NEVE_TZEDEK
        ,HATZAFON_HAYASHAN,KEREM_HATEMANIM,REVIVIM,SHIKUN_DAN,TZAHALA,RAMAT_HAHAYAL
        ,KIKAR_HAMEDINA,HADAR_YOSEF,TEL_AVIV_UNIVERSITY,KOKHAV_HATZAFON
        ,RAMAT_AVIV,GANEI_SHARONA,NEVE_SHAANAN,SHIKUN_TZAMERET,MONTEFIORE,RAMAT_HATAYASIM,KIRYAT_MEIR}

    private boolean isFavorite = false;


    //apartment details - must have - MH
    private NEIGHBORHOOD MH_neighborhood;
    private APARTMENT_KIND MH_apartmentKind;
    private String MH_street;
    private int MH_price;
    private double MH_numOfRoom;
    private Landlord MH_apartmentLandlord;

    //apartment details - optional - OP
    private ImagesManager OP_ImagesManager;
    private int OP_streetNum;
    private int OP_floor;
    private int OP_square_meter;
    private Boolean OP_parking=false;
    private Boolean OP_elevators=false;
    private Boolean OP_air_conditioning=false;
    private Boolean OP_terrace=false;
    private Boolean OP_storage=false;


    public Apartment(){
    };

    public String getMH_street() {
        return MH_street;
    }

    public Apartment setMH_street(String MH_street) {
        this.MH_street = MH_street;
        return this;
    }

    public NEIGHBORHOOD getMH_neighborhood() {
        return MH_neighborhood;
    }

    public Apartment setMH_neighborhood(NEIGHBORHOOD MH_neighborhood) {
        this.MH_neighborhood = MH_neighborhood;
        return this;
    }

    public int getOP_streetNum() {
        return OP_streetNum;
    }

    public Apartment setOP_streetNum(int OP_streetNum) {
        this.OP_streetNum = OP_streetNum;
        return this;
    }

    public int getOP_floor() {
        return OP_floor;
    }

    public Apartment setOP_floor(int OP_floor) {
        this.OP_floor = OP_floor;
        return this;
    }

    public boolean getFavorite() {
        return isFavorite;
    }

    public Apartment setFavorite(boolean favorite) {
        isFavorite = favorite;
        return this;
    }

    public int getMH_price() {
        return MH_price;
    }

    public Apartment setMH_price(int MH_price) {
        this.MH_price = MH_price;
        return this;
    }

    public double getMH_numOfRoom() {
        return MH_numOfRoom;
    }

    public Apartment setMH_numOfRoom(double MH_numOfRoom) {
        this.MH_numOfRoom = MH_numOfRoom;
        return this;
    }

       public Landlord getMH_apartmentLandlord() {
        return MH_apartmentLandlord;
    }

    public Apartment setMH_apartmentLandlord(Landlord MH_apartmentLandlord) {
        this.MH_apartmentLandlord = MH_apartmentLandlord;
        return this;
    }

    public ImagesManager getOP_ImagesManager() {
        return OP_ImagesManager;
    }

    public Apartment setOP_ImagesManager(ImagesManager OP_ImagesManager) {
        this.OP_ImagesManager = OP_ImagesManager;
        return this;
    }

    public APARTMENT_KIND getMH_apartmentKind() {
        return MH_apartmentKind;
    }

    public Apartment setMH_apartmentKind(APARTMENT_KIND MH_apartmentKind) {
        this.MH_apartmentKind = MH_apartmentKind;
        return this;
    }


    public Boolean getOP_parking() {
        return OP_parking;
    }

    public Apartment setOP_parking(Boolean OP_parking) {
        this.OP_parking = OP_parking;
        return this;
    }

    public Boolean getOP_elevators() {
        return OP_elevators;
    }

    public Apartment setOP_elevators(Boolean OP_elevators) {
        this.OP_elevators = OP_elevators;
        return this;
    }

    public Boolean getOP_air_conditioning() {
        return OP_air_conditioning;
    }

    public Apartment setOP_air_conditioning(Boolean OP_air_conditioning) {
        this.OP_air_conditioning = OP_air_conditioning;
        return this;
    }

    public Boolean getOP_terrace() {
        return OP_terrace;
    }

    public Apartment setOP_terrace(Boolean OP_terrace) {
        this.OP_terrace = OP_terrace;
        return this;
    }

    public Boolean getOP_storage() {
        return OP_storage;
    }

    public Apartment setOP_storage(Boolean OP_storage) {
        this.OP_storage = OP_storage;
        return this;
    }

    public int getOP_square_meter() {
        return OP_square_meter;
    }

    public Apartment setOP_square_meter(int OP_square_meter) {
        this.OP_square_meter = OP_square_meter;
        return this;
    }
}
