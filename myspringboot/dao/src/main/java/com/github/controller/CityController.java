package com.github.controller;


import com.github.entity.City;
import com.github.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qwe on 2017/3/20.
 */
@RestController
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/city")
    City findCity(){
        System.out.println();
       return cityService.getInfo();
   }
}
