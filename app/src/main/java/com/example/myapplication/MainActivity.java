package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecPhone = tabHost.newTabSpec("PHONE").setIndicator("전화번호");
        tabSpecPhone.setContent(R.id.tabPop1);
        tabHost.addTab(tabSpecPhone);

        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<30; i++) {
            list.add(String.format("이름"+"\n"+"TEXT %d\n", i)) ;
        }

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recycler1) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        SimpleTextAdapter adapter = new SimpleTextAdapter(list) ;
        recyclerView.setAdapter(adapter) ;


        TabHost.TabSpec tabSpecGallery = tabHost.newTabSpec("GALLERY").setIndicator("갤러리");
        tabSpecGallery.setContent(R.id.tabPop2);
        tabHost.addTab(tabSpecGallery);

        TabHost.TabSpec tabSpecMy = tabHost.newTabSpec("MY").setIndicator("MY");
        tabSpecMy.setContent(R.id.tabPop3);
        tabHost.addTab(tabSpecMy);

        tabHost.setCurrentTab(0);

    }
}