package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Customer;

import com.hexuan.supermarket.service.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author hexuan
 * @Date 2024/1/7 17:23
 * @PackageName:com.hexuan.supermarket.controller
 * @ClassName: CustomerController
 * @Description: TODO
 */
@Api(tags={"客户接口列表"})
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @ApiOperation("通过Id得到顾客信息")
    @GetMapping("/getCustomerById")
    public Result<Customer> getCustomerById(@RequestParam("customerId") String customerId){
        Customer customer=customerService.getCustomerById(customerId);
        return Result.success(customer,"通过Id得到顾客信息信息成功");
    }

    @ApiOperation("更新顾客信息")
    @PutMapping("/updateCustomer")
    public Result<?> updateCustomer(@RequestBody Customer customer){
        int id=customerService.updateCustomer(customer);
        if (id==0){
            return Result.fail("更新顾客信息失败");
        }
        return Result.success(customer,"修改顾客信息成功");
    }
}
