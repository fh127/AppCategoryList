package com.android.test.app.category.list.process.api;


import com.android.test.app.category.list.process.api.entity.AppItunes;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * This class to define the end point to connection {@link Retrofit}
 * @autor Fabian Hoyos
 */
public interface ItunesApi {



    @GET("/{iso}/rss/{feed_type}/limit={limit}/{format}")
    Observable<AppItunes> getRssFeedRequest(@Path("iso") String iso, @Path("feed_type") String feedType, @Path("limit") String limit, @Path("format") String format);


}
