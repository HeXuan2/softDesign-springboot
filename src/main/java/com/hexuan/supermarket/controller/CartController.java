package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Cart;
import com.hexuan.supermarket.service.ICartService;
import com.hexuan.supermarket.service.IItemService;
import com.hexuan.supermarket.service.IShopService;
import com.hexuan.supermarket.service.ShoppingCartObserver;
import com.hexuan.supermarket.service.impl.CartServiceImpl;
import com.hexuan.supermarket.service.impl.ShoppingCartUI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author hexuan
 * @Date 2024/1/5 16:36
 * @PackageName:com.hexuan.supermarket.controller
 * @ClassName: CartController
 * @Description: TODO
 */
@Api(tags={"购物车接口列表"})
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private IShopService shopService;

    @ApiOperation("购物车列表")
    @GetMapping("/listCart")
    public Result<List<Cart>> listCart(@RequestParam("userId") String userId,
                                       @RequestParam(value = "shopId", required = false) Integer shopId){
        List<Cart> listCart=cartService.listCart(userId,shopId);
        for (Cart cart:listCart){
            cart.setItem(itemService.getItemById(cart.getItemId()));
            cart.setShop(shopService.getShopById(cart.getShopId()));
        }
        return Result.success(listCart,"查询成功") ;
    }

    @ApiOperation("新增购物车")
    @PostMapping("/saveCart")
    public Result<Cart> saveCart(@RequestBody Cart cart){
        int id=cartService.saveCart(cart);
        if (id==0){
            return Result.fail("新增购物车失败");
        }
        return Result.success(cart,"新增购物车成功");
    }

    @ApiOperation("更新购物车")
    @PutMapping("/updateCart")
    public Result<?> updateCart(@RequestBody Cart cart){
        int id=cartService.updateCart(cart);
        if (id==0){
            return Result.fail("更新购物车失败");
        }
        return Result.success(cart,"修改购物车成功");
    }

    @ApiOperation("删除购物车")
    @DeleteMapping("/removeCart")
    public Result<?> removeCart(@RequestBody Cart cart){
        int id=cartService.removeCart(cart);
        if (id==0){
            Result.fail("删除购物车失败");
        }
        return Result.success(cart,"删除购物车成功") ;
    }



}
