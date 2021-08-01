package com.example.android_project_7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ConnectivityBroadcast extends BroadcastReceiver {

    private ConnectivityChangeListener connectivityChangeListener;

    public void setConnectivityChangeListener(ConnectivityChangeListener connectivityChangeListener) {
        this.connectivityChangeListener = connectivityChangeListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (connectivityChangeListener != null) {
            connectivityChangeListener.onConnectivityChange(isConnectedOrConnecting(context));
        }
    }

    private boolean isConnectedOrConnecting(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null) {
            return networkInfo.isConnectedOrConnecting();
        } else {
            return false;
        }
    }

    public interface ConnectivityChangeListener {
        void onConnectivityChange(boolean isConnectedOrConnecting);
    }
}
