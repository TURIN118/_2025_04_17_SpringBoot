package com.wnj._2025_04_17.service.impl;

import com.wnj._2025_04_17.mapper.ParkMapper;
import com.wnj._2025_04_17.service.ParkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ParkServiceImpl implements ParkService {
    @Autowired
    private ParkMapper parkMapper;

    @Override
    public List<Map<String, Object>> getProvinceCount() {
        return parkMapper.selectProvinceCount();
    }
}
