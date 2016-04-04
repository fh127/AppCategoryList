package com.android.test.app.category.list.presenter;

import com.android.test.app.category.list.process.persistence.RealmConnectionManager;
import com.android.test.app.category.list.ui.fragment.interfaces.AppDetailsView;

/**
 * {@link AppDetailsPresenter} implementation
 *
 * @author Fabian Hoyos
 */
public class AppDetailsPresenterImpl implements AppDetailsPresenter {

    private AppDetailsView mAppDetailsView;

    /**
     * Class constructor
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param mAppDetailsView
     */
    public AppDetailsPresenterImpl(AppDetailsView mAppDetailsView) {
        this.mAppDetailsView = mAppDetailsView;
    }


    @Override
    public void loadAppDetails(String id) {
        mAppDetailsView.onShowAppDetails(RealmConnectionManager.getInstance().findItemById(id));
    }
}
