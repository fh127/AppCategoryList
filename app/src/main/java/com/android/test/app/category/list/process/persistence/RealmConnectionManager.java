package com.android.test.app.category.list.process.persistence;

import android.content.Context;

import com.android.test.app.category.list.process.api.entity.DataEntry;
import com.android.test.app.category.list.process.api.entity.Entry;
import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.process.persistence.entity.ImageData;
import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.process.utils.constants.Constants;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;


/**
 * This class to manage the Realm connection to store data
 *
 * @autor Fabian Hoyos
 */
public class RealmConnectionManager {
    private Realm mRealm;
    private static RealmConnectionManager instance = new RealmConnectionManager();

    /**
     * this method return singleton instace
     * <p>
     * Created by Fabian Hoyos.
     *
     * @return instance
     */
    public static RealmConnectionManager getInstance() {
        return instance;
    }

    /**
     * Class constructor
     * <p>
     * Created by Fabian Hoyos.
     */
    private RealmConnectionManager() {
    }


    /**
     * this method to configure the realm
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param context
     */
    public void initConfiguration(Context context) {

        RealmConfiguration config = new RealmConfiguration.Builder(context.getApplicationContext()).build();
        mRealm = Realm.getInstance(config);
    }


    /**
     * this method to save all items from Itunes api
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param entries
     */
    public void saveItemList(List<Entry> entries) {
        mRealm.executeTransaction(realm -> {
            for (Entry entry : entries) {
                saveItemObject(realm, entry);
            }
        });

    }


    /**
     * this method to save item from Itunes api
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param entry
     */
    public void saveItem(Entry entry) {
        mRealm.executeTransaction(realm -> {
            saveItemObject(realm, entry);
        });

    }


    /**
     * this method to get all of category list
     * <p>
     * Created by Fabian Hoyos.
     *
     * @return categoryList
     */
    public RealmResults<Category> getCategoryList() {
        return mRealm.where(Category.class).findAllSorted(Constants.NAME);
    }

    /**
     * this method to get all of item list
     * <p>
     * Created by Fabian Hoyos.
     *
     * @return itemList
     */
    public RealmResults<Item> getItemList() {
        return mRealm.where(Item.class).findAll();
    }

    /**
     * this method to get item list by category id
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param categoryId
     * @return itemList
     */
    public RealmResults<Item> findItemsByCategory(String categoryId) {
        return mRealm.where(Item.class).equalTo(Constants.CATEGORY_ID, categoryId).findAllSorted(Constants.NAME);
    }

    /**
     * this method to find item by item id
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param itemId
     * @return item
     */
    public Item findItemById(String itemId) {
        return mRealm.where(Item.class).equalTo(Constants.ID, itemId).findFirst();
    }

    /**
     * this method to save item object
     * <p>
     * Created by Fabian Hoyos.
     *
     * @param entry
     */
    private void saveItemObject(Realm mRealm, Entry entry) {


        Item item = new Item();
        item.setId(entry.getId().getAttributes().getIm_id());
        item.setName(entry.getName().getLabel());
        item.setTitle(entry.getTitle().getLabel());
        item.setArtist(entry.getArtist().getLabel());
        item.setSummary(entry.getSummary().getLabel());

        item.setContentType(entry.getContentType().getAttributes().getLabel());
        item.setPrice(entry.getPrice().getAttributes().getAmount());
        item.setRights(entry.getRights().getLabel());
        item.setLink(entry.getId().getLabel());
        item.setReleaseDate(entry.getReleaseDate().getAttributes().getLabel());
        item.setImages(new RealmList<>());
        for (DataEntry dataEntry : entry.getImages()) {
            ImageData image = new ImageData();
            image.setUrl(dataEntry.getLabel());
            image.setHeight(dataEntry.getAttributes().getHeight());
            item.getImages().add(image);
            mRealm.copyToRealm(image);
        }

        Category category = new Category();
        category.setId(entry.getCategory().getAttributes().getIm_id());
        category.setName(entry.getCategory().getAttributes().getLabel());
        category.setScheme(entry.getCategory().getAttributes().getScheme());
        category.setTerm(entry.getCategory().getAttributes().getTerm());
        item.setCategory(category);
        mRealm.copyToRealmOrUpdate(category);


        mRealm.copyToRealmOrUpdate(item);

    }


}
