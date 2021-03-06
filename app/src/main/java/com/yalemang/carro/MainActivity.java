package com.yalemang.carro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;


import com.yalemang.adapter.MainActivityAdapyer;
import com.yalemang.adapter.MainViewPagerAdapter;
import com.yalemang.adapter.PopularCategorlesAdapter;
import com.yalemang.bean.CarBean;
import com.yalemang.bean.TitleBean;
import com.yalemang.until.SpacesItemDecoration;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<CarBean> carBeanList = new ArrayList<>();
    List<TitleBean> titleBeansList = new ArrayList<>();
    RecyclerView mainRecyclerView;
    ArrayList<View> viewArrayList;
    ViewPager viewPager;
    MainViewPagerAdapter mainViewPagerAdapter;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: 死在初始化绑定布局后");
        initView();
        addCarPhoto();
        // useViewPager();


        initData();
    }

//    private void useViewPager() {
//
//        //可以考虑一个布局重复添加
//        viewArrayList = new ArrayList<>();
//        LayoutInflater layoutInflater = getLayoutInflater();
//        viewArrayList.add(getLayoutInflater().inflate(R.layout.view_pager_one, null, false));
//
//        viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_one, null, false));
//        viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_one, null, false));
//        viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_two, null, false));
//        viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_three, null, false));
//        viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_four, null, false));
//        viewArrayList.add(layoutInflater.inflate(R.layout.view_pager_five, null, false));
//
//
//        //为什么不能直接.setImageResource，要创建一个实例？
//        ImageView imageView = viewArrayList.get(0).findViewById(R.id.one_iv);
//        imageView.setImageResource(R.mipmap.suv2);
//
//        ImageView imageView1 = viewArrayList.get(1).findViewById(R.id.one_iv);
//        imageView1.setImageResource(R.mipmap.sss);
//
//
//        mainViewPagerAdapter = new MainViewPagerAdapter(this, viewArrayList);
//        viewPager.setAdapter(mainViewPagerAdapter);
//    }

    private void initData() {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mainRecyclerView.setLayoutManager(linearLayoutManager);
        mainRecyclerView.setAdapter(new MainActivityAdapyer(this, carBeanList, titleBeansList));

        int space = 30;
        mainRecyclerView.addItemDecoration(new SpacesItemDecoration(space));


    }

    private void initView() {
        Log.d(TAG, "initView: 死在这");
        mainRecyclerView = findViewById(R.id.recycler_view_main);


        // viewPager = findViewById(R.id.view_pager_main);
    }

    private void addCarPhoto() {
        Log.d(TAG, "addCarPhoto: 死在这");
        carBeanList.add(new CarBean(R.mipmap.a, "SUV", "view 30 cars >", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.b, "T", "view 31 cars >","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.c, "CAR", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.d, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.e, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.f, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.g, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.best, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));

        carBeanList.add(new CarBean(R.mipmap.dsd, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.jeep, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.sss, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));

        carBeanList.add(new CarBean(R.mipmap.sss2, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv2, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv3, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv4, "SUV", "view 30 cars","[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat","2018 Honda CR_V LX","Rp 70 - 90 juta","Qty:30"));

        titleBeansList.add(new TitleBean("Popular Categprles"));
        titleBeansList.add(new TitleBean("New Auctions"));
        titleBeansList.add(new TitleBean("Popular Categprles"));
        titleBeansList.add(new TitleBean("Popular Categprles"));


    }


}