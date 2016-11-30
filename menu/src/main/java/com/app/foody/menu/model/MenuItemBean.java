package com.app.foody.menu.model;

import android.content.ContentValues;

import com.app.foody.datastorage.accessor.MenuAccessor;

/**
 * Created by Aakash Singh on 23-11-2016.
 */

public class MenuItemBean {

    private String itemId;
    private byte[] itemImage;
    private String itemName;
    private String itemType;
    private String itemCuisine;
    private String itemPrice;
    private String itemRating;
    private String isItemAvailable;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public byte[] getItemImage() {
        return itemImage;
    }

    public void setItemImage(byte[] itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemCuisine() {
        return itemCuisine;
    }

    public void setItemCuisine(String itemCuisine) {
        this.itemCuisine = itemCuisine;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemRating() {
        return itemRating;
    }

    public void setItemRating(String itemRating) {
        this.itemRating = itemRating;
    }

    public String getIsItemAvailable() {
        return isItemAvailable;
    }

    public void setIsItemAvailable(String isItemAvailable) {
        this.isItemAvailable = isItemAvailable;
    }

    public ContentValues getContentValues() {
        ContentValues row = new ContentValues();
        row.put(MenuAccessor.ITEM_ID, getItemId());
        row.put(MenuAccessor.ITEM_IMAGE, getItemImage());
        row.put(MenuAccessor.ITEM_NAME, getItemName());
        row.put(MenuAccessor.ITEM_TYPE, getItemType());
        row.put(MenuAccessor.ITEM_CUISINE, getItemCuisine());
        row.put(MenuAccessor.ITEM_PRICE, getItemPrice());
        row.put(MenuAccessor.ITEM_RATING, getItemRating());
        row.put(MenuAccessor.ITEM_IS_AVAILABLE, getIsItemAvailable());
        return row;
    }

}
