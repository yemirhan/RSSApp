package com.uveys.rssapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> implements Filterable {
    private List<News> itemsModelsl;
    private List<News> itemsModelListFiltered;
    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
        this.itemsModelsl = news;
        this.itemsModelListFiltered = news;
    }
    @Override
    public int getCount() {
        return itemsModelListFiltered.size();
    }

    @Override
    public News getItem(int position) {
        return itemsModelListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        News news = (News) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.info_text);
        TextView tvDate = (TextView) convertView.findViewById(R.id.postDate);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.newsImage);
        // Populate the data into the template view using the data object
        tvTitle.setText(itemsModelListFiltered.get(position).title);
        tvDate.setText(itemsModelListFiltered.get(position).publishedAt.substring(0,news.publishedAt.length() - 5));
        Picasso.get().load(itemsModelListFiltered.get(position).image).into(imageView);
        // Return the completed view to render on screen
        return convertView;
    }
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint != null){
                    List<News> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();
                    //Log.d("TAG", "performFiltering: "+constraint);
                    for(News itemsModel:itemsModelsl){
                        if(itemsModel.getTitle().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);
                            //Log.d("TAGTT", "performFiltering: "+itemsModel.getTitle());
                            filterResults.count = resultsModel.size();
                            filterResults.values = resultsModel;
                        }
                    }


                }else {
                    filterResults.count = itemsModelsl.size();
                    filterResults.values = itemsModelsl;

                }

                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                Log.d("TAG", "publishResults: ");
                itemsModelListFiltered.clear();
                itemsModelListFiltered.addAll((List<News>) results.values);

                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
