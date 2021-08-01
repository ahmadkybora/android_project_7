package com.example.android_project_7;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements ConnectivityBroadcast.ConnectivityChangeListener {

    private TextView txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        ConnectivityBroadcast connectivityBroadcast = new ConnectivityBroadcast();
        connectivityBroadcast.setConnectivityChangeListener(this);
        registerReceiver(new ConnectivityBroadcast(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private void initViews() {
        txt_view = findViewById(R.id.txt_view);
    }

    @Override
    public void onConnectivityChange(boolean isConnectedOrConnecting) {
        super.onConnectivityChange(isConnectedOrConnecting);
        txt_view.setText(isConnectedOrConnecting ? "Connected..." : "DisConnected...");
    }
}