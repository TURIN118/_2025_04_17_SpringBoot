package com.wnj._2025_04_17.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParkMapper {

    @Select("SELECT\n" +
            "  p.province_name AS name,\n" +
            "  COUNT(pl.park_id) AS parkId,\n" +
            "  SUM(pl.available_spaces) AS value,\n" +
            "  FORMAT(AVG(pl.hourly_rate), 2) AS avgHourCharge\n" +
            "FROM park_list pl\n" +
            "LEFT JOIN provinces p ON pl.address LIKE CONCAT(p.prefix, '%')\n" +
            "GROUP BY p.province_name  \n" +
            "ORDER BY p.province_name;  ")
    List<Map<String, Object>> selectProvinceCount();

}
