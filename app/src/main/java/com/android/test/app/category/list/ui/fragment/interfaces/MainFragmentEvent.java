package com.android.test.app.category.list.ui.fragment.interfaces;


import com.android.test.app.category.list.process.persistence.entity.Category;

/**
 * Interface definition for events {@link MainFragmentEvent}.
 *
 * @author Fabian Hoyos
 */
public interface MainFragmentEvent {


    /**
     * Callled when the category is selected
     *
     * @param category
     */
    public void onSelectCategory(Category category);


}
