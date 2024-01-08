package com.hexuan.supermarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hexuan.supermarket.entity.Lineitem;
import com.hexuan.supermarket.mapper.LineitemMapper;
import com.hexuan.supermarket.service.IItemService;
import com.hexuan.supermarket.service.ILineitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LineitemServiceImpl extends ServiceImpl<LineitemMapper, Lineitem> implements ILineitemService {
    @Resource
    private LineitemMapper lineitemMapper;
    @Autowired
    private IItemService itemService;


    @Override
    public List<Lineitem> getLineItemListByOrderId(int orderId) {
        QueryWrapper<Lineitem> lineitemQueryWrapper=new QueryWrapper<>();
        lineitemQueryWrapper.eq("orderId",orderId);

        List<Lineitem> listLineitem=lineitemMapper.selectList(lineitemQueryWrapper);

        for (Lineitem lineitem:listLineitem){
            lineitem.setItem(itemService.getItemById(lineitem.getItemId()));
        }

        return listLineitem;
    }
}
