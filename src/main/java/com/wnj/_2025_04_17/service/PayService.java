package com.wnj._2025_04_17.service;

import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.PayOrderEntity;
import com.wnj._2025_04_17.entity.Result;

public interface PayService {
    Result getPayAllInfo(PageDTO pageDTO);

    Result ExecuteThePayment(PayOrderEntity payOrderEntity);
}
