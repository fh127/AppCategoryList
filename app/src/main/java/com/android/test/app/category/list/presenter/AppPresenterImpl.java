package com.android.test.app.category.list.presenter;

import com.android.test.app.category.list.process.persistence.RealmConnectionManager;
import com.android.test.app.category.list.ui.activity.interfaces.AppView;

/**
 * {@link AppPresenter} implementation
 *
 * @author Fabian Hoyos
 */
public class AppPresenterImpl implements AppPresenter {

    private AppView mAppView;

    /**
     * Class constructor
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param mAppView
     */
    public AppPresenterImpl(AppView mAppView) {
        this.mAppView = mAppView;
    }


    @Override
    public void loadAppList(String categoryId) {
        mAppView.showAppList(RealmConnectionManager.getInstance().findItemsByCategory(categoryId));
    }
}
