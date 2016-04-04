package com.android.test.app.category.list.presenter;

import android.content.Context;

/**
 * Definition of Main view presenter.
 *
 * @author Fabian Hoyos
 */
public interface MainPresenter {

    /**
     * Called when to load the category list.
     * <p>
     * Created by Fabian Hoyos.
     * @param context
     */
    public void loadCategoryList(Context context);

}
