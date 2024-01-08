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
public class Deliveryaddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 送货地址编号
     */
    @TableId(value = "daId", type = IdType.AUTO)
    private Integer daId;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人电话
     */
    private String contactTel;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 所属用户编号
     */
    private String userId;


}
