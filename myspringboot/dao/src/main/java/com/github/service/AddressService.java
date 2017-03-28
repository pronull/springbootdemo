package com.github.service;

import com.github.entity.Address;
import com.github.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qwe on 2017/3/28.
 */
@Service
public class AddressService {
    @Cacheable(value = "usercache",keyGenerator = "KeyGenerator")
    public User findUser(Long id, String firstName, String lastName){
        System.out.println("user无缓存的时候调用这里");
        User user = new User();
        user.setAge(18);
        user.setUserAccount(id+"");
        user.setUserPassword("123456");
        user.setCreateTime(new Date());
        user.setHeight(new BigDecimal(170));
        user.setWeight(new BigDecimal(120));
        user.setName(firstName+lastName);
        return user;
    }
    @Cacheable(value = "addresscache",keyGenerator = "KeyGenerator")
    public Address findAddress(Long id, String province, String city){
        System.out.println("address无缓存的时候调用这里");
        return new Address(id,province,city);
    }
}
