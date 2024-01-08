package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Business;
import com.hexuan.supermarket.service.IBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Api(tags={"商家接口列表"})
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private IBusinessService businessService;

    @ApiOperation("通过Id得到商家信息")
    @GetMapping("/getBusinessById")
    public Result<Business> getBusinessById(@RequestParam("businessId") String businessId){
        Business business=businessService.getBusinessById(businessId);
        return Result.success(business,"通过Id得到商家信息信息成功");
    }

    @ApiOperation("更新商家信息")
    @PutMapping("/updateBusiness")
    public Result<?> updateBusiness(@RequestBody Business business){
        int id=businessService.updateBusiness(business);
        if (id==0){
            return Result.fail("更新商家信息失败");
        }
        return Result.success(business,"修改商家信息成功");
    }
}
