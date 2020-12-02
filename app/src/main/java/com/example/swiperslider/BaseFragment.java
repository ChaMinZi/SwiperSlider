package com.example.swiperslider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class BaseFragment extends Fragment {

    TextView tv_title;
    Button prev_btn, next_btn;

    ViewPager2 viewPager;
    CollectionAdapter viewPagerAdapter;

    List<String> titleList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv_title = view.findViewById(R.id.title_tv);
        prev_btn = view.findViewById(R.id.prev_btn);
        next_btn = view.findViewById(R.id.next_btn);

        titleList.add("전체");
        titleList.add("안경");
        titleList.add("스마트폰");
        titleList.add("클리닝");
        titleList.add("티슈");

        prev_btn.setOnClickListener(view1 -> moveToPreviousPage(view1));
        next_btn.setOnClickListener(view1 -> moveToNextPage(view1));

        viewPager = view.findViewById(R.id.pager_container);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                tv_title.setText(titleList.get(position));
            }
        });
        setViewPagerAdapter();
    }

    public void setViewPagerAdapter() {
        viewPagerAdapter = new CollectionAdapter(this, titleList);
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void moveToNextPage(View view) {
        //it doesn't matter if you're already in the last item
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    public void moveToPreviousPage(View view) {
        //it doesn't matter if you're already in the first item
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);

    }
}

