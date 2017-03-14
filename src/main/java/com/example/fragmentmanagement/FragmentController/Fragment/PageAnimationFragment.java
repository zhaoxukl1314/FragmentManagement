package com.example.fragmentmanagement.FragmentController.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fragmentmanagement.FragmentController.BaseFragment;
import com.example.fragmentmanagement.FragmentController.BaseListFragment;
import com.example.fragmentmanagement.FragmentController.FragmentMapper;
import com.example.fragmentmanagement.FragmentController.FragmentRegister;
import com.example.fragmentmanagement.FragmentController.annotation.Configuration;
import com.example.fragmentmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class PageAnimationFragment extends BaseListFragment {

    private static final List<FragmentMapper> ENTRIES = new ArrayList<FragmentMapper>();

    static {
        ENTRIES.add(new FragmentMapper("StackAnimator", new FragmentRegister(StackPage.class)));
        ENTRIES.add(new FragmentMapper("EnterOvershootAnimator", new FragmentRegister(
                EnterOvershootPage.class)));
        ENTRIES.add(new FragmentMapper("VerticalSlideAnimator", new FragmentRegister(
                VerticalSlidePage.class)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<FragmentMapper>(getActivity(),
                android.R.layout.simple_list_item_1, ENTRIES));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        FragmentMapper page = ENTRIES.get(position);
        startFragment(page.mRegister);
    }

    @Configuration(theme = R.style.AppTheme_MasterFragment_Transparent)
    public static class VerticalSlidePage extends BaseFragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.vertical_slide_animator_fragment,
                    container, false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                    finish();
                }
            });
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            // As this fragment performs vertical slide animation. Don't let
            // this kind of fragment to be horizontally slideable;
//            allowSwipeBack(false);
        }

//        @Override
//        public PageAnimator onCreatePageAnimator() {
//            return Animators.VERTICAL_SLIDE_ANIMATOR;
//        }
    }

    public static class EnterOvershootPage extends BaseFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.overshoot_slide_animator_fragment,
                    container, false);
        }

//        @Override
//        public PageAnimator onCreatePageAnimator() {
//            return Animators.ENTER_OVER_SHOOT_ANIMATOR;
//        }
    }

    public static class StackPage extends BaseFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.overshoot_slide_animator_fragment,
                    container, false);
        }

//        @Override
//        public PageAnimator onCreatePageAnimator() {
//            return Animators.STACK_ANIMATOR;
//        }
    }
}
