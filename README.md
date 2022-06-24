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

