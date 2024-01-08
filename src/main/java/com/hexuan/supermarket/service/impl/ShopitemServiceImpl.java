package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hexuan.supermarket.entity.Shopitem;
import com.hexuan.supermarket.mapper.ShopitemMapper;
import com.hexuan.supermarket.service.IShopitemService;
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
public class ShopitemServiceImpl extends ServiceImpl<ShopitemMapper, Shopitem> implements IShopitemService {
    @Resource
    private ShopitemMapper shopitemMapper;

    @Override
    public List<Shopitem> listShopItemByBusinessId(Integer businessId) {
        QueryWrapper<Shopitem> shopitemQueryWrapper=new QueryWrapper<>();
        shopitemQueryWrapper.eq("businessId",businessId);
        return shopitemMapper.selectList(shopitemQueryWrapper);
    }

    @Override
    public Shopitem getShopItemById(Integer shopItemId) {
        return shopitemMapper.selectById(shopItemId);
    }

    @Override
    public int saveShopItem(Shopitem shopitem) {
        return shopitemMapper.insert(shopitem);
    }

    @Override
    public int updateShopItem(Shopitem shopItem) {
        return shopitemMapper.updateById(shopItem);
    }

    @Override
    public int removeShopItem(Integer shopItemId) {
        return shopitemMapper.deleteById(shopItemId);
    }
}
