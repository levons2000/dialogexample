package com.example.student.lionmarket.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.adapters.ViewPagerAdapter;
import com.example.student.lionmarket.models.GameModel;
import com.example.student.lionmarket.providers.AllItemDatas;
import com.example.student.lionmarket.views.CustomDialog;
import com.example.student.lionmarket.views.ViewPagerDialog;
import com.squareup.picasso.Picasso;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        GameModel gameModel = AllItemDatas.getItemByPosition();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!AllItemDatas.getItemByPosition().isInBin) {
                    AllItemDatas.getItemByPosition().isInBin = true;
                } else {
                    AllItemDatas.getItemByPosition().isInBin = false;
                }
            }
        });
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(gameModel.getRaiting());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                AllItemDatas.list.get(AllItemDatas.position).setRaiting(v);
            }
        });

        setAllText(gameModel);
        setImgForVideo(AllItemDatas.getItemByPosition().getVideoImgUrl());
        setViewPager();

    }


    private void setAllText(GameModel gameModel) {
        TextView textName = findViewById(R.id.info_name);
        TextView textType = findViewById(R.id.info_type);
        TextView textPrice = findViewById(R.id.info_price);
        TextView textCreator = findViewById(R.id.info_creator);
        textName.setText(gameModel.getName());
        textType.setText(gameModel.getType());
        textPrice.setText(gameModel.getPrice());
        textCreator.setText(gameModel.getCreator());
        TextView textDesc = findViewById(R.id.desc);
        textDesc.setText(AllItemDatas.list.get(AllItemDatas.position).getDesc());
    }

    private void setImgForVideo(String videoImgUrl){
        ImageButton imageButton = findViewById(R.id.image_for_video);
        Picasso.get().load(videoImgUrl).into(imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(ScrollingActivity.this);
                customDialog.show();
            }
        });
    }

    private void setViewPager(){
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(ScrollingActivity.this);
        viewPager.setAdapter(viewPagerAdapter);
    }

}
