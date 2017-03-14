package com.example.fragmentmanagement.FragmentController.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fragmentmanagement.FragmentController.BaseListFragment;
import com.example.fragmentmanagement.FragmentController.FragmentMapper;
import com.example.fragmentmanagement.FragmentController.FragmentRegister;
import com.example.fragmentmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseListFragment {
    private static final List<FragmentMapper> ENTRIES = new ArrayList<FragmentMapper>();

    static {
//        ENTRIES.add(new Entry("Pass Data", new Request(PassData.class)));
//        ENTRIES.add(new Entry("Receive Result",
//                new Request(ReceiveResult.class)));
        ENTRIES.add(new FragmentMapper("PageAnimationFragment", new FragmentRegister(PageAnimationFragment.class)));
//        ENTRIES.add(new Entry("Themes", new Request(Themes.class)));
//        ENTRIES.add(new Entry("Slideable", new Request(Slideable.class)));
//        ENTRIES.add(new Entry("Soft Input", new Request(SoftInput.class)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        setListAdapter(new ArrayAdapter<FragmentMapper>(getActivity(),
                android.R.layout.simple_list_item_1, ENTRIES));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        startFragment(ENTRIES.get(position).mRegister);
    }

    @Override
    public String toString() {
        return "Home";
    }
}
