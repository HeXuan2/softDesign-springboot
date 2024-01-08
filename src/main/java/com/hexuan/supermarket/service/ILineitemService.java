package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Lineitem;
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
public interface ILineitemService extends IService<Lineitem> {

    List<Lineitem> getLineItemListByOrderId(int orderId);
}
