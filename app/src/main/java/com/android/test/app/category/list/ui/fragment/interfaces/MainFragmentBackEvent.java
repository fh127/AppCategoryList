package com.android.test.app.category.list.ui.fragment.interfaces;


import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.ui.fragment.interfaces.MainFragmentEvent;

import io.realm.RealmResults;

/**
 * Interface definition for back events  {@link MainFragmentEvent}.
 *
 * @author Fabian Hoyos
 */
public interface MainFragmentBackEvent {

    /**
     * called to load category list in the adapter
     * <p>
     * Created by Fabian Hoyos
     *
     * @param categories
     */
    public void loadCategoryList(RealmResults<Category> categories);


}
