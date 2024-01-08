package com.hexuan.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Business extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 商家编号
     */
    @TableId(value = "businessId", type = IdType.AUTO)
    private String businessId;
    /**
     * 用户名称
     */
    private String businessName;
    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer businessSex;
    /**
     * 用户头像
     */
    private String businessImg;
    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer delTag;
    private Integer phone;

}
