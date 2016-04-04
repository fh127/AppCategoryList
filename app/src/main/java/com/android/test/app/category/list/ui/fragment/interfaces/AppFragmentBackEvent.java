package com.android.test.app.category.list.ui.fragment.interfaces;


import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.process.persistence.entity.Item;

import io.realm.RealmResults;

/**
 * Interface definition for back events  {@link AppFragmentBackEvent}.
 *
 * @author Fabian Hoyos
 */
public interface AppFragmentBackEvent {

    /**
     * called to load app list in the adapter
     * <p>
     * Created by Fabian Hoyos
     *
     * @param apps
     */
    public void loadAppList(RealmResults<Item> apps);


}
