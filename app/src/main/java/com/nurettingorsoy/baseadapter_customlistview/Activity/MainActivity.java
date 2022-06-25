package com.nurettingorsoy.baseadapter_customlistview.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.nurettingorsoy.baseadapter_customlistview.Adapter.ListeAdapter;
import com.nurettingorsoy.baseadapter_customlistview.Model.Unluler;
import com.nurettingorsoy.baseadapter_customlistview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView liste;

    ListeAdapter adapter;
    List<Unluler> unluler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = findViewById(R.id.listView);

        unluler = new ArrayList<>();
        /*
        int dogumYili, String adSoyad, String resimUrl, String sehir
         */
        unluler.add(new Unluler(1954,"Sezen Aksu","https://i.sozcu.com.tr/wp-content/uploads/2020/05/16/iecrop/sezenaksu23_16_9_1589624878.jpg","İstanbul"));
        unluler.add(new Unluler(1954,"Sezen Aksu","https://i.sozcu.com.tr/wp-content/uploads/2020/05/16/iecrop/sezenaksu23_16_9_1589624878.jpg","İstanbul"));
        unluler.add(new Unluler(1954,"Sezen Aksu","https://i.sozcu.com.tr/wp-content/uploads/2020/05/16/iecrop/sezenaksu23_16_9_1589624878.jpg","İstanbul"));



        adapter = new ListeAdapter(unluler,getApplicationContext());
        liste.setAdapter(adapter);
    }
}