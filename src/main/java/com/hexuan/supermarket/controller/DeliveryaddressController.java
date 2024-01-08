package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Deliveryaddress;
import com.hexuan.supermarket.service.IDeliveryaddressService;
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
@Api(tags={"派送地址接口列表"})
@RestController
@RequestMapping("/deliveryAddress")
public class DeliveryaddressController {
    @Autowired
    private IDeliveryaddressService deliveryAddressService;

    @ApiOperation("通过用户Id得到派送地址列表")
    @GetMapping("/listDeliveryAddressByUserId")
    public Result<List<Deliveryaddress>> listDeliveryaddressByUserId(@RequestParam("userId") String userId){
        List<Deliveryaddress> listDeliveryaddress= deliveryAddressService.listDeliveryaddressByUserId(userId);
        return Result.success(listDeliveryaddress,"通过用户id查询地址成功");
    }
    @ApiOperation("通过派送地址Id得到派送地址")
    @GetMapping("/getDeliveryAddressById")
    public Result<Deliveryaddress> getDeliveryaddressById(@RequestParam("daId") Integer daId){
        Deliveryaddress deliveryAddress= deliveryAddressService.getDeliveryaddressById(daId);
        return Result.success(deliveryAddress,"通过id查询地址成功");
    }
    @ApiOperation("新增订单地址")
    @PostMapping("/saveDeliveryAddress")
    public Result<Deliveryaddress> saveDeliveryaddress(@RequestBody Deliveryaddress deliveryAddress){
        deliveryAddressService.saveDeliveryaddress(deliveryAddress);
        return Result.success(deliveryAddress,"新增地址成功");
    }
    @ApiOperation("修改地址")
    @PutMapping("/updateDeliveryAddress")
    public Result<Deliveryaddress> updateDeliveryaddress(@RequestBody Deliveryaddress deliveryAddress){
        deliveryAddressService.updateDeliveryaddress(deliveryAddress);
        return Result.success(deliveryAddress,"修改地址成功");

    }
    @ApiOperation("删除地址")
    @DeleteMapping("/removeDeliveryAddress")
    public Result<Deliveryaddress> removeDeliveryaddress(@RequestParam("daId") Integer daId){
        deliveryAddressService.removeDeliveryaddress(daId);
        return Result.success("删除地址成功") ;
    }

}

