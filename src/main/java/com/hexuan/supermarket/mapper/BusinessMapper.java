package com.hexuan.supermarket.mapper;

import com.hexuan.supermarket.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hexuan.supermarket.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
public interface BusinessMapper extends BaseMapper<Business> {

    void saveBusinessByUser(User user);

    int updateBusiness(Business business);

    Business getBusinessById(String businessId);
}
