package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hexuan.supermarket.entity.Customer;

import com.hexuan.supermarket.mapper.CustomerMapper;

import com.hexuan.supermarket.service.ICustomerService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author hexuan
 * @Date 2024/1/7 17:24
 * @PackageName:com.hexuan.supermarket.service.impl
 * @ClassName: CustomerServiceImpl
 * @Description: TODO
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerMapper.getCustomerById(customerId);
    }

}
