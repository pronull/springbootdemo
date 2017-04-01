package com.github.service;

import com.github.common.Pageable;
import com.github.entity.Music;
import com.github.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by qwe on 17/4/1.
 */

@Service
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    public  List<Music> getMusicList(Pageable page){
        List<Music> musicList = musicMapper.findMusicInfoByPage(page);
        if(musicList.isEmpty()){
            throw new RuntimeException("没查到数据");
        }
        return musicList;
    }

//    public static void main(String[] args) {
//        List arr = new ArrayList();
//        Optional<List> op = Optional.of(arr);
//        System.out.println(op.isPresent());
//        System.out.println(arr.isEmpty());
//    }
}
