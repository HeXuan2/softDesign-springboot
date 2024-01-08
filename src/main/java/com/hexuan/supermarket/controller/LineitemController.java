package com.hexuan.supermarket.controller;

import com.hexuan.supermarket.common.Result;
import com.hexuan.supermarket.entity.Lineitem;
import com.hexuan.supermarket.entity.Orders;
import com.hexuan.supermarket.service.ILineitemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Api(tags={"订单详情接口列表"})
@RestController
@RequestMapping("/lineItem")
public class LineitemController {
    @Autowired
    private ILineitemService lineitemService;

    @ApiOperation("通过订单Id查询LineItem")
    @GetMapping("/getLineItemListByOrderId")
    public Result<List<Lineitem>> getLineItemListByOrderId(@RequestParam("orderId") int orderId){
        List<Lineitem> lineitemList =lineitemService.getLineItemListByOrderId(orderId);
        return Result.success(lineitemList,"通过订单Id查询LineItem成功");
    }

}
