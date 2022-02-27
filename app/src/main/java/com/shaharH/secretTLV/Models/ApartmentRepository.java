package com.shaharH.secretTLV.Models;

import android.util.Log;

import com.shaharH.secretTLV.Callback.CallbackChildEvent;
import com.shaharH.secretTLV.Callback.CallbackNotifyDataChange;
import com.shaharH.secretTLV.R;
import com.shaharH.secretTLV.Utils.FireBaseConnector;

import java.util.ArrayList;
import java.util.Collections;

public class ApartmentRepository {
    private static ApartmentRepository apartmentRepository;
    private CallbackNotifyDataChange callbackNotifyDataChange;

    private ArrayList<Apartment> apartments;
    public ArrayList<Apartment> filterList;



    private ApartmentRepository() {
 //       apartments = new ArrayList<>();
        FireBaseConnector.getInstance().getAllApartments(new FireBaseConnector.Callback_apartmentsList() {
            @Override
            public void dataReady(ArrayList<Apartment> list) {
                apartments = list;
            }
        });

        FireBaseConnector.getInstance().setCallbackChildEvent(callbackChildEvent);
    }

    public static ApartmentRepository getInstance() {
        if (apartmentRepository == null)
            apartmentRepository = new ApartmentRepository();
        return apartmentRepository;
    }

    public static void init() {
        if (apartmentRepository == null)
            apartmentRepository = new ApartmentRepository();
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public void getOriginalList(){
        FireBaseConnector.getInstance().getAllApartments(new FireBaseConnector.Callback_apartmentsList() {
            @Override
            public void dataReady(ArrayList<Apartment> list) {
                apartments = list;
            }
        });
    }

    public void setCallbackNotifyDataChange(CallbackNotifyDataChange callbackNotifyDataChange){
        this.callbackNotifyDataChange = callbackNotifyDataChange;
    }

    public int getIndexFromUid(int uid) {
        int i;
        for (i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getUid() != uid)
                continue;
            break;
        }
        return i;
    }

    CallbackChildEvent callbackChildEvent = new CallbackChildEvent() {
        @Override
        public void apartmentAdd(Apartment newApartment) {
            if (apartments != null) {
                if (!apartments.contains(newApartment)) {
                    apartments.add(newApartment);
                    callbackNotifyDataChange.notifyDataChange();
                }
                Log.i("ApartmentRepository", "apartment " + newApartment.getUid() + " was added");
            }
        }

        @Override
        public void apartmentChange(Apartment newApartment) {
            if (apartments != null) {
                int position = getIndexFromUid(newApartment.getUid());
                apartments.set(position, newApartment);
                callbackNotifyDataChange.notifyDataChange();
            }
        }
    };

    //sort high to low
    public void sortHTL(){
        Collections.sort(apartments);
        Collections.reverse(apartments);
    }


    //sort low to high
    public void sortLTH(){
        Collections.sort(apartments);
    }


/*
   public static ArrayList<Apartment> generateFromHardcode(){
      ArrayList<Apartment> apartments = new ArrayList<>();

      ArrayList<String> pic1 = new ArrayList<>();
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/9af2bf87571471.5dbc1331b25ef.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/aa18e987571471.5dbc1331b4b63.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/0f21a487571471.5dbc1331b33e8.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/da214087571471.5dbc1331b3ef2.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/6317b887571471.5dbc1331b2b2b.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/da11ae87571471.5dbc1331b0e03.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/a704b187571471.5dbc1331b4646.jpg");

      apartments.add(new Apartment()
              .setStreet_MH("Pinkas")
              .setStreetNum_OP(66)
              .setFloor_OP(21)
              .setPrice_MH(8500)
              .setNumOfRoom_MH(2.5)
              .setApartmentLandlord_MH(new Landlord("avi","0523344556"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic1))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.STUDIO_APARTMENT)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.SHIKUN_TZAMERET)
              .setParking_OP(false)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(Apartment.SQUARE_METER_NOT_PROVIDED)
      );


      ArrayList<String> pic2 = new ArrayList<>();
      pic2.add("https://cdn.vox-cdn.com/thumbor/BRvkR6ZhkTP6q4IsN40zuTuWm8A=/0x0:2364x1330/920x613/filters:focal(993x476:1371x854):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/52360283/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_hero.0.jpeg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/5-RGSeftgVCj9LYBdcXIC8r5-3E=/0x0:2364x1578/1120x0/filters:focal(0x0:2364x1578):format(webp):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671949/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_2364_col_19.jpg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/kRtNDApF3yhKt5Pk0VuA_lhr8NQ=/0x0:2364x1578/1120x0/filters:focal(0x0:2364x1578):format(webp):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671953/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_2364_col_0.jpg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/p0z8xXduYcTGl2hwHs5o6BwfnvU=/0x0:2364x1578/1120x0/filters:focal(0x0:2364x1578):format(webp):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671955/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_2364_col_1.jpg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/atrdNAszQvuxhz3ee42wppNKMbg=/0x0:2364x1578/1120x0/filters:focal(0x0:2364x1578):format(webp):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671963/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_2364_col_7.jpg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/w4OrsSv8jqi46dxsJxvXpfQa45s=/0x0:2364x1578/1120x0/filters:focal(0x0:2364x1578):format(webp):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671967/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_2364_col_8.jpg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/vRZK9a2fKqBXXfG4R9Vs-Jkthqw=/0x0:2364x1578/1120x0/filters:focal(0x0:2364x1578):format(webp):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671965/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_2364_col_6.jpg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/1F1ba_DVs9Z7xXvzTAENx3ZeNpQ=/0x0:2364x1578/1120x0/filters:focal(0x0:2364x1578):format(webp):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671975/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_2364_col_14.jpg");
      pic2.add("https://cdn.vox-cdn.com/thumbor/0ZXzFLJwhDU9Vgk4cb8wtovK1gU=/1000x0/filters:no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/7671989/bauhaus_apartment_maayan_zusman_amir_navon_interiors_residential_dezeen_floor_plan.gif");

      apartments.add(new Apartment()
              .setStreet_MH("Allenby")
              .setStreetNum_OP(60)
              .setFloor_OP(2)
              .setPrice_MH(7000)
              .setNumOfRoom_MH(3)
              .setApartmentLandlord_MH(new Landlord("alon","0527744596"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic2))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setParking_OP(true)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(false)
              .setSquare_meter_OP(70)
      );


      ArrayList<String> pic3 = new ArrayList<>();
      pic3.add("https://img.yad2.co.il/Pic/202111/18/2_2/o/y2_2_01656_20211118170805.jpeg");
      pic3.add("https://img.yad2.co.il/Pic/202111/18/2_2/o/y2_3_02416_20211118170807.jpeg");
      pic3.add("https://img.yad2.co.il/Pic/202111/18/2_2/o/y2_5_06684_20211118170810.jpeg");
      pic3.add("https://img.yad2.co.il/Pic/202111/18/2_2/o/y2_4_09989_20211118170808.jpeg");
      pic3.add("https://img.yad2.co.il/Pic/202111/18/2_2/o/y2_6_01963_20211118170812.jpeg");
      pic3.add("https://img.yad2.co.il/Pic/202111/18/2_2/o/y2_8_04926_20211118170814.jpeg");
      pic3.add("https://img.yad2.co.il/Pic/202111/18/2_2/o/y2_9_01357_20211118170816.jpeg");

      apartments.add(new Apartment()
              .setStreet_MH("Hakishon")
              .setStreetNum_OP(86)
              .setFloor_OP(2)
              .setPrice_MH(4500)
              .setNumOfRoom_MH(2.5)
              .setApartmentLandlord_MH(new Landlord("meir","0503300556"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic3))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.FLORENTIN)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(35)
      );

      ArrayList<String> pic4 = new ArrayList<>();

      apartments.add(new Apartment()
              .setStreet_MH("Derech hashalom")
              .setStreetNum_OP(122)
              .setFloor_OP(3)
              .setPrice_MH(6500)
              .setNumOfRoom_MH(4)
              .setApartmentLandlord_MH(new Landlord("shimrit","0523329061"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic4))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.RAMAT_HATAYASIM)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(true)
              .setSquare_meter_OP(80)
      );

      ArrayList<String> pic5 = new ArrayList<>();
      pic5.add("https://img.yad2.co.il/Pic/202201/09/2_2/o/y2_2_09667_20220109133137.jpeg");
      pic5.add("https://img.yad2.co.il/Pic/202201/09/2_2/o/y2_3_01967_20220109133142.jpeg");
      pic5.add("https://img.yad2.co.il/Pic/202201/09/2_2/o/y2_4_01027_20220109133145.jpeg");
      pic5.add("https://img.yad2.co.il/Pic/202201/09/2_2/o/y2_5_05457_20220109133149.jpeg");
      pic5.add("https://img.yad2.co.il/Pic/202201/18/2_2/o/y2_6_04982_20220118154744.jpeg");
      pic5.add("https://img.yad2.co.il/Pic/202201/09/2_2/o/y2_7_03149_20220109133156.jpeg");
      pic5.add("https://img.yad2.co.il/Pic/202201/09/2_2/o/y2_8_09484_20220109133159.jpeg");
      pic5.add("https://img.yad2.co.il/Pic/202201/18/2_2/o/y2_10_08202_20220118154215.jpeg");


      apartments.add(new Apartment()
              .setStreet_MH("Ben Yehoda")
              .setStreetNum_OP(5)
              .setFloor_OP(1)
              .setPrice_MH(7000)
              .setNumOfRoom_MH(3)
              .setApartmentLandlord_MH(new Landlord("nadav","0507729161"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic5))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(false)
              .setSquare_meter_OP(65)
      );

      ArrayList<String> pic6 = new ArrayList<>();
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_1_LSidfmZ8Ut_20220109.png");
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_3_yBITuw77Wo_20220109.jpg");
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_2_SEQdOUlVki_20220109.JPG");
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_5_cjiyUzdZc4_20220109.JPG");
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_4_A5ocd7oVPK_20220109.JPG");
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_8_FZ2mfRvRly_20220109.png");
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_6_X5XjSXeNad_20220109.JPG");
      pic6.add("https://img.yad2.co.il/Pic/202201/09/2_6/o/y2_7_xSIkSVESom_20220109.png");


      apartments.add(new Apartment()
              .setStreet_MH("hashmonaim")
              .setStreetNum_OP(85)
              .setFloor_OP(2)
              .setPrice_MH(8000)
              .setNumOfRoom_MH(2)
              .setApartmentLandlord_MH(new Landlord("Sharon","0527729111"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic6))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(true)
              .setSquare_meter_OP(60)
      );

      ArrayList<String> pic7 = new ArrayList<>();

      apartments.add(new Apartment()
              .setStreet_MH("natan alterman")
              .setStreetNum_OP(Apartment.STREET_NUM_NOT_PROVIDED)
              .setFloor_OP(5)
              .setPrice_MH(6000)
              .setNumOfRoom_MH(3.5)
              .setApartmentLandlord_MH(new Landlord("Moshit","0520002111"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic7))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.NEOT_AFEKA)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(true)
              .setSquare_meter_OP(70)
      );



      ArrayList<String> pic8 = new ArrayList<>();

      apartments.add(new Apartment()
              .setStreet_MH("Sderot washington")
              .setStreetNum_OP(13)
              .setFloor_OP(1)
              .setPrice_MH(3000)
              .setNumOfRoom_MH(1)
              .setApartmentLandlord_MH(new Landlord("Eyal","0505981211"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic8))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.STUDIO_APARTMENT)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.FLORENTIN)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(30)
      );


      ArrayList<String> pic9 = new ArrayList<>();
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/A.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/B.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/C.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/11/D.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/H.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/G.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/E.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/F.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/09/I.jpg");
      pic9.add("https://www.fineshmaker.com/wp/wp-content/uploads/2020/11/kidsroom.jpg");

      apartments.add(new Apartment()
              .setStreet_MH("Israel galili")
              .setStreetNum_OP(6)
              .setFloor_OP(12)
              .setPrice_MH(16000)
              .setNumOfRoom_MH(4)
              .setApartmentLandlord_MH(new Landlord("Orna","0506781210"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic9))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.PENTHOUSE)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.KOKHAV_HATZAFON)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(true)
              .setSquare_meter_OP(160)
      );

      ArrayList<String> pic10 = new ArrayList<>();
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_1_05452_20220201144327.jpeg");
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_2_03138_20220201144338.jpeg");
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_3_08884_20220201144348.jpeg");
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_4_04007_20220201144358.jpeg");
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_5_09939_20220201144416.jpeg");
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_6_07836_20220201144434.jpeg");
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_9_04383_20220201144522.jpeg");
      pic10.add("https://img.yad2.co.il/Pic/202202/01/2_2/o/y2_10_05763_20220201144524.jpeg");


      apartments.add(new Apartment()
              .setStreet_MH("Yoav")
              .setStreetNum_OP(29)
              .setFloor_OP(0)
              .setPrice_MH(24000)
              .setNumOfRoom_MH(8)
              .setApartmentLandlord_MH(new Landlord("Michal","0506914014"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic10))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.VACATION_APARTMENT)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.TZAHALA)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(true)
              .setSquare_meter_OP(330)
      );


      ArrayList<String> pic11 = new ArrayList<>();
      pic11.add("https://img.yad2.co.il/Pic/202201/24/2_6/o/y2_2_KPi5X4ezSX_20220124.png");
      pic11.add("https://img.yad2.co.il/Pic/202201/24/2_6/o/y2_4_9FJ0WhJS4D_20220124.png");
      pic11.add("https://img.yad2.co.il/Pic/202201/24/2_6/o/y2_5_sSlvH0JDW8_20220124.png");
      pic11.add("https://img.yad2.co.il/Pic/202201/24/2_6/o/y2_6_of9N6zgJnW_20220124.png");
      pic11.add("https://img.yad2.co.il/Pic/202201/24/2_6/o/y2_9_hJ5fTV1Slt_20220124.png");
      pic11.add("https://img.yad2.co.il/Pic/202201/24/2_6/o/y2_8_VS1t6xrqbA_20220124.png");
      pic11.add("https://img.yad2.co.il/Pic/202201/24/2_6/o/y2_7_STBPgxijM6_20220124.png");

      apartments.add(new Apartment()
              .setStreet_MH("Boney hair")
              .setStreetNum_OP(Apartment.STREET_NUM_NOT_PROVIDED)
              .setFloor_OP(9)
              .setPrice_MH(10000)
              .setNumOfRoom_MH(5.5)
              .setApartmentLandlord_MH(new Landlord("Mor","0506502224"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic11))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.DUPLEX)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.KOKHAV_HATZAFON)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(true)
              .setSquare_meter_OP(155)
      );

      ArrayList<String> pic12 = new ArrayList<>();
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-1.jpg");
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-2.jpg");
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-3.jpg");
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-4.jpg");
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-5.jpg");
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-6.jpg");
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-12.jpg");
      pic12.add("https://design-milk.com/images/2018/12/Ax3-Studio-ETN-10.jpg");

      apartments.add(new Apartment()
              .setStreet_MH("Halotos")
              .setStreetNum_OP(6)
              .setFloor_OP(4)
              .setPrice_MH(10000)
              .setNumOfRoom_MH(2)
              .setApartmentLandlord_MH(new Landlord("Nirit","0524971200"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic12))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.VACATION_APARTMENT)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.AJAMI)
              .setParking_OP(false)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(65)
      );


      ArrayList<String> pic13 = new ArrayList<>();

      apartments.add(new Apartment()
              .setStreet_MH("Yefet")
              .setStreetNum_OP(14)
              .setFloor_OP(4)
              .setPrice_MH(6000)
              .setNumOfRoom_MH(2.5)
              .setApartmentLandlord_MH(new Landlord("yael","0501171200"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic13))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.OLD_JAFFA)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(Apartment.SQUARE_METER_NOT_PROVIDED)
      );

      ArrayList<String> pic14 = new ArrayList<>();

      apartments.add(new Apartment()
              .setStreet_MH("Melchett")
              .setStreetNum_OP(14)
              .setFloor_OP(3)
              .setPrice_MH(14000)
              .setNumOfRoom_MH(4.5)
              .setApartmentLandlord_MH(new Landlord("omri","0502171666"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic14))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.MINI_PENTHOUSE)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(false)
              .setSquare_meter_OP(102)
      );

      ArrayList<String> pic15 = new ArrayList<>();
      pic15.add("https://img.yad2.co.il/Pic/202110/16/2_6/o/y2_1_2vVtIHNH46_20211016.jpg");
      pic15.add("https://img.yad2.co.il/Pic/202110/16/2_6/o/y2_3_caVcum9s4L_20211016.jpg");
      pic15.add("https://img.yad2.co.il/Pic/202110/16/2_6/o/y2_6_n2Cy65UZio_20211016.jpg");
      pic15.add("https://img.yad2.co.il/Pic/202110/16/2_6/o/y2_5_GNeAPFJep9_20211016.jpg");
      pic15.add("https://img.yad2.co.il/Pic/202110/16/2_6/o/y2_7_JCXVu8JcSX_20211016.jpg");
      pic15.add("https://img.yad2.co.il/Pic/202110/16/2_6/o/y2_8_ROSRW6n4Qm_20211016.jpg");
      pic15.add("https://img.yad2.co.il/Pic/202110/16/2_6/o/y2_11_nmykZpBcv1_20211016.jpg");

      apartments.add(new Apartment()
              .setStreet_MH("Harel")
              .setStreetNum_OP(14)
              .setFloor_OP(Apartment.FLOOR_NOT_PROVIDED)
              .setPrice_MH(11500)
              .setNumOfRoom_MH(4)
              .setApartmentLandlord_MH(new Landlord("omer","0502891666"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic15))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.GARDEN_APARTMENT)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.RAMAT_HATAYASIM)
              .setParking_OP(true)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(true)
              .setSquare_meter_OP(102)
      );

      ArrayList<String> pic16 = new ArrayList<>();
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_1_87jyXInT1A_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_2_K25yVZ2GPR_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_3_CfJm1OvxJx_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_4_jl9N4BFvH9_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_5_I5Bf1ZmR3e_20220211.jpg");

      apartments.add(new Apartment()
              .setStreet_MH("Kehilat riga")
              .setStreetNum_OP(7)
              .setFloor_OP(2)
              .setPrice_MH(5500)
              .setNumOfRoom_MH(3)
              .setApartmentLandlord_MH(new Landlord("Maya","0522891002"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic16))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.NEOT_AFEKA)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(62)
      );


      ArrayList<String> pic17 = new ArrayList<>();
      pic17.add("https://img.yad2.co.il/Pic/202201/10/2_2/o/y2_1_07327_20220110210550.jpeg");
      pic17.add("https://img.yad2.co.il/Pic/202201/10/2_2/o/y2_5_03721_20220110210555.jpeg");
      pic17.add("https://img.yad2.co.il/Pic/202201/10/2_2/o/y2_6_08777_20220110210556.jpeg");


      apartments.add(new Apartment()
              .setStreet_MH("Kehilat kanada")
              .setStreetNum_OP(15)
              .setFloor_OP(1)
              .setPrice_MH(4300)
              .setNumOfRoom_MH(2)
              .setApartmentLandlord_MH(new Landlord("Roei","0521143002"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic17))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.AJAMI)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(40)
      );


      ArrayList<String> pic18 = new ArrayList<>();

      apartments.add(new Apartment()
              .setStreet_MH("Dizengoff")
              .setStreetNum_OP(114)
              .setFloor_OP(2)
              .setPrice_MH(6700)
              .setNumOfRoom_MH(3)
              .setApartmentLandlord_MH(new Landlord("Miri","0521188001"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic18))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(Apartment.SQUARE_METER_NOT_PROVIDED)
      );

      ArrayList<String> pic19 = new ArrayList<>();
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_1_GPQvVf6bna_20220202.jpg");
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_3_PxtcBP7EOj_20220202.jpg");
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_4_2OVXPEQRqm_20220202.jpg");
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_5_io9SjY370o_20220202.jpg");

      apartments.add(new Apartment()
              .setStreet_MH("Halperin")
              .setStreetNum_OP(7)
              .setFloor_OP(3)
              .setPrice_MH(7700)
              .setNumOfRoom_MH(3.5)
              .setApartmentLandlord_MH(new Landlord("Alon","0509367007"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic19))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BUILDING)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.HATZAFON_HAYASHAN)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(78)
      );

      ArrayList<String> pic20 = new ArrayList<>();
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-4-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-86-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-25-new-copy.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-38-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-76-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-92-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-14-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-220-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-146-new.jpg");
      pic20.add("https://www.fineshmaker.com/wp/wp-content/uploads/2019/11/DiklaG-15.7.19-209new.jpg");

      apartments.add(new Apartment()
              .setStreet_MH("Nahliel")
              .setStreetNum_OP(1)
              .setFloor_OP(6)
              .setPrice_MH(26000)
              .setNumOfRoom_MH(5.5)
              .setApartmentLandlord_MH(new Landlord("Shalom","0509367121"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic20))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.DUPLEX)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.KEREM_HATEMANIM)
              .setParking_OP(true)
              .setElevators_OP(true)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(true)
              .setStorage_OP(false)
              .setSquare_meter_OP(120)
      );

      ArrayList<String> pic21 = new ArrayList<>();
      pic21.add("https://img.yad2.co.il/Pic/202112/29/2_2/o/y2_1_03125_20211229171624.jpeg");
      pic21.add("https://img.yad2.co.il/Pic/202112/29/2_2/o/y2_3_07376_20211229171628.jpeg");
      pic21.add("https://img.yad2.co.il/Pic/202112/29/2_2/o/y2_5_07894_20211229171630.jpeg");


      apartments.add(new Apartment()
              .setStreet_MH("Yom tov")
              .setStreetNum_OP(3)
              .setFloor_OP(Apartment.FLOOR_NOT_PROVIDED)
              .setPrice_MH(6000)
              .setNumOfRoom_MH(1)
              .setApartmentLandlord_MH(new Landlord("Shimrit","0522349807"))
              .setImagesManager_OP(new ImagesManager().setAllImages(pic21))
              .setApartmentKind_MH(Apartment.APARTMENT_KIND.BASEMENT_APARTMENT)
              .setNeighborhood_MH(Apartment.NEIGHBORHOOD.KEREM_HATEMANIM)
              .setParking_OP(false)
              .setElevators_OP(false)
              .setAir_conditioning_OP(true)
              .setTerrace_OP(false)
              .setStorage_OP(false)
              .setSquare_meter_OP(50)
      );


      for (Apartment a:apartments){
         FireBaseConnector.getInstance().addApartment(a);
      }

      return apartments;
   };

 */


}
