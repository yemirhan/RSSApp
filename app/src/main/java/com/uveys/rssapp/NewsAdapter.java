package com.uveys.rssapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, ArrayList<News> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        News news = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.info_text);
        TextView tvDate = (TextView) convertView.findViewById(R.id.postDate);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.newsImage);
        // Populate the data into the template view using the data object
        tvTitle.setText(news.title);
        tvDate.setText(news.publishedAt.substring(0,news.publishedAt.length() - 5));
        Picasso.get().load(news.image).into(imageView);
        // Return the completed view to render on screen
        return convertView;
    }
}