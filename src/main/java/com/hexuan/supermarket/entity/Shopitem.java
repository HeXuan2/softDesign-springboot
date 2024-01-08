package com.hexuan.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Data
public class Shopitem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 食品编号
     */
    @TableId(value = "shopItemId", type = IdType.AUTO)
    private Integer shopItemId;

    /**
     * 食品名称
     */
    private String shopItemName;

    /**
     * 食品介绍
     */
    private String shopItemDescription;

    /**
     * 食品图片
     */
    private String shopItemImg;

    /**
     * 食品价格
     */
    private BigDecimal shopItemPrice;

    /**
     * 所属商店编号
     */
    private Integer businessId;

}
