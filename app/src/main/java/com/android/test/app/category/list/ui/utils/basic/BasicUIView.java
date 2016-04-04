/*
 * Copyright (C) 2014 AdMobilize. All rights reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package com.android.test.app.category.list.ui.utils.basic;

/**
 * Interface definition for a view basic functionality.
 *
 * @author Fabian Hoyos
 */
public interface BasicUIView {

    /**
     * Show view loading screen.
     * <p/>
     * Created by Fabian Hoyos
     *
     * @param title title to put in loading screen.
     */
    public void showLoadingScreen(String title);

    /**
     * Hide view loading screen.
     * <p/>
     * Created by Fabian Hoyos
     */
    public void hideLoadingScreen();

    /**
     * Show an error in the view.
     * <p/>
     * Created by Fabian Hoyos
     *
     * @param title Error title.
     * @param error Error message.
     */
    public void showError(String title, String error);

    /**
     * Method call if the view main responsibility is complete
     * <p/>
     * Created by Fabian Hoyos
     */
    public void success();


}
