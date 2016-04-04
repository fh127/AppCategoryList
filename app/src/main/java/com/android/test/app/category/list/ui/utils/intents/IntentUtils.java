package com.android.test.app.category.list.ui.utils.intents;

import android.app.Activity;
import android.content.Intent;

import com.android.test.app.category.list.app.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class to manage the send intents
 *
 * @autor Fabian Hoyos
 */
public class IntentUtils {


    /**
     * this generic method to send intent
     *
     * @param activity - activity context
     * @param T        - class T
     */
    public static void sendIntent(Activity activity, Class T) {
        Intent intent = new Intent(activity, T);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    /**
     * this generic method to send intent with parameters
     *
     * @param activity
     * @param T
     * @param parameters - String key - Object value
     */
    public static void sendIntent(Activity activity, Class T, HashMap<String, String> parameters) {
        Intent intent = new Intent(activity, T);
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            intent.putExtra(key, value);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

}
