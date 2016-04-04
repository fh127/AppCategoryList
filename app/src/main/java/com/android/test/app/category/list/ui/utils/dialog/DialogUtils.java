package com.android.test.app.category.list.ui.utils.dialog;

import android.app.AlertDialog;
import android.content.Context;
import com.android.test.app.category.list.R;
import com.android.test.app.category.list.app.App;

/**
 * this class to manage to commons dialog function to reuse
 *
 * @autor Fabian Hoyos
 */
public class DialogUtils {



    /**
     * this method to show dialog information
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param context
     * @param title
     * @param message
     */
    public static void showDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);

        builder.setNeutralButton(App.getStringFromId(R.string.label_ok)
                , (dialog, which) -> {
                    dialog.dismiss();
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

}
