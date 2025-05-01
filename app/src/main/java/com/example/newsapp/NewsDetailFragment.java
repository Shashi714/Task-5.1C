package com.example.newsapp;



import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import com.example.newsapp.RelatedNewsAdapter;
import com.example.newsapp.News;
import java.util.*;

public class NewsDetailFragment extends Fragment {
    public static final String ARG_NEWS = "arg_news";

    public static NewsDetailFragment newInstance(News news) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS, news);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news_detail, container, false);
        News news = (News) getArguments().getSerializable(ARG_NEWS);

        ImageView image = v.findViewById(R.id.detail_image);
        TextView desc = v.findViewById(R.id.detail_description);
        RecyclerView rv = v.findViewById(R.id.related_recycler);

        image.setImageResource(news.imageResId);
        desc.setText(news.description);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new RelatedNewsAdapter(getDummyRelatedNews()));

        return v;
    }

    private List<News> getDummyRelatedNews() {
        List<News> list = new ArrayList<>();
        list.add(new News("Related To", "Trump Impeached Again", R.drawable.news2));
        list.add(new News("Related To", "Public Gets Free TV with No Monthly Bills", R.drawable.news4));
        return list;
    }
}
