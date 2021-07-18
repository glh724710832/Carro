package com.yalemang.carro;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BeasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);

        bindView();
        initData();
    }

    protected abstract int setLayout();

    protected abstract void initData();

    protected abstract void bindView();

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
