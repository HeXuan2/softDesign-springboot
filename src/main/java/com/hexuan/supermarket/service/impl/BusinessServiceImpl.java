package com.hexuan.supermarket.service.impl;

import com.hexuan.supermarket.entity.Business;
import com.hexuan.supermarket.mapper.BusinessMapper;
import com.hexuan.supermarket.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Resource
    private BusinessMapper businessMapper;

    @Override
    public int updateBusiness(Business business) {
        return businessMapper.updateBusiness(business);
    }

    @Override
    public Business getBusinessById(String businessId) {
        return businessMapper.getBusinessById(businessId);
    }
}
