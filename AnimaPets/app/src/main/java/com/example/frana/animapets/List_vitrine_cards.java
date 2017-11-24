package com.example.frana.animapets;

import android.media.Image;

/**
 * Created by frana on 24/11/2017.
 */

public class List_vitrine_cards {
    private String Desc;
    private Image image;


    public List_vitrine_cards(String desc, Image image) {
        Desc = desc;
        this.image = image;
    }

    public String getDesc() {
        return Desc;
    }

    public Image getImage() {
        return image;
    }
}
