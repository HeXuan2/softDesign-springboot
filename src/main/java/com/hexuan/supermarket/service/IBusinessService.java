package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
public interface IBusinessService extends IService<Business> {

    int updateBusiness(Business business);

    Business getBusinessById(String businessId);
}
