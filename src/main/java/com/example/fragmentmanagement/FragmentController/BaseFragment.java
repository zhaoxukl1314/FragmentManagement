package com.example.fragmentmanagement.FragmentController;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;

import com.example.fragmentmanagement.FragmentController.Interface.ActivityInterface;
import com.example.fragmentmanagement.FragmentController.Interface.FragmentInterface;

/**
 * Created by zhaoxukl1314 on 17/3/14.
 */

public class BaseFragment extends Fragment implements FragmentInterface{
    private ActivityInterface mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ActivityInterface) {
            mActivity = (ActivityInterface) activity;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public Fragment getFragment() {
        return this;
    }

    @Override
    public FragmentManagement getFragmentManagement() {
        return mActivity.getFragmentManagement();
    }

    @Override
    public void startFragment(FragmentRegister register) {
        getFragmentManagement().startFragment(register);
    }

    @Override
    public void startFragment(Class<? extends FragmentInterface> clazz) {
        getFragmentManagement().startFragment(new FragmentRegister(clazz));
    }
}
