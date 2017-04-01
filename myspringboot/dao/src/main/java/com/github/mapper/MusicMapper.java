package com.github.mapper;

import com.github.common.Pageable;
import com.github.entity.Music;

import java.util.List;
import java.util.Optional;

public interface MusicMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);

    List<Music> findMusicInfoByPage(Pageable page);
}