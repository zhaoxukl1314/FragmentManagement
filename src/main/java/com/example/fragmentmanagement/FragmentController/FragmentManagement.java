package com.example.fragmentmanagement.FragmentController;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.fragmentmanagement.FragmentController.Fragment.HomeFragment;
import com.example.fragmentmanagement.FragmentController.Interface.FragmentInterface;
import com.example.fragmentmanagement.R;

import java.util.List;

/**
 * Created by zhaoxukl1314 on 17/3/14.
 */

public class FragmentManagement {

    public final static int FRAGMENT_CONTAINER_ID = R.id.internal_fragment_container;
    private FragmentActivity mActivity;
    private FragmentManager mFragmentManager;
    private FrameLayout mContentContainer;
    private FragmentsAdapter mAdapter;
    private FragmentViewPager mViewPager;
    private FragmentStack mFragmentStack;

    public FragmentManagement(FragmentActivity activity) {
        this.mActivity = activity;
    }

    public void initialize() {
        mContentContainer = (FrameLayout) mActivity.findViewById(R.id.container);
        mFragmentStack = new FragmentStack();
        initViewContainer();
//        startFragment(new FragmentRegister(HomeFragment.class));
    }

    private void initViewContainer() {
        mAdapter = new FragmentsAdapter();
        mViewPager = new FragmentViewPager(mActivity);
        mViewPager.setId(FRAGMENT_CONTAINER_ID);
        mViewPager.setOffscreenPageLimit(Integer.MAX_VALUE);
        mViewPager.setAdapter(mAdapter);
//        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mContentContainer.addView(mViewPager);
    }


    public void startFragment(FragmentRegister register) {
        mFragmentManager = mActivity.getSupportFragmentManager();
        FragmentInterface fragment = (FragmentInterface) newFragment(register.getClassName());
//        fragment.setRequest((FragmentRegister) register.clone());
        mFragmentManager.beginTransaction()
                .add(FRAGMENT_CONTAINER_ID, fragment.getFragment())
                .commitAllowingStateLoss();
        mFragmentManager.executePendingTransactions();
        mFragmentStack.add(fragment);
//        fragment.setPrimary(false);
//        setUpAnimator(fragment);
        onFragmentStarted(fragment);
    }

    private void onFragmentStarted(FragmentInterface fragment) {
        mAdapter.notifyDataSetChanged();
        int nextItem = mAdapter.getCount() - 1;
//        boolean smoothScroll = hasPageAnimator() && nextItem > 0;
        mViewPager.setCurrentItem(nextItem, true);
    }

    private Fragment newFragment(String className) {
        try {
            return (Fragment) Fragment.instantiate(mActivity,
                    className, new Bundle());
        } catch (Exception e) {
            throw new RuntimeException("No fragment found : { className="
                    + className + " }");
        }
    }

    private class FragmentsAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return getFragments().size();
        }

        @Override
        public int getItemPosition(Object object) {
            FragmentInterface fragment = (FragmentInterface) object;
            int position = indexOf(fragment);
            return position == -1 ? POSITION_NONE : position;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return getFragments().get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position,
                                   Object object) {
//            setPrimaryFragment((IMasterFragment) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return ((FragmentInterface) object).getView() == view;
        }
    }

    public int indexOf(FragmentInterface fragment) {
        return mFragmentStack.indexOf(fragment);
    }

    public List<FragmentInterface> getFragments() {
        return mFragmentStack.getFragments();
    }
}
