package com.hexuan.supermarket.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Item;
import com.hexuan.supermarket.service.IItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Api(tags={"上架商品接口列表"})
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private IItemService itemService;

    @ApiOperation("通过门店获取上架商品列表")
    @GetMapping("/listItemByShopId")
    public Result<List<Item>> listItem(@RequestParam("shopId") int shopId){
        List<Item> listItem=itemService.listItem(shopId);
        return Result.success(listItem,"查询成功") ;
    }

    @ApiOperation("通过Id上架商品")
    @GetMapping("/getItemById")
    public Result<Item> getItemById(@RequestParam("itemId") int itemId){
        Item item=itemService.getItemById(itemId);
        return Result.success(item,"查询成功") ;
    }



    @ApiOperation("新增上架商品")
    @PostMapping("/saveItem")
    public Result<Item> saveItem(@RequestBody Item item){
        int id=itemService.saveItem(item);
        if (id==0){
            return Result.fail(id,"新增上架商品失败");
        }
        if (id==-1) {
            return Result.fail(id,"该商品已在该门店中上架");
        }
        return Result.success(item,"新增上架商品成功");
    }

    @ApiOperation("更新上架商品")
    @PutMapping("/updateItem")
    public Result<?> updateItem(@RequestBody Item item){
        int id=itemService.updateItem(item);
        if (id==0){
            return Result.fail("更新上架商品失败");
        }
        return Result.success(item,"修改上架商品成功");
    }

    @ApiOperation("删除上架商品")
    @DeleteMapping("/removeItem")
    public Result<?> removeItem(@RequestParam int itemId){
        int id=itemService.removeItem(itemId);
        if (id==0){
            return Result.fail("删除上架商品失败");
        }
        return Result.success(id,"删除上架商品成功") ;
    }
}
