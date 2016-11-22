package com.daniel.switchview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwitchView switchView;
    private RelativeLayout activityMain;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        switchView = (SwitchView) findViewById(R.id.switch_view);
        switchView.setState(true);
        switchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn() {
                t("toggleToOn");
            }

            @Override
            public void toggleToOff() {
                t("toggleToOff");
            }
        });
    }

    private Toast mToast;
    private void t(String content) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

}
