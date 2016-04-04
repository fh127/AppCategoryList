package com.android.test.app.category.list.process.api;


import com.android.test.app.category.list.process.api.entity.AppItunes;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * this class to manage the logic of the request/response Itunes Api {@link Retrofit}
 * @autor Fabian Hoyos
 */
public class ItunesApiManager {

    private ItunesApi mItunesApi;
    private static final ItunesApiManager instance = new ItunesApiManager();

    /**
     * this method to return the singleton instance of class
     * <p>
     * Created by Fabian Hoyos.
     *
     * @return instance
     */
    public static ItunesApiManager getInstance() {
        return instance;
    }

    /**
     * Class Constructor
     * <p>
     * Created by Fabian Hoyos.
     */
    private ItunesApiManager() {
        this.mItunesApi = ServiceFactory.createRetrofitService(ItunesApi.class, ItunesApiConstants.SERVICE_ENDPOINT);
    }


    /**
     * this method to get RSS Feed from Itunes Api
     * <p>
     * Created by Fabian Hoyos.
     * @param iso
     * @param feedType
     * @param limit
     * @param format
     * @return Observable - AppItunes response
     */
    public Observable<AppItunes> getRSSFeed(String iso, String feedType, String limit, String format) {
      return  mItunesApi.getRssFeedRequest(iso, feedType, limit, format)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }


}
