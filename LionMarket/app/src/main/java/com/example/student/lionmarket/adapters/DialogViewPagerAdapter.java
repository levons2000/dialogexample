package com.example.student.lionmarket.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.providers.AllItemDatas;
import com.example.student.lionmarket.views.ViewPagerDialog;
import com.squareup.picasso.Picasso;

public class DialogViewPagerAdapter extends PagerAdapter{

    private Context context;
    private String[] array = AllItemDatas.getItemByPosition().getImgUrl();

    public DialogViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.img_item_dialog, container, false);
        ImageButton imageButton = view.findViewById(R.id.image_item_dialog);
        Picasso.get().load(array[position]).into(imageButton);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
