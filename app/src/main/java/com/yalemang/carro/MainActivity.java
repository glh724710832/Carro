package com.yalemang.carro;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.google.gson.Gson;
import com.yalemang.adapter.main.MainActivityAdapyer;
import com.yalemang.adapter.main.MainViewPagerAdapter;
import com.yalemang.bean.CarBean;
import com.yalemang.bean.CarroBean;
import com.yalemang.bean.TitleBean;
import com.yalemang.until.SpacesItemDecoration;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Administrator
 */
public class MainActivity extends BeasActivity {


    List<CarBean> carBeanList = new ArrayList<>();
    List<TitleBean> titleBeansList = new ArrayList<>();
    RecyclerView mainRecyclerView;
    ArrayList<View> viewArrayList;
    ViewPager viewPager;
    MainViewPagerAdapter mainViewPagerAdapter;
    private static final String TAG = "MainActivity";
    private static String Url = "https://gist.githubusercontent.com/heinhtetaung92/fbfd371881e6982c71971eedd5732798/raw/00e14e0e5502dbcf1ea9a2cdc44324fd3a5492e7/test.json ";
    TextView tvUsed;

    @OnClick({R.id.used_tv})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.used_tv:

                Intent intent = new Intent(MainActivity.this, UserInformationActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
        }


    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    private void requestLogin() {
        //创建实例
        OkHttpClient okHttpClient = new OkHttpClient();

        //创建request实例
        final Request request = new Request.Builder().url(Url).get().build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //因为网络问题/请求超时等原因请求失败
                Log.d("onFailure", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    //获取服务器返回的Json，是否登陆成功需继续解析json
                    String json = response.body().string();
                    Gson gson = new Gson();
                    CarroBean carroBean = gson.fromJson(json, CarroBean.class);

                } else {
                    //服务器返回404 505类错误

                }
            }
        });

    }


    @Override
    protected void initData() {
        addCarPhoto();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mainRecyclerView.setLayoutManager(linearLayoutManager);
        mainRecyclerView.setAdapter(new MainActivityAdapyer(this, carBeanList, titleBeansList));

        int space = 30;
        mainRecyclerView.addItemDecoration(new SpacesItemDecoration(space));
    }

    @Override
    protected void bindView() {
        Log.d(TAG, "initView: 在这");
        ButterKnife.bind(this);
        mainRecyclerView = findViewById(R.id.recycler_view_main);
        tvUsed = findViewById(R.id.used_tv);
    }

    private void initView() {


    }

    private void addCarPhoto() {
        Log.d(TAG, "addCarPhoto: 在这");
        carBeanList.add(new CarBean(R.mipmap.e, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.d, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.f, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.g, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.best, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.c, "CAR", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));

        carBeanList.add(new CarBean(R.mipmap.dsd, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.jeep, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.sss, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));

        carBeanList.add(new CarBean(R.mipmap.sss2, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv2, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv3, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));
        carBeanList.add(new CarBean(R.mipmap.suv4, "SUV", "view 30 cars", "[TJ]Suzukl Carry Pick Up", "Pajak:Mei 2019", "Lokasi: Jawa Barat", "2018 Honda CR_V LX", "Rp 70 - 90 juta", "Qty:30"));

        titleBeansList.add(new TitleBean("Popular Categprles"));
        titleBeansList.add(new TitleBean("New Auctions"));
        titleBeansList.add(new TitleBean("Popular Categprles"));
        titleBeansList.add(new TitleBean("Latest New Car Listings"));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        carBeanList.clear();
//        titleBeansList.clear();
    }
}