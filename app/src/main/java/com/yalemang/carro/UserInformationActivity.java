package com.yalemang.carro;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.Gson;
import com.yalemang.adapter.UserInformationAdapter;
import com.yalemang.bean.CarroBean;


import java.io.IOException;
import java.lang.ref.WeakReference;
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

public class UserInformationActivity extends AppCompatActivity {

    @OnClick({R.id.iv_top_back})
        void onClick(View view){
        switch (view.getId()){
            case R.id.iv_top_back:
                Intent intentMainActivity = new Intent(UserInformationActivity.this,MainActivity.class);
                startActivity(intentMainActivity);
                finish();
                break;
            default:
        }
    }


    RecyclerView userInformationRecyclerView;
    int areaNumber;

    private List<CarroBean> carroBeanList = new ArrayList<>();

    private int GONE = 0;
    private static final String TAG = "UserInformationActivity";
    UserInformationAdapter userInformationAdapter;
    private static String Url = "https://gist.githubusercontent.com/heinhtetaung92/fbfd371881e6982c71971eedd5732798/raw/00e14e0e5502dbcf1ea9a2cdc44324fd3a5492e7/test.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: 在这之前");
        setContentView(R.layout.activity_user_information);
        Log.d(TAG, "onCreate: 在这后");
        initData();
        requestLogin();

        initView();


    }

    private void initData() {
        Intent intent = getIntent();
        areaNumber = intent.getIntExtra("areaNumber",0);
        Log.d(TAG, "initData: "+areaNumber);

    }


    private void initView() {
        ButterKnife.bind(this);
        userInformationRecyclerView = findViewById(R.id.recycler_view_user_information);

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
                    Message message = new Message();
                    message.obj = carroBean;
                    userHandler.sendMessage(message);
                } else {
                    //服务器返回404 505类错误

                }
            }
        });

    }


    Handler userHandler = new Handler(Looper.getMainLooper()) {
        // @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            CarroBean carroBean = (CarroBean) msg.obj;
            carroBeanList.add(carroBean);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UserInformationActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            userInformationRecyclerView.setLayoutManager(linearLayoutManager);
            userInformationRecyclerView.setAdapter(new UserInformationAdapter(UserInformationActivity.this, carroBeanList, areaNumber));

        }
    };


}
