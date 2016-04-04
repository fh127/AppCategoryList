package com.android.test.app.category.list.ui.activity.interfaces;

import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.ui.utils.basic.BasicUIView;

import io.realm.RealmResults;

/**
 * This interface to manage event about App list Screen
 *
 * @autor Fabian Hoyos
 */
public interface AppView extends BasicUIView {

    /**
     * Called to show app list
     * <p>
     * Created by Fabian Hoyos
     *
     * @param items
     */
    public void showAppList(RealmResults<Item> items);


}
