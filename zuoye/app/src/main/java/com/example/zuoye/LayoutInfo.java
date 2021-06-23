package com.example.zuoye;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.Observable;

public class LayoutInfo extends BaseObservable {
    private String btn1_name;
    private String text1_name;
    private String text2_name;
    private String text3_name;

    @Bindable
    public String getText3_name() {
        return text3_name;
    }

    public void setText3_name(String text3_name) {
        this.text3_name = text3_name;
        notifyPropertyChanged(BR.text3_name);
    }


    @Bindable
    public String getText1_name() {
        return text1_name;
    }

    public void setText1_name(String text1_name) {
        this.text1_name = text1_name;
        notifyPropertyChanged(BR.text1_name);
    }

    @Bindable
    public String getText2_name() {
        return text2_name;
    }

    public void setText2_name(String text2_name) {
        this.text2_name = text2_name;
        notifyPropertyChanged(BR.text2_name);
    }

    @Bindable
    public String getBtn1_name() {
        return btn1_name;
    }

    public void setBtn1_name(String btn1_name) {
        this.btn1_name = btn1_name;
        notifyPropertyChanged(BR.btn1_name);
    }
}
