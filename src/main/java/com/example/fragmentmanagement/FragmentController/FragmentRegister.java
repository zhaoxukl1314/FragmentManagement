package com.example.fragmentmanagement.FragmentController;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.fragmentmanagement.FragmentController.Interface.FragmentInterface;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description of your request to start a MasterFragment.
 */
public class FragmentRegister implements Parcelable, Cloneable {

    private String mFragmentName;

    private Bundle mExtras;

    public static final Creator<FragmentRegister> CREATOR = new Creator<FragmentRegister>() {
        public FragmentRegister createFromParcel(Parcel in) {
            return new FragmentRegister(in);
        }

        public FragmentRegister[] newArray(int size) {
            return new FragmentRegister[size];
        }
    };

    /**
     * Create an empty Request.
     */
    public FragmentRegister() {

    }

    public FragmentRegister(FragmentRegister o) {
        this.mFragmentName = o.mFragmentName;
        if (o.mExtras != null) {
            this.mExtras = new Bundle(o.mExtras);
        }
    }

    @Override
    protected Object clone() {
        return new FragmentRegister(this);
    }

    public FragmentRegister(Class<? extends FragmentInterface> clazz) {
        mFragmentName = clazz.getName();
    }

    /**
     * Create a Request from Parcel.
     */
    public FragmentRegister(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        mFragmentName = in.readString();
        mExtras = in.readBundle(getClass().getClassLoader());
    }

    public String getClassName() {
        return mFragmentName;
    }

    /**
     * Sets fragment's class name.
     */
    public void setClassName(String className) {
        if (className == null) throw new NullPointerException("class name is null");
        this.mFragmentName = className;
    }

    /**
     * Sets fragment's class.
     */
    public void setClass(Class<? extends BaseFragment> clazz) {
        this.mFragmentName = clazz.getName();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
