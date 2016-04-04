package com.android.test.app.category.list.ui.fragment.interfaces;

import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.ui.fragment.AppDetailFragment;

/**
 * This interface to manage event about {@link AppDetailFragment}
 *
 * @autor Fabian Hoyos
 */
public interface AppDetailsView {

    /**
     * Called to show app details
     * <p>
     * Created by Fabian Hoyos
     *
     * @param item
     */
    public void onShowAppDetails(Item item);


}
