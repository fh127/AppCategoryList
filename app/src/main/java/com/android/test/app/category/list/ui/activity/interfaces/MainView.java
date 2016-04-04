package com.android.test.app.category.list.ui.activity.interfaces;

import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.ui.utils.basic.BasicUIView;


import io.realm.RealmResults;

/**
 * This interface to manage event about Main Screen
 *
 * @autor Fabian Hoyos
 */
public interface MainView extends BasicUIView{

    /**
     * Called to show category list
     * <p/>
     * Created by Fabian Hoyos
     * @param categories
     */
    public void showCategoryList(RealmResults<Category> categories);


}
