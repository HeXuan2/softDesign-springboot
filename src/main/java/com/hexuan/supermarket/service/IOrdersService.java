package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
public interface IOrdersService extends IService<Orders> {
    public int createOrders(Orders orders);
    public Orders getOrdersById(Integer orderId);
    public List<Orders> listOrdersByUserId(String userId);

    int payOrder(Integer orderId);

    int comfirmOrder(Integer orderId);

    int refundOrder(Integer orderId);

    List<Orders> listOrdersByshopId(String shopId);

    int deleteOrderById(Integer orderId);
}
