package com.example.frana.animapets;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by frana on 24/11/2017.
 */

public class List_vitrine_cards {
    private String Desc;
    private int image;


    public List_vitrine_cards(String desc, int image) {
        Desc = desc;
        this.image = image;
    }

    public String getDesc() {
        return Desc;
    }

    public int getImage() {
        return image;
    }
}
