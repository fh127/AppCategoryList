package com.android.test.app.category.list.app;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;

import com.android.test.app.category.list.process.persistence.RealmConnectionManager;

import java.util.concurrent.TimeUnit;

/**
 * this class to manage global application state {@link Application}
 * @autor Fabian Hoyos
 */
public class App extends Application {

  private static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    context=getApplicationContext();
    RealmConnectionManager.getInstance().initConfiguration(this);


  }

  /**
   * this method return context
   * <p>
   * Created by Fabian Hoyos.
   *
   * @return context
     */
  public static Context getContext() {
    return context;
  }


  /**
   * Return a string for a given resource.
   * <p>
   * Created by Fabian Hoyos.
   *
   * @param resource String resource.
   * @return {@linkplain String} for the given resource.
   */
  public static String getStringFromId(int resource) {
    return getContext().getString(resource);
  }
}