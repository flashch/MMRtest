package com.china.one.test_module;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
@Route(path = "/test/activity")
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
