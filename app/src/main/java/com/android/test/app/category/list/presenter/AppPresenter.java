package com.android.test.app.category.list.presenter;


/**
 * Definition of App view presenter.
 *
 * @author Fabian Hoyos
 */
public interface AppPresenter {

    /**
     * Called when to load the app list.
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param categoryId
     */
    public void loadAppList(String categoryId);

}
