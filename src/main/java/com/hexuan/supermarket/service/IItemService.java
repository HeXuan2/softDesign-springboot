package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Item;
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
public interface IItemService extends IService<Item> {

    List<Item> listItem(int shopId);

    int saveItem(Item item);

    int updateItem(Item item);

    int removeItem(int item);

    Item getItemById(int itemId);
}
