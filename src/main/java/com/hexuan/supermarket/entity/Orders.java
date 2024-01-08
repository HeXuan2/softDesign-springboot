package com.hexuan.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId(value = "orderId", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 商家编号
     */
    private Integer shopId;

    /**
     * 订购日期
     */
    private String orderDate;

    /**
     * 订单总价
     */
    private BigDecimal orderTotal;

    /**
     * 送货地址编号
     */
    private Integer daId;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    private Integer payState;

    private Integer delTag;

    private Integer confirmStatus;

    //多对一：所属门店
    @TableField(exist = false)
    private Shop shop;

    //一对多：订单明细
    @TableField(exist = false)
    private List<Lineitem> lineitemList;

}
