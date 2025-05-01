package com.example.newsapp;



import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.newsapp.R;
import com.example.newsapp.News;
import java.util.*;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<News> newsList;
    boolean showTitle;
    OnNewsClickListener listener;

    public interface OnNewsClickListener {
        void onNewsClick(News news);
    }

    public NewsAdapter(List<News> list, boolean showTitle, OnNewsClickListener listener) {
        this.newsList = list;
        this.showTitle = showTitle;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.news_image);
            title = v.findViewById(R.id.news_title);
        }
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News item = newsList.get(position);
        holder.image.setImageResource(item.imageResId);
        holder.title.setText(item.title);
        holder.title.setVisibility(showTitle ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> listener.onNewsClick(item));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}

