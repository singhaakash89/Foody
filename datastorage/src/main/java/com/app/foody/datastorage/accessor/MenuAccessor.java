package com.app.foody.datastorage.accessor;

/**
 * Created by Aakash Singh on 24-11-2016.
 */

public class MenuAccessor {
    public static final String ITEM_ID = "item_id";
    public static final String ITEM_IMAGE = "item_image";
    public static final String ITEM_NAME = "item_name";
    public static final String ITEM_TYPE = "item_type";
    public static final String ITEM_CUISINE = "item_cuisine";
    public static final String ITEM_PRICE = "item_price";
    public static final String ITEM_RATING = "item_rating";
    public static final String ITEM_IS_AVAILABLE = "item_is_available";

    public static String getItemId() {
        return ITEM_ID;
    }

    public static String getItemImage() {
        return ITEM_IMAGE;
    }

    public static String getItemName() {
        return ITEM_NAME;
    }

    public static String getItemType() {
        return ITEM_TYPE;
    }

    public static String getItemCuisine() {
        return ITEM_CUISINE;
    }

    public static String getItemPrice() {
        return ITEM_PRICE;
    }

    public static String getItemRating() {
        return ITEM_RATING;
    }

    public static String getItemIsAvailable() {
        return ITEM_IS_AVAILABLE;
    }

    public static String[] getTableProjection() {
        String[] projection = new String[]{
                getItemId(),
                getItemImage(),
                getItemName(),
                getItemType(),
                getItemCuisine(),
                getItemPrice(),
                getItemRating(),
                getItemIsAvailable()};

        return projection;
    }

}
