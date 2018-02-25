package com.whatsap.statussaver.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.whatsap.statussaver.R;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Swanand Deshpande on 25/2/18.
 */

public class GridImageAdapter extends BaseAdapter {

    private Activity activity;

    private ArrayList<File> fileList;

    private LayoutInflater mLayoutInflater;


    public GridImageAdapter(Activity activity, ArrayList<File> fileList) {

        this.activity = activity;

        this.mLayoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.fileList = fileList;

    }

    @Override
    public int getCount() {
        return fileList.size();
    }

    @Override
    public Object getItem(int position) {
        return fileList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        final ViewHolder holder;

        if (view == null) {

            view = this.mLayoutInflater.inflate(R.layout.photo_grid_item_layout, null);

            holder = new ViewHolder();

            holder.image = (ImageView) view.findViewById(R.id.img_photo);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();
        }

        holder.image.setImageBitmap(BitmapFactory.decodeFile(fileList.get(position).getAbsolutePath()));

        return view;
    }


    /**
     * ViewHolder
     **/
    private static class ViewHolder {

        private ImageView image;

    }

}
