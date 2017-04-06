package com.github.service;

import com.github.common.Pageable;
import com.github.entity.Music;
import com.github.mapper.MusicMapper;
import com.github.vo.common.MusicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by qwe on 17/4/1.
 */

@Service
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    public List<Music> getMusicList(Pageable page) {
        List<Music> musicList = musicMapper.findMusicInfoByPage(page);
        if (musicList.isEmpty()) {
            throw new RuntimeException("没查到数据");
        }
        return musicList;
    }

    public int save(MusicVo vo) {
        Music newMusic = new Music();
        BeanUtils.copyProperties(newMusic, newMusic);
        newMusic.setMusicId(UUID.randomUUID().toString());
        Music oldMusic = musicMapper.selectByMusicId(newMusic.getMusicId());
        if (!Objects.isNull(oldMusic)) {
            if (Objects.isNull(oldMusic.getMusicName())) {
                throw new RuntimeException("歌曲名不能为空");
            }
            if (Objects.isNull(oldMusic.getMusicAuthor())) {
                throw new RuntimeException("歌曲作者不能为空");
            }
            if (oldMusic.getMusicName().equals(newMusic.getMusicName()) && oldMusic.getMusicAuthor().equals(newMusic.getMusicAuthor())) {
                throw new RuntimeException("已存在该歌曲");
            }
        }
        return musicMapper.insertSelective(newMusic);
    }

//    public static void main(String[] args) {
//        List arr = new ArrayList();
//        Optional<List> op = Optional.of(arr);
//        System.out.println(op.isPresent());
//        System.out.println(arr.isEmpty());
//    }
}
