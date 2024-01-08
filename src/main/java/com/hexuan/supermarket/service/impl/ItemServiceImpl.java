package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hexuan.supermarket.entity.Item;
import com.hexuan.supermarket.mapper.ItemMapper;
import com.hexuan.supermarket.mapper.ShopitemMapper;
import com.hexuan.supermarket.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {
    @Resource
    ItemMapper itemMapper;
    @Resource
    private ShopitemMapper shopitemMapper;

    @Override
    public List<Item> listItem(int shopId) {
        QueryWrapper<Item> itemQueryWrapper=new QueryWrapper<>();
        itemQueryWrapper.eq("shopId", shopId);
        List<Item> itemList = itemMapper.selectList(itemQueryWrapper);
        for (Item item:itemList){
            item.setShopItem(shopitemMapper.selectById(item.getShopItemId()));
        }
        return itemList;
    }

    @Override
    public int saveItem(Item item) {
// 检查是否存在相同的 shopId 和 shopItemId 的记录
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shopId", item.getShopId());
        queryWrapper.eq("shopItemId", item.getShopItemId());

        Item existingItem = itemMapper.selectOne(queryWrapper);

        if (existingItem != null) {
            // 存在相同记录，返回提示信息
            return -1;
        }

        // 不存在相同记录，进行新增操作
        return itemMapper.insert(item);
    }

    @Override
    public int updateItem(Item item) {
        return itemMapper.updateById(item);
    }

    @Override
    public int removeItem(int itemId) {
        return itemMapper.deleteById(itemId);
    }

    @Override
    public Item getItemById(int itemId) {
        Item item=itemMapper.selectById(itemId);
        item.setShopItem(shopitemMapper.selectById(item.getShopItemId()));
        return item;
    }
}
