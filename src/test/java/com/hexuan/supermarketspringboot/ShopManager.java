package com.hexuan.supermarketspringboot;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hexuan
 * @Date 2024/1/8 14:23
 * @PackageName:com.hexuan.supermarketspringboot
 * @ClassName: ShopManager
 * @Description: TODO
 */
public class ShopManager {
    public List<String> shops;

    public ShopManager() {
        shops = new ArrayList<>();
    }

    public void createShop(String shopName) {
        shops.add(shopName);
        System.out.println("创建商店：" + shopName);
    }

    public void deleteShop(String shopName) {
        shops.remove(shopName);
        System.out.println("删除商店：" + shopName);
    }
}
