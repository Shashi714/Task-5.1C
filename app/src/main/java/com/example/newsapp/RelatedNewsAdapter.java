package com.example.newsapp;



import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.newsapp.R;
import com.example.newsapp.News;
import java.util.*;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {
    List<News> relatedList;

    public RelatedNewsAdapter(List<News> list) {
        this.relatedList = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView description;

        public ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.news_image);
            title = v.findViewById(R.id.news_title);
            description = v.findViewById(R.id.news_description);
        }
    }

    @Override
    public RelatedNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        News item = relatedList.get(pos);
        holder.image.setImageResource(item.imageResId);
        holder.title.setText(item.title);
        holder.description.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return relatedList.size();
    }
}

