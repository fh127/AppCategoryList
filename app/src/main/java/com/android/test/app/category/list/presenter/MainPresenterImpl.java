package com.android.test.app.category.list.presenter;

import android.content.Context;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.app.App;
import com.android.test.app.category.list.process.api.ItunesApiManager;
import com.android.test.app.category.list.process.api.entity.Entry;
import com.android.test.app.category.list.process.persistence.RealmConnectionManager;
import com.android.test.app.category.list.process.utils.constants.Constants;
import com.android.test.app.category.list.process.utils.device.DeviceUtils;
import com.android.test.app.category.list.ui.activity.interfaces.MainView;
import rx.Subscriber;

/**
 * {@link MainPresenter} implementation
 *
 * @author Fabian Hoyos
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;

    /**
     * Class constructor
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param mMainView
     */
    public MainPresenterImpl(MainView mMainView) {
        this.mMainView = mMainView;
    }




    @Override
    public void loadCategoryList(Context context) {

        if (DeviceUtils.isConnected(context)) {

            ItunesApiManager.getInstance().getRSSFeed(Constants.ISO, Constants.TYPE_FEED, Constants.LIMIT, Constants.FORMAT)
                    .concatMap(appItunes -> rx.Observable.from(appItunes.getFeed().getEntry()))
                    .subscribe(new Subscriber<Entry>() {
                        @Override
                        public void onCompleted() {
                            mMainView.showCategoryList(RealmConnectionManager.getInstance().getCategoryList());
                        }

                        @Override
                        public void onError(Throwable e) {
                            mMainView.showError(App.getStringFromId(R.string.alert), e.getMessage());
                        }

                        @Override
                        public void onNext(Entry entry) {
                            RealmConnectionManager.getInstance().saveItem(entry);
                        }
                    });
        } else {
            mMainView.showError(App.getStringFromId(R.string.alert), App.getStringFromId(R.string.off_line_connection));
            if (RealmConnectionManager.getInstance().getCategoryList() != null)
                mMainView.showCategoryList(RealmConnectionManager.getInstance().getCategoryList());

        }
    }


}
