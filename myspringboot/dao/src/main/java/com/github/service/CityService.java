package com.github.service;

import com.github.entity.City;
import com.github.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qwe on 2017/3/20.
 */
@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public City getInfo(){
        City city=  cityMapper.findByState("CA");
        return city;
    }
}
