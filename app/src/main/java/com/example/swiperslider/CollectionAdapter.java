package com.example.swiperslider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class CollectionAdapter extends FragmentStateAdapter {
    List<String> titleList;

    public CollectionAdapter(Fragment fragment, List<String> titleList) {
        super(fragment);
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new ObjectFragment();
        Bundle args = new Bundle();

        // Our object is just an integer :-P
        args.putString(ObjectFragment.ARG_PARAM, titleList.get(position));
//        args.putInt(ObjectFragment.ARG_PARAM, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }
}
