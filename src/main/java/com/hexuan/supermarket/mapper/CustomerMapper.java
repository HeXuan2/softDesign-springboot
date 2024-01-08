package com.hexuan.supermarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hexuan.supermarket.entity.Cart;
import com.hexuan.supermarket.entity.Customer;
import com.hexuan.supermarket.entity.User;

/**
 * @Author hexuan
 * @Date 2024/1/7 17:23
 * @PackageName:com.hexuan.supermarket.mapper
 * @ClassName: CustomerMapper
 * @Description: TODO
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    void saveCustomerByUser(User user);

    int updateCustomer(Customer customer);

    Customer getCustomerById(String customerId);
}
