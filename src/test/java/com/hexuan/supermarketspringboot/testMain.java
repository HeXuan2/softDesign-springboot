package com.hexuan.supermarketspringboot;

/**
 * @Author hexuan
 * @Date 2024/1/8 14:24
 * @PackageName:com.hexuan.supermarketspringboot
 * @ClassName: testMain
 * @Description: TODO
 */
public class testMain {
    public static void main(String[] args) {
        ShopCreator shopCreator = new ShopCreator();

        shopCreator.createShop("商店1");  // 创建商店1
        shopCreator.createShop("商店2");  // 创建商店2

        shopCreator.printShops();  // 打印商店列表

        shopCreator.undo();  // 撤销创建商店2的操作
        shopCreator.redo();  // 重做撤销的操作

        shopCreator.printShops();  // 再次打印商店列表
    }
}
