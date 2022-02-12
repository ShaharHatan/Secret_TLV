package com.shaharH.secretTLV.Models;

import java.util.ArrayList;

public class ImagesManager {
    private ArrayList<String> allImages = new ArrayList<>();
    private int imageDisplayedPos;

    public ImagesManager() {
    }

    public ArrayList<String> getAllImages() {
        return allImages;
    }

    public ImagesManager setAllImages(ArrayList<String> allImages) {
        this.allImages = allImages;
        imageDisplayedPos = 0;
        return this;
    }

    public int getImageDisplayedPos() {
        return imageDisplayedPos;
    }

    private void setImageDisplayedPos(int imageDisplayedPos) {
        this.imageDisplayedPos = imageDisplayedPos;
    }

    private int getNumOfImages(){
        return allImages.size();
    }

}
