package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hexuan.supermarket.entity.Shop;
import com.hexuan.supermarket.entity.Shopitem;
import com.hexuan.supermarket.mapper.ShopMapper;
import com.hexuan.supermarket.service.IShopService;
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
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {
    @Resource
    ShopMapper shopMapper;

    @Override
    public List<Shop> listShopByBusinessId(Integer businessId) {
        QueryWrapper<Shop> shopQueryWrapper=new QueryWrapper<>();
        shopQueryWrapper.eq("businessId",businessId);
        return shopMapper.selectList(shopQueryWrapper);
    }

    @Override
    public Shop getShopById(Integer shopId) {
        return shopMapper.selectById(shopId);
    }

    @Override
    public int saveShop(Shop shopitem) {
        return shopMapper.insert(shopitem);
    }

    @Override
    public int updateShop(Shop shopItem) {
        return shopMapper.updateById(shopItem);
    }

    @Override
    public int removeShop(Integer shopId) {
        return shopMapper.deleteById(shopId);
    }

    @Override
    public List<Shop> listShopByShopTypeId(Integer shopType) {
        QueryWrapper<Shop> shopQueryWrapper=new QueryWrapper<>();
        shopQueryWrapper.eq("shopType",shopType);
        return shopMapper.selectList(shopQueryWrapper);
    }
}
