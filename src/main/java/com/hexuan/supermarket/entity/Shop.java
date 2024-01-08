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
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "shopId", type = IdType.AUTO)
    private Integer shopId;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 门店图片
     */
    private String shopLogo;

    /**
     * 门店地址
     */
    private String shopAddress;

    /**
     * 门店电话
     */
    private String shopPhone;

    /**
     * 起送费
     */
    private BigDecimal startPrice;

    /**
     * 配送费
     */
    private BigDecimal deliveryPrice;

    /**
     * 门店类型
     */
    private Integer shopType;

    /**
     * 商家编号
     */
    private Integer businessId;

    private String shopDescription;


}
