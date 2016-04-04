package com.android.test.app.category.list.process.persistence.interfaces;

/**
 * This interface is used to manage the Realm response transactions of write operations
 *
 * @autor Fabian Hoyos
 */
public interface OnRealmTransactionResponse {

    /**
     * Call when the transaction is successfully
     * <p>
     * Created by Fabian Hoyos.
     */
    public void onRealmTransaction();

    /**
     * Called when the transaction is failed
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param error
     */
    public void onRealmError(String error);

}
