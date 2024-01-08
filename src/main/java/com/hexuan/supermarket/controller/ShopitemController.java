package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Shopitem;
import com.hexuan.supermarket.service.IShopitemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Api(tags={"商品接口列表"})
@RestController
@RequestMapping("/shopItem")
public class ShopitemController {
    @Autowired
    private IShopitemService shopitemService;

    @ApiOperation("通过Id得到商品")
    @GetMapping("/getShopItemById")
    public Result<Shopitem> ShopItemById(@RequestParam("shopItemId") Integer shopItemId){
        Shopitem shopitem=shopitemService.getShopItemById(shopItemId);
        return Result.success(shopitem,"通过商品列表得到商品信息");
    }

    @ApiOperation("通过商家Id得到商品列表")
    @GetMapping("/listShopItemByBusinessId")
    public Result<List<Shopitem>> listShopItemByBusinessId(@RequestParam("businessId") Integer businessId){
        List<Shopitem> listShopItem= shopitemService.listShopItemByBusinessId(businessId);
        return Result.success(listShopItem,"通过商品列表得到商品信息");
    }

    @ApiOperation("增加商品")
    @PostMapping("/saveShopItem")
    public Result<Shopitem> saveShopItem(@RequestBody Shopitem shopitem){
        int id=shopitemService.saveShopItem(shopitem);
        if (id==0){
            return Result.fail("新增商品失败");
        }
        return Result.success(shopitem,"新增商品成功");
    }

    @ApiOperation("更新商品")
    @PutMapping("/updateShopItem")
    public Result<?> updateShopItem(@RequestBody Shopitem shopItem){
        int id=shopitemService.updateShopItem(shopItem);
        if (id==0){
            return Result.fail("更新商品失败");
        }
        return Result.success(shopItem,"更新商品成功");
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/removeShopItem")
    public Result<?> removeShopItem(@RequestParam Integer shopItemId){
        int id=shopitemService.removeShopItem(shopItemId);
        if (id==0){
            return Result.fail("删除商品失败");
        }
        return Result.success(shopItemId,"删除商品成功") ;
    }

}
