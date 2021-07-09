package com.yalemang.carro;



import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.Gson;
import com.yalemang.adapter.MainViewPagerAdapter;
import com.yalemang.adapter.UserInformationAdapter;
import com.yalemang.bean.CarBean;
import com.yalemang.bean.CarroBean;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserInformationActivity extends AppCompatActivity {

    RecyclerView userInformationRecyclerView;

    private List<CarroBean> carroBeanList;
    private int GONE = 0;
    private static final String TAG = "UserInformationActivity";
    UserInformationAdapter userInformationAdapter;
    private static String Url = "https://gist.githubusercontent.com/heinhtetaung92/fbfd371881e6982c71971eedd5732798/raw/00e14e0e5502dbcf1ea9a2cdc44324fd3a5492e7/test.json ";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: 在这之前");
        setContentView(R.layout.activity_user_information);
        Log.d(TAG, "onCreate: 在这后");
        requestLogin();
        initView();
    }


    private void initView() {


        userInformationRecyclerView = findViewById(R.id.recycler_view_user_information);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        userInformationRecyclerView.setLayoutManager(linearLayoutManager);

        userInformationRecyclerView.setAdapter(new UserInformationAdapter(this,carroBeanList,GONE));
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
                    carroBeanList = new ArrayList<>();
                    carroBeanList.add(carroBean);
                    Log.d(TAG, " 测试");
                    Log.d(TAG, "requestLogin: " + carroBean.getData().getModel());
                } else {
                    //服务器返回404 505类错误

                }
            }
        });

    }
}
