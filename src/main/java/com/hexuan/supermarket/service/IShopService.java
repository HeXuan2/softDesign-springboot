package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hexuan.supermarket.entity.Shopitem;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
public interface IShopService extends IService<Shop> {

    List<Shop> listShopByBusinessId(Integer businessId);

    Shop getShopById(Integer shopId);

    int saveShop(Shop shopitem);

    int updateShop(Shop shopItem);

    int removeShop(Integer shopId);

    List<Shop> listShopByShopTypeId(Integer shopTypeId);
}
