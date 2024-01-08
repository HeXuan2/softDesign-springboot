package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hexuan.supermarket.entity.Deliveryaddress;
import com.hexuan.supermarket.mapper.DeliveryaddressMapper;
import com.hexuan.supermarket.service.IDeliveryaddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexuan
 * @since 2024-01-05
 */
@Service
public class DeliveryaddressServiceImpl extends ServiceImpl<DeliveryaddressMapper, Deliveryaddress>
        implements IDeliveryaddressService {
    @Resource
    private DeliveryaddressMapper deliveryaddressMapper;

    @Override
    public List<Deliveryaddress> listDeliveryaddressByUserId(String userId) {
        QueryWrapper<Deliveryaddress> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userId",userId);
        return deliveryaddressMapper.selectList(queryWrapper);
    }

    @Override
    public Deliveryaddress getDeliveryaddressById(Integer daId) {
        return deliveryaddressMapper.selectById(daId);
    }

    @Override
    public int saveDeliveryaddress(Deliveryaddress deliveryAddress) {
        return deliveryaddressMapper.insert(deliveryAddress);
    }

    @Override
    public int updateDeliveryaddress(Deliveryaddress deliveryAddress) {
        return deliveryaddressMapper.updateById(deliveryAddress);
    }

    @Override
    public int removeDeliveryaddress(Integer daId) {
        return deliveryaddressMapper.deleteById(daId);

    }
}
