package com.app.foody.oneui.activities.admin;

/**
 * Created by Aakash Singh on 27-11-2016.
 */

public interface AdminContract {

    public static final String KEY = "key";
    public static final String UPLOAD_ITEM = "upload_item";
    public static final String EDIT_ITEM = "edit_item";
    public static final String ORDER_MANAGEMENT = "order_management";
    public static final String FINANCE_MANAGEMENT = "finance_management";
    public static final String DEVELOPER_CALL = "developer_call";

    public boolean uploadItem(int resId);

    public boolean editItem(int resId);

    public boolean orderManagement(int resId);

    public boolean financeManagement(int resId);

    public boolean developerCall(int resId);
}
