package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Deliveryaddress;
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
public interface IDeliveryaddressService extends IService<Deliveryaddress> {

    List<Deliveryaddress> listDeliveryaddressByUserId(String userId);

    Deliveryaddress getDeliveryaddressById(Integer daId);

    int saveDeliveryaddress(Deliveryaddress deliveryAddress);

    int updateDeliveryaddress(Deliveryaddress deliveryAddress);

    int removeDeliveryaddress(Integer daId);
}
