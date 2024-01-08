package com.hexuan.supermarketspringboot;/**
 * @Author hexuan
 * @Date 2024/1/8 14:22
 * @PackageName:com.hexuan.supermarketspringboot
 * @ClassName: CreateShopCommand
 * @Description: TODO
 */
public class CreateShopCommand implements Command{
    private ShopManager shopManager;
    private String shopName;

    public CreateShopCommand(ShopManager shopManager, String shopName) {
        this.shopManager = shopManager;
        this.shopName = shopName;
    }

    @Override
    public void execute() {
        shopManager.createShop(shopName);
    }

    @Override
    public void undo() {
        shopManager.deleteShop(shopName);
    }

    @Override
    public void redo() {
        shopManager.createShop(shopName);
    }
}

