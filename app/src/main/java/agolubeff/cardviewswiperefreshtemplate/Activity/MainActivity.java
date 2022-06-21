package agolubeff.cardviewswiperefreshtemplate.Activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

import agolubeff.cardviewswiperefreshtemplate.Adapter.MyAdapter;
import agolubeff.cardviewswiperefreshtemplate.R;

public class MainActivity extends AppCompatActivity
{
    //private List<String> list;
    RecyclerView recycler_view;
    LinearLayoutManager manager;
    MyAdapter adapter;
    SwipeRefreshLayout swipe_refresh_layout;
    ArrayList<String> list;
    int num = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        recycler_view = findViewById(R.id.my_recycler_view);
        manager = new LinearLayoutManager(this);

        String[] a = {"1","2","3","4","5","6","7","8","9","10"};
        list = new ArrayList<>(Arrays.asList(a));

        adapter = new MyAdapter(this,list);
        recycler_view.setLayoutManager(manager);
        recycler_view.setAdapter(adapter);


        InitSwipeRefreshLayout();
    }



    private void InitSwipeRefreshLayout()
    {
        swipe_refresh_layout = findViewById(R.id.swipe_refresh_layout);
        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                RefreshContent();
            }
        });
    }

    private void RefreshContent()
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {


                // data fetch
                for (int i = 0; i <1; i++) {
                    String nums = Integer.toString(num);

                    list.add(nums);


                    adapter.notifyDataSetChanged();
                    num= num+1;

                }

                swipe_refresh_layout.setRefreshing(false);

            }
        }, 100);
    }



}
