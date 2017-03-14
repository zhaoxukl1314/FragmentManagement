package com.example.fragmentmanagement.FragmentController.Interface;

import android.support.v4.app.Fragment;
import android.view.View;

import com.example.fragmentmanagement.FragmentController.FragmentManagement;
import com.example.fragmentmanagement.FragmentController.FragmentRegister;

/**
 * Created by zhaoxukl1314 on 17/3/14.
 */

public interface FragmentInterface {
    View getView();
    Fragment getFragment();
    FragmentManagement getFragmentManagement();
    void startFragment(FragmentRegister register);
    void startFragment(Class<? extends FragmentInterface> clazz);
}
