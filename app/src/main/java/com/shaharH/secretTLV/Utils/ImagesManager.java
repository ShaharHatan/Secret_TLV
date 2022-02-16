package com.shaharH.secretTLV.Utils;

import java.util.ArrayList;

public class ImagesManager {
    public static final String IMAGE_NOT_PROVIDED = "https://cdn.w600.comps.canstockphoto.com/apartment-building-tower-clip-art-vector_csp39700164.jpg";
    private ArrayList<String> allImages = new ArrayList<>();

    public ImagesManager() {
    }

    public ArrayList<String> getAllImages() {
        return allImages;
    }

    public ImagesManager setAllImages(ArrayList<String> allImages) {
        if (allImages.isEmpty())
            this.allImages.add(IMAGE_NOT_PROVIDED);
        else
            this.allImages = allImages;
        return this;
    }

    public int getNumOfImages() {
        return allImages.size();
    }

}
