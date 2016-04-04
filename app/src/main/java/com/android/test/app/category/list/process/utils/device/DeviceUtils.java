package com.android.test.app.category.list.process.utils.device;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * This class to manage commons functions about device
 *
 * @autor Fabian Hoyos
 */
public class DeviceUtils {


    /**
     * this method to get device name
     *<p>
     * Created by Fabian Hoyos.
     *
     * @return device name
     */
    public static String getDeviceName() {
        return android.os.Build.MODEL;
    }


    /**
     * Check if the device has Internet connection.
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param context- application context.
     * @return true if connected, false otherwise.
     */
    public static boolean isConnected(Context context) {
        try {
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

    }
}
