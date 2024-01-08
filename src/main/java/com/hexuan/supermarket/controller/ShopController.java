package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Shop;
import com.hexuan.supermarket.service.IShopService;
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
@Api(tags={"门店接口列表"})
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private IShopService shopitemService;

    @ApiOperation("通过Id得到门店")
    @GetMapping("/getShopById")
    public Result<Shop> getShopById(@RequestParam("shopId") Integer shopId){
        Shop shop=shopitemService.getShopById(shopId);
        return Result.success(shop,"通过门店列表得到门店信息");
    }

    @ApiOperation("通过门店类型得到门店列表")
    @GetMapping("/getShopListByShopTypeId")
    public Result<List<Shop>> listShopByShopTypeId(@RequestParam("shopType") Integer shopType){
        List<Shop> listShop= shopitemService.listShopByShopTypeId(shopType);
        return Result.success(listShop,"通过门店类型得到门店列表");
    }


    @ApiOperation("通过商家Id得到门店列表")
    @GetMapping("/listShopByBusinessId")
    public Result<List<Shop>> listShopByBusinessId(@RequestParam("businessId") Integer businessId){
        List<Shop> listShop= shopitemService.listShopByBusinessId(businessId);
        return Result.success(listShop,"通过门店列表得到门店信息");
    }

    @ApiOperation("增加门店")
    @PostMapping("/saveShop")
    public Result<Shop> saveShop(@RequestBody Shop shop){
        int id=shopitemService.saveShop(shop);
        if (id==0){
            return Result.fail("新增门店失败");
        }
        return Result.success(shop,"新增门店成功");
    }

    @ApiOperation("更新门店")
    @PutMapping("/updateShop")
    public Result<?> updateShop(@RequestBody Shop shop){
        int id=shopitemService.updateShop(shop);
        if (id==0){
            return Result.fail("更新门店失败");
        }
        return Result.success(shop,"修改门店成功");
    }

    @ApiOperation("删除门店")
    @DeleteMapping("/removeShop")
    public Result<?> removeShop(@RequestParam Integer shopId){
        int id=shopitemService.removeShop(shopId);
        if (id==0){
            return Result.fail("删除门店失败");
        }
        return Result.success(shopId,"删除门店成功") ;
    }
}
