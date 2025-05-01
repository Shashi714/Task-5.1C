package com.example.newsapp;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.*;
import com.example.newsapp.NewsAdapter;
import com.example.newsapp.News;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvTop, rvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTop = findViewById(R.id.recycler_top);
        rvNews = findViewById(R.id.recycler_news);

        List<News> topList = getTopStories();
        List<News> newsList = getNews();

        rvTop.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvTop.setAdapter(new NewsAdapter(topList, false, this::openDetail));

        rvNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNews.setAdapter(new NewsAdapter(newsList, true, this::openDetail));
    }

    private void openDetail(News news) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, NewsDetailFragment.newInstance(news));
        ft.addToBackStack(null);
        ft.commit();
    }

    private List<News> getTopStories() {
        return Arrays.asList(
                new News("Top 1", "Unpresidented Ending Crisis,Trump Hastily Departs White House", R.drawable.news1),
                new News("Top 2", "Trump Impeached Again", R.drawable.news2),
                new News("Top 3", "C.D.C Thinking Methods To Stop Spread Of Ebola", R.drawable.news3)
        );
    }

    private List<News> getNews() {
        return Arrays.asList(
                new News("9NEWS", "Unpresidented Ending Crisis,Trump Hastily Departs White House", R.drawable.news1),
                new News("7NEWS", "Trump Impeached Again", R.drawable.news2),
                new News("ABC NEWS", "C.D.C Thinking Methods To Stop Spread Of Ebola", R.drawable.news3),
                new News("THE AGE", "Public Gets Free TV with No Monthly Bills", R.drawable.news4)
        );
    }
}

