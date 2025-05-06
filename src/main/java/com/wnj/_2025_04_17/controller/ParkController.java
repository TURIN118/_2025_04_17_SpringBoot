package com.wnj._2025_04_17.controller;

import com.wnj._2025_04_17.entity.Result;
import com.wnj._2025_04_17.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/park")
public class ParkController {
    @Autowired
    private ParkService parkService;

    @GetMapping("/getProvinceCount")
    public Result getProvinceCount() {
        try {
            List<Map<String, Object>> result = parkService.getProvinceCount();
            return Result.OK(result, "获取省份统计数据成功");
        } catch (Exception e) {
            return Result.ERR(null, "获取省份统计数据失败");
        }
    }
}
