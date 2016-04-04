package com.android.test.app.category.list.ui.fragment.interfaces;



import com.android.test.app.category.list.process.persistence.entity.Item;

/**
 * Interface definition for events {@link AppFragmentEvent}.
 *
 * @author Fabian Hoyos
 */
public interface AppFragmentEvent {


    /**
     * Callled when the category is selected
     *
     * @param app
     */
    public void onSelectApp(Item app);


}
