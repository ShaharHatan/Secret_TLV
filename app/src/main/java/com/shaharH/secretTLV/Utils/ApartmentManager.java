package com.shaharH.secretTLV.Utils;

import com.shaharH.secretTLV.Models.Apartment;
import com.shaharH.secretTLV.Models.ImagesManager;
import com.shaharH.secretTLV.Models.Landlord;
import java.util.ArrayList;


public class ApartmentManager {
public static final int FLOOR_NOT_PROVIDED=-100 , STREET_NUM_NOT_PROVIDED=0, SQUARE_METER_NOT_PROVIDED=0;

   public static ArrayList<Apartment> generateApartment(){
      ArrayList<Apartment> apartments = new ArrayList<>();

      ArrayList<String> pic1 = new ArrayList<>();
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/9af2bf87571471.5dbc1331b25ef.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/aa18e987571471.5dbc1331b4b63.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/0f21a487571471.5dbc1331b33e8.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/da214087571471.5dbc1331b3ef2.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/6317b887571471.5dbc1331b2b2b.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/da11ae87571471.5dbc1331b0e03.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/a704b187571471.5dbc1331b4646.jpg");
      pic1.add("https://mir-s3-cdn-cf.behance.net/project_modules/fs/7b0f3e87571471.5dbc1331b1cca.jpg");

      apartments.add(new Apartment()
              .setMH_street("Pinkas")
              .setOP_streetNum(66)
              .setOP_floor(21)
              .setMH_price(8500)
              .setMH_numOfRoom(2.5)
              .setMH_apartmentLandlord(new Landlord("avi","0523344556"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic1))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.STUDIO_APARTMENT)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.SHIKUN_TZAMERET)
              .setOP_parking(false)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(SQUARE_METER_NOT_PROVIDED)
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
              .setMH_street("Allenby")
              .setOP_streetNum(60)
              .setOP_floor(2)
              .setMH_price(7000)
              .setMH_numOfRoom(3)
              .setMH_apartmentLandlord(new Landlord("alon","0527744596"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic2))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setOP_parking(true)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(false)
              .setOP_square_meter(70)
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
              .setMH_street("Hakishon")
              .setOP_streetNum(86)
              .setOP_floor(2)
              .setMH_price(4500)
              .setMH_numOfRoom(2.5)
              .setMH_apartmentLandlord(new Landlord("meir","0503300556"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic3))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.FLORENTIN)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(35)
      );

      ArrayList<String> pic4 = new ArrayList<>();

      apartments.add(new Apartment()
              .setMH_street("Derech hashalom")
              .setOP_streetNum(122)
              .setOP_floor(3)
              .setMH_price(6500)
              .setMH_numOfRoom(4)
              .setMH_apartmentLandlord(new Landlord("shimrit","0523329061"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic4))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.RAMAT_HATAYASIM)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(true)
              .setOP_square_meter(80)
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
              .setMH_street("Ben Yehoda")
              .setOP_streetNum(5)
              .setOP_floor(1)
              .setMH_price(7000)
              .setMH_numOfRoom(3)
              .setMH_apartmentLandlord(new Landlord("nadav","0507729161"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic5))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(false)
              .setOP_square_meter(65)
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
              .setMH_street("hashmonaim")
              .setOP_streetNum(85)
              .setOP_floor(2)
              .setMH_price(8000)
              .setMH_numOfRoom(2)
              .setMH_apartmentLandlord(new Landlord("Sharon","0527729111"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic6))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(true)
              .setOP_square_meter(60)
      );

      ArrayList<String> pic7 = new ArrayList<>();

      apartments.add(new Apartment()
              .setMH_street("natan alterman")
              .setOP_streetNum(STREET_NUM_NOT_PROVIDED)
              .setOP_floor(5)
              .setMH_price(6000)
              .setMH_numOfRoom(3.5)
              .setMH_apartmentLandlord(new Landlord("Moshit","0520002111"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic7))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.NEOT_AFEKA)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(true)
              .setOP_square_meter(70)
      );



      ArrayList<String> pic8 = new ArrayList<>();

      apartments.add(new Apartment()
              .setMH_street("Sderot washington")
              .setOP_streetNum(13)
              .setOP_floor(1)
              .setMH_price(3000)
              .setMH_numOfRoom(1)
              .setMH_apartmentLandlord(new Landlord("Eyal","0505981211"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic8))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.STUDIO_APARTMENT)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.FLORENTIN)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(30)
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
              .setMH_street("Israel galili")
              .setOP_streetNum(6)
              .setOP_floor(12)
              .setMH_price(16000)
              .setMH_numOfRoom(4)
              .setMH_apartmentLandlord(new Landlord("Orna","0506781210"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic9))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.PENTHOUSE)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.KOKHAV_HATZAFON)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(true)
              .setOP_square_meter(160)
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
              .setMH_street("Yoav")
              .setOP_streetNum(29)
              .setOP_floor(0)
              .setMH_price(24000)
              .setMH_numOfRoom(8)
              .setMH_apartmentLandlord(new Landlord("Michal","0506914014"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic10))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.VACATION_APARTMENT)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.TZAHALA)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(true)
              .setOP_square_meter(330)
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
              .setMH_street("Boney hair")
              .setOP_streetNum(STREET_NUM_NOT_PROVIDED)
              .setOP_floor(9)
              .setMH_price(10000)
              .setMH_numOfRoom(5.5)
              .setMH_apartmentLandlord(new Landlord("Mor","0506502224"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic11))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.DUPLEX)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.KOKHAV_HATZAFON)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(true)
              .setOP_square_meter(155)
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
              .setMH_street("Halotos")
              .setOP_streetNum(6)
              .setOP_floor(4)
              .setMH_price(10000)
              .setMH_numOfRoom(2)
              .setMH_apartmentLandlord(new Landlord("Nirit","0524971200"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic12))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.VACATION_APARTMENT)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.AJAMI)
              .setOP_parking(false)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(65)
      );


      ArrayList<String> pic13 = new ArrayList<>();

      apartments.add(new Apartment()
              .setMH_street("Yefet")
              .setOP_streetNum(14)
              .setOP_floor(4)
              .setMH_price(6000)
              .setMH_numOfRoom(2.5)
              .setMH_apartmentLandlord(new Landlord("yael","0501171200"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic13))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.OLD_JAFFA)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(SQUARE_METER_NOT_PROVIDED)
      );

      ArrayList<String> pic14 = new ArrayList<>();

      apartments.add(new Apartment()
              .setMH_street("Melchett")
              .setOP_streetNum(14)
              .setOP_floor(3)
              .setMH_price(14000)
              .setMH_numOfRoom(4.5)
              .setMH_apartmentLandlord(new Landlord("omri","0502171666"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic14))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.MINI_PENTHOUSE)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(false)
              .setOP_square_meter(102)
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
              .setMH_street("Harel")
              .setOP_streetNum(14)
              .setOP_floor(FLOOR_NOT_PROVIDED)
              .setMH_price(11500)
              .setMH_numOfRoom(4)
              .setMH_apartmentLandlord(new Landlord("omer","0502891666"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic15))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.GARDEN_APARTMENT)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.RAMAT_HATAYASIM)
              .setOP_parking(true)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(true)
              .setOP_square_meter(102)
      );

      ArrayList<String> pic16 = new ArrayList<>();
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_1_87jyXInT1A_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_2_K25yVZ2GPR_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_3_CfJm1OvxJx_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_4_jl9N4BFvH9_20220211.jpg");
      pic16.add("https://img.yad2.co.il/Pic/202202/11/2_6/o/y2_5_I5Bf1ZmR3e_20220211.jpg");

      apartments.add(new Apartment()
              .setMH_street("Kehilat riga")
              .setOP_streetNum(7)
              .setOP_floor(2)
              .setMH_price(5500)
              .setMH_numOfRoom(3)
              .setMH_apartmentLandlord(new Landlord("Maya","0522891002"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic16))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.NEOT_AFEKA)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(62)
      );


      ArrayList<String> pic17 = new ArrayList<>();
      pic17.add("https://img.yad2.co.il/Pic/202201/10/2_2/o/y2_1_07327_20220110210550.jpeg");
      pic17.add("https://img.yad2.co.il/Pic/202201/10/2_2/o/y2_5_03721_20220110210555.jpeg");
      pic17.add("https://img.yad2.co.il/Pic/202201/10/2_2/o/y2_6_08777_20220110210556.jpeg");


      apartments.add(new Apartment()
              .setMH_street("Kehilat kanada")
              .setOP_streetNum(15)
              .setOP_floor(1)
              .setMH_price(4300)
              .setMH_numOfRoom(2)
              .setMH_apartmentLandlord(new Landlord("Roei","0521143002"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic17))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.AJAMI)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(40)
      );


      ArrayList<String> pic18 = new ArrayList<>();

      apartments.add(new Apartment()
              .setMH_street("Dizengoff")
              .setOP_streetNum(114)
              .setOP_floor(2)
              .setMH_price(6700)
              .setMH_numOfRoom(3)
              .setMH_apartmentLandlord(new Landlord("Miri","0521188001"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic18))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.LEV_HAIR)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(SQUARE_METER_NOT_PROVIDED)
      );

      ArrayList<String> pic19 = new ArrayList<>();
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_1_GPQvVf6bna_20220202.jpg");
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_3_PxtcBP7EOj_20220202.jpg");
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_4_2OVXPEQRqm_20220202.jpg");
      pic19.add("https://img.yad2.co.il/Pic/202202/02/2_6/o/y2_5_io9SjY370o_20220202.jpg");

      apartments.add(new Apartment()
              .setMH_street("Halperin")
              .setOP_streetNum(7)
              .setOP_floor(3)
              .setMH_price(7700)
              .setMH_numOfRoom(3.5)
              .setMH_apartmentLandlord(new Landlord("Alon","0509367007"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic19))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BUILDING)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.HATZAFON_HAYASHAN)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(78)
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
              .setMH_street("Nahliel")
              .setOP_streetNum(1)
              .setOP_floor(6)
              .setMH_price(26000)
              .setMH_numOfRoom(5.5)
              .setMH_apartmentLandlord(new Landlord("Shalom","0509367121"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic20))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.DUPLEX)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.KEREM_HATEMANIM)
              .setOP_parking(true)
              .setOP_elevators(true)
              .setOP_air_conditioning(true)
              .setOP_terrace(true)
              .setOP_storage(false)
              .setOP_square_meter(120)
      );

      ArrayList<String> pic21 = new ArrayList<>();
      pic21.add("https://img.yad2.co.il/Pic/202112/29/2_2/o/y2_1_03125_20211229171624.jpeg");
      pic21.add("https://img.yad2.co.il/Pic/202112/29/2_2/o/y2_3_07376_20211229171628.jpeg");
      pic21.add("https://img.yad2.co.il/Pic/202112/29/2_2/o/y2_5_07894_20211229171630.jpeg");


      apartments.add(new Apartment()
              .setMH_street("Yom tov")
              .setOP_streetNum(3)
              .setOP_floor(FLOOR_NOT_PROVIDED)
              .setMH_price(6000)
              .setMH_numOfRoom(1)
              .setMH_apartmentLandlord(new Landlord("Shimrit","0522349807"))
              .setOP_ImagesManager(new ImagesManager().setAllImages(pic21))
              .setMH_apartmentKind(Apartment.APARTMENT_KIND.BASEMENT_APARTMENT)
              .setMH_neighborhood(Apartment.NEIGHBORHOOD.KEREM_HATEMANIM)
              .setOP_parking(false)
              .setOP_elevators(false)
              .setOP_air_conditioning(true)
              .setOP_terrace(false)
              .setOP_storage(false)
              .setOP_square_meter(50)
      );


      return apartments;
   };

}
