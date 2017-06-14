package com.github.controller;

import com.github.annotation.OnPage;
import com.github.common.Pageable;
import com.github.entity.Music;
import com.github.service.MusicService;
import com.github.vo.common.MusicVo;
import com.github.vo.resp.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qwe on 17/4/1.
 */
@RestController
public class MusicController {
    @Autowired
    private MusicService musicService;

    @PostMapping("/v1/music/list")
    @ResponseBody
    public Resp<List<Music>> getMusicList(@RequestBody Pageable page) {
        return Resp.success(musicService.getMusicList(page));
    }

    @GetMapping("/v1/music/list/all")
    @ResponseBody
    public Resp<List<Music>> getAllMusicList() {
        return Resp.success(musicService.getMusicListForAll());
    }
    @PostMapping("/v1/music/save")
    @ResponseBody
    public Resp<String> save(@RequestBody MusicVo vo) {
        int count = musicService.save(vo);
        return count == 0 ? Resp.error("保存失败") : Resp.success("保存成功");
    }

}
