package com.example.fragmentmanagement.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.fragmentmanagement.FragmentController.FragmentManagement;
import com.example.fragmentmanagement.FragmentController.Interface.ActivityInterface;

/**
 * Created by zhaoxukl1314 on 17/3/14.
 */

public class BaseFragmentActivity extends FragmentActivity implements ActivityInterface{
    private FragmentManagement mFragmentManagement;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mFragmentManagement = new FragmentManagement(this);
    }

    @Override
    public FragmentManagement getFragmentManagement() {
        return mFragmentManagement;
    }
}
