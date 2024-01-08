package com.hexuan.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author hexuan
 * @Date 2024/1/5 16:36
 * @PackageName:com.hexuan.supermarket.entity
 * @ClassName: cart
 * @Description: TODO
 */
@TableName("cart")
@Data
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 无意义编号
     */
    @TableId(value = "cartId", type = IdType.AUTO)
    private Integer cartId;

    /**
     * 食品编号
     */
    private Integer itemId;

    /**
     * 所属商家编号
     */
    private Integer shopId;

    /**
     * 所属用户编号
     */
    private String userId;

    /**
     * 同一类型食品的购买数量
     */
    private Integer quantity;

    //多对一：所属食品
    @TableField(exist = false)
    private Item item;

    //多对一：所属商家
    @TableField(exist = false)
    private Shop shop;

}

