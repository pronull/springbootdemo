package com.github.mapper;

import com.github.common.Pageable;
import com.github.entity.Music;

import java.util.List;

public interface MusicMapper {

    int deleteByMusicId(String musicId);

    int insertSelective(Music record);

    Music selectByMusicId(String musicId);

    int updateByMusicIdSelective(Music record);

    List<Music> findMusicInfoByPage(Pageable page);

    List<Music> findMusicInfoForAll();
}