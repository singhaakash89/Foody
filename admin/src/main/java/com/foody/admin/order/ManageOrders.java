package com.foody.admin.order;

/**
 * Created by Aakash Singh on 24-10-2016.
 */
public interface ManageOrders {

    boolean approveOrder();

    boolean cancelOrder();

    boolean modifyOrder();

    boolean viewBookedOrder();

    boolean viewDeilveredOrder();

    boolean viewCancelledOrder();

}
