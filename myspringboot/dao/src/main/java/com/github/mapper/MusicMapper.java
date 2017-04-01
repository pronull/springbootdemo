package com.github.mapper;

import com.github.entity.Music;

public interface MusicMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
}