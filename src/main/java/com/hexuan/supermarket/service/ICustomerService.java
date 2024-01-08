package com.hexuan.supermarket.service;

import com.hexuan.supermarket.entity.Customer;

/**
 * @Author hexuan
 * @Date 2024/1/7 17:24
 * @PackageName:com.hexuan.supermarket.service
 * @ClassName: ICustomerService
 * @Description: TODO
 */
public interface ICustomerService {
    int updateCustomer(Customer customer);

    Customer getCustomerById(String customerId);
}
