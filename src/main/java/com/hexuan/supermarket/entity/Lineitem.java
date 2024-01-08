package com.hexuan.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Data
public class Lineitem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单明细编号
     */
    @TableId(value = "lineitemId", type = IdType.AUTO)
    private Integer lineitemId;

    /**
     * 所属订单编号
     */
    private Integer orderId;

    /**
     * 食品编号
     */
    private Integer itemId;

    /**
     * 数量
     */
    private Integer quantity;

    //多对一：所属食品
    @TableField(exist = false)
    private Item item;
}
