package com.wnj._2025_04_17.controller;

import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.PayOrderEntity;
import com.wnj._2025_04_17.entity.Result;
import com.wnj._2025_04_17.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/pay")
public class PayController {
    @Autowired
    private PayService payService;

    /*
    * 获取后台所有订单
    * */
    @PostMapping(value = "/getPayAllInfo")
    public Result getPayAllInfo(@RequestBody PageDTO pageDTO) {
        return payService.getPayAllInfo(pageDTO);
    }

    /*
    * 缴费
    * */
    @PostMapping(value = "/executeThePayment")
    public Result ExecuteThePayment(@RequestBody PayOrderEntity payOrderEntity){
        return payService.ExecuteThePayment(payOrderEntity);
    }

}
