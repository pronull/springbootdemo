package com.github.controller;

import com.github.common.Pageable;
import com.github.entity.Music;
import com.github.service.MusicService;
import com.github.vo.resp.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by qwe on 17/4/1.
 */
@RestController
public class MusicController {
    @Autowired
    private MusicService musicService;

    @RequestMapping("/test")
    @ResponseBody
    public Resp<List<Music>> getMusicList(@RequestBody Pageable page){
        return Resp.success(musicService.getMusicList(page));
    }
}
