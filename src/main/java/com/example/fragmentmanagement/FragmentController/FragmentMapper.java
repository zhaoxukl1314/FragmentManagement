package com.example.fragmentmanagement.FragmentController;


public class FragmentMapper {

    public String mTitle;
    public FragmentRegister mRegister;

    public FragmentMapper(String title,  FragmentRegister register) {
        mTitle = title;
        mRegister = register;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
