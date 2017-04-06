package com.github.entity;

/**
 * Created by qwe on 2017/3/28.
 *
 * @author qwe
 */
public class Address {

    /**
     * 数据库id.
     */
    private Long id;
    /**
     * 省.
     */
    private String province;
    /**
     * 城市.
     */
    private String city;

    /**
     * 构造器.
     *
     * @param newId       id
     * @param newProvince province
     * @param newCity     city
     */
    public Address(final Long newId, final String newProvince,
                   final String newCity) {
        this.id = newId;
        this.province = newProvince;
        this.city = newCity;
    }

    /**
     * address.
     */
    public Address() {
    }

    /**
     * getId.
     *
     * @return long
     */
    public Long getId() {
        return id;
    }

    /**
     * set id.
     *
     * @param newId id
     */
    public void setId(final Long newId) {
        this.id = newId;
    }

    /**
     * get province.
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * set province.
     *
     * @param province province
     */
    public void setProvince(final String province) {
        this.province = province;
    }

    /***
     * get city.
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * set city.
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }
}
