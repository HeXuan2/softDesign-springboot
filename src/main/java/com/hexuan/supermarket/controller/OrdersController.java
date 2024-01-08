package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Orders;
import com.hexuan.supermarket.service.IOrdersService;
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
@Api(tags={"订单接口列表"})
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @ApiOperation("新增订单")
    @PostMapping("/createOrders")
    public Result<Orders> createOrders(@RequestBody Orders orders){
        ordersService.createOrders(orders);
        return Result.success(orders,"新增订单成功");
    }

    @ApiOperation("通过id查询订单")
    @GetMapping("/getOrdersById")
    public Result<Orders> getOrdersById(@RequestParam("orderId") Integer orderId) {
        Orders orders= ordersService.getOrdersById(orderId);
        return Result.success(orders,"通过id查询订单成功") ;
    }

    @ApiOperation("通过用户Id查询订单")
    @GetMapping("/listOrdersByUserId")
    public Result<List<Orders>> listOrdersByUserId(@RequestParam("userId") String userId){
        List<Orders> ordersList =ordersService.listOrdersByUserId(userId);
        return Result.success(ordersList,"通过用户id查询订单成功");
    }

    @ApiOperation("通过门店Id查询订单")
    @GetMapping("/listOrdersByShopId")
    public Result<List<Orders>> listOrdersByShopId(@RequestParam("shopId") String shopId){
        List<Orders> ordersList =ordersService.listOrdersByshopId(shopId);
        return Result.success(ordersList,"通过门店id查询订单成功");
    }

    @ApiOperation("删除订单")
    @DeleteMapping("/deleteOrderById")
    public Result<Integer> deleteOrderById(@RequestParam("orderId") Integer orderId){
        int status=ordersService.deleteOrderById(orderId);
        if (status==0){
            return Result.fail("删除订单失败");
        }
        return Result.success(status,"删除订单成功");
    }


    @ApiOperation("支付订单")
    @GetMapping("/payOrder")
    public Result<Integer> payOrder(@RequestParam("orderId") Integer orderId) throws Exception{
        int orderStatus =ordersService.payOrder(orderId);
        return Result.success(orderStatus,"支付成功");
    }

    @ApiOperation("确认支付订单")
    @GetMapping("/confirmOrder")
    public Result<Integer> comfirmOrder(@RequestParam("orderId") Integer orderId) throws Exception{
        int orderStatus =ordersService.comfirmOrder(orderId);
        if (orderStatus==0){
            return Result.fail("确认订单失败");
        }
        return Result.success(orderStatus,"确认订单成功");
    }

    @ApiOperation("退款支付订单")
    @GetMapping("/refundOrder")
    public Result<Integer> refundOrder(@RequestParam("orderId") Integer orderId) throws Exception{
        int orderStatus =ordersService.refundOrder(orderId);
        if (orderStatus==0){
            return Result.fail("退款订单失败");
        }
        return Result.success(orderStatus,"退款取消订单成功");
    }

}
