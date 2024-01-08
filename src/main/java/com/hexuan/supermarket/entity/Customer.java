package com.hexuan.supermarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author hexuan
 * @Date 2024/1/7 17:06
 * @PackageName:com.hexuan.supermarket.entity
 * @ClassName: Customer
 * @Description: TODO
 */
@Data
public class Customer extends User  implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 商家编号
     */
    @TableId(value = "customerId", type = IdType.AUTO)
    private String customerId;
    /**
     * 用户名称
     */
    private String customerName;

    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer customerSex;

    /**
     * 用户头像
     */
    private String customerImg;

    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer delTag;

    private Integer phone;
}
