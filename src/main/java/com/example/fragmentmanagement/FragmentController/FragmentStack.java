package com.example.fragmentmanagement.FragmentController;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.fragmentmanagement.FragmentController.Interface.FragmentInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FragmentStack {

    private static final String TAG = "Records";

    private ArrayList<FragmentInterface> mFragments = new ArrayList<>();

    public void add(FragmentInterface fragment) {
//        fragment.setTargetFragment(
//                target == null ? null : target.getFragment(), requestCode);
        mFragments.add(fragment);
    }

    public void remove(FragmentInterface fragment) {
        int index = mFragments.indexOf(fragment);
        mFragments.remove(index);

        FragmentInterface f;
        for (int i = index; i < mFragments.size(); i++) {
            f = mFragments.get(i);
//            FragmentInterface target = (FragmentInterface) f.getTargetFragment();
//            if (target == fragment) {
//                f.setTargetFragment(null, -1);
//            }
        }
    }

    public int size() {
        return mFragments.size();
    }

    public int indexOf(FragmentInterface fragment) {
        return mFragments.indexOf(fragment);
    }

    public boolean has(FragmentInterface fragment) {
        return mFragments.contains(fragment);
    }

    public List<FragmentInterface> getFragments() {
        return Collections.unmodifiableList(mFragments);
    }

    public Bundle save(FragmentManager fragmentManager) {
        Bundle fragments = null;
//        for (int i = 0; i < mFragments.size(); i++) {
//            Fragment f = mFragments.get(i).getFragment();
//            if (f != null) {
//                if (fragments == null) {
//                    fragments = new Bundle();
//                }
//                String key = "f" + i;
//                fragmentManager.putFragment(fragments, key, f);
//            }
//        }
        return fragments;
    }

    public void restore(FragmentManager fragmentManager, Bundle fragments) {
        mFragments.clear();
        if (fragments != null) {
            Iterable<String> keys = fragments.keySet();
//            for (String key : keys) {
//                if (key.startsWith("f")) {
//                    int index = Integer.parseInt(key.substring(1));
//                    FragmentInterface f = (FragmentInterface) fragmentManager
//                            .getFragment(fragments, key);
//                    if (f != null) {
//                        while (mFragments.size() <= index) {
//                            mFragments.add(null);
//                        }
//                        f.setMenuVisibility(false);
//                        mFragments.set(index, f);
//                    } else {
//                        Log.w(TAG, "Bad fragment at key " + key);
//                    }
//                }
//            }
        }
    }
}
