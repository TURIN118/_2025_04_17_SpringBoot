package com.wnj._2025_04_17.mapper;

import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.PayOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PayMapper {

    List<PayOrderEntity> getPayAllInfo(PageDTO pageDTO);

    @Update("update pay_order set order_status = #{payOrderEntity.orderStatus} where pay_order.order_id = #{payOrderEntity.orderId}")
    Integer ExecuteThePayment(@Param("payOrderEntity")PayOrderEntity payOrderEntity);
}
