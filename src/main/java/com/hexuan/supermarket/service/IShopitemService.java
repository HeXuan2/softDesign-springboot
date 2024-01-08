package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Shopitem;
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
public interface IShopitemService extends IService<Shopitem> {

    List<Shopitem> listShopItemByBusinessId(Integer businessId);

    Shopitem getShopItemById(Integer shopItemId);

    int saveShopItem(Shopitem shopitem);

    int updateShopItem(Shopitem shopItem);

    int removeShopItem(Integer shopItemId);
}
