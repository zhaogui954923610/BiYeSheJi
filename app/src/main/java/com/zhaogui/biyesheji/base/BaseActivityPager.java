package com.zhaogui.biyesheji.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.zhaogui.biyesheji.R;

import butterknife.ButterKnife;

/**
 * Created by gui on 2017/7/21.
 */

public abstract class BaseActivityPager extends FragmentActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
        registComBtn();
    }


    private void registComBtn() {
        View view = findViewById(R.id.back);
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    ;

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            default:
                processClick(v);
                break;
        }
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    public abstract void processClick(View v);

    public void startActivity(Class<?> targetActivity, Bundle bundle) {
        Intent intent = new Intent(this, targetActivity);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
