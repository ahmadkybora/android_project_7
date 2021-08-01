package com.example.android_project_7;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements ConnectivityBroadcast.ConnectivityChangeListener {

    private ConnectivityBroadcast connectivityBroadcast;

    @Override
    protected void onStart() {
        super.onStart();
        connectivityBroadcast = new ConnectivityBroadcast();
        connectivityBroadcast.setConnectivityChangeListener(this);
        registerReceiver(connectivityBroadcast, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (connectivityBroadcast != null) {
            unregisterReceiver(connectivityBroadcast);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (connectivityBroadcast == null) {
            connectivityBroadcast = new ConnectivityBroadcast();
            connectivityBroadcast.setConnectivityChangeListener(this);
        }
        registerReceiver(connectivityBroadcast, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public void onConnectivityChange(boolean isConnectedOrConnecting) {

    }
}
