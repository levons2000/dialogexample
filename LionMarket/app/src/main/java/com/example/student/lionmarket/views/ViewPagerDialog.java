package com.example.student.lionmarket.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.adapters.DialogViewPagerAdapter;
import com.example.student.lionmarket.adapters.ViewPagerAdapter;

public class ViewPagerDialog extends Dialog {

    private Context context;

    public ViewPagerDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_pager_dialog);
        ViewPager viewPager = findViewById(R.id.view_dialog);
        viewPager.setAdapter(new DialogViewPagerAdapter(context));
    }
}
