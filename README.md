# Pull_to_refresh



https://user-images.githubusercontent.com/77660268/174745526-c7d98fc2-d1a3-4fab-ab6e-a5886344ff52.mp4

RecyclerItems.xml
---

```xml
<?xml version="1.0" encoding="utf-8"?>

<android.support.v7.widget.CardView android:id="@+id/card_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="16dp"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <!--ImageView
            android:layout_width="match_parent"
            android:layout_height="160dp"
            android:scaleType="centerCrop"
            android:src="@drawable/balon" /-->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="16dp">

            <TextView
                android:id="@+id/text"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginBottom="4dp"
                android:text="Hello World"
                android:textColor="#000"
                android:textSize="18sp" />

        </LinearLayout>

    </LinearLayout>
</android.support.v7.widget.CardView>
```



MainActivity.java
---
```java
 RecyclerView recycler_view;
    LinearLayoutManager manager;
    MyAdapter adapter;
    SwipeRefreshLayout swipe_refresh_layout;
    ArrayList<String> list;
    int num = 11;
    
    // We used methods in this case.
    
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
    
 ```
 
 MyAdapter.java
 ---
 
 ```
 import agolubeff.cardviewswiperefreshtemplate.R;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{
    private Context context;
    private List<String> list;

    public MyAdapter(Context context, List<String> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        MyViewHolder pvh = new MyViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        holder.text.setText(list.get(position));
    }
}

class MyViewHolder extends RecyclerView.ViewHolder
{
    CardView card_view;
    TextView text;

    MyViewHolder(View item)
    {
        super(item);

        card_view = item.findViewById(R.id.card_view);
        text = item.findViewById(R.id.text);
    }
}
 ```

