package com.hexuan.supermarketspringboot;

import com.hexuan.supermarket.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author hexuan
 * @Date 2024/1/8 14:23
 * @PackageName:com.hexuan.supermarketspringboot
 * @ClassName: ShopCreator
 * @Description: TODO
 */
public class ShopCreator {
    private List<Command> commands;
    private int currentPosition;
    private ShopManager shopManager;

    public ShopCreator() {
        commands = new ArrayList<>();
        currentPosition = -1;
        shopManager = new ShopManager();
    }

    public void createShop(String shopName) {
        Command command = new CreateShopCommand(shopManager, shopName);
        command.execute();
        currentPosition++;
        commands.subList(currentPosition, commands.size()).clear();
        commands.add(command);
    }

    public void undo() {
        if (currentPosition >= 0) {
            Command command = commands.get(currentPosition);
            command.undo();
            currentPosition--;
        }
    }

    public void redo() {
        if (currentPosition < commands.size() - 1) {
            currentPosition++;
            Command command = commands.get(currentPosition);
            command.redo();
        }
    }

    public void printShops() {
        System.out.println("商店列表：");
        for (String shop : shopManager.shops) {
            System.out.println(shop);
        }
    }
}
