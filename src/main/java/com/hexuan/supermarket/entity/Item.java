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
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 上架商品Id
     */
    @TableId(value = "itemId", type = IdType.AUTO)
    private Integer itemId;

    /**
     * 门店Id
     */
    private Integer shopId;

    /**
     * 商家商品ID
     */
    private Integer shopItemId;

    @TableField(exist = false)
    private Shopitem shopItem;

}
