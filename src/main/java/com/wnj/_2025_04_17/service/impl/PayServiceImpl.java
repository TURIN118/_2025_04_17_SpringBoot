package com.wnj._2025_04_17.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.PayOrderEntity;
import com.wnj._2025_04_17.entity.Result;
import com.wnj._2025_04_17.mapper.PayMapper;
import com.wnj._2025_04_17.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PayServiceImpl implements PayService {
    @Autowired
    private PayMapper payMapper;

    @Override
    public Result getPayAllInfo(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        pageDTO.setUsername(pageDTO.getUsername().trim());
        List<PayOrderEntity> payOrderEntities =  payMapper.getPayAllInfo(pageDTO);
        PageInfo<PayOrderEntity> payOrderEntityPageInfo = new PageInfo<>(payOrderEntities);
        return new Result(200,payOrderEntityPageInfo,"数据查询成功!");
    }

    @Override
    public Result ExecuteThePayment(PayOrderEntity payOrderEntity) {
        Integer res = payMapper.ExecuteThePayment(payOrderEntity);
        if (res == 0) {
            return new Result(500,res,"操作失败");
        }else {
            if (payOrderEntity.getOrderStatus() == 1) {
                return new Result(200,res,"缴费成功");
            }else {
                return new Result(200,res,"取消缴费成功");
            }
        }
    }
}
