package com.haixing.newssystemboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haixing.newssystemboot.controller.dto.NewsDTO;
import com.haixing.newssystemboot.controller.dto.ShowNewsDTO;
import com.haixing.newssystemboot.mapper.NewsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import com.haixing.newssystemboot.service.INewsService;
import com.haixing.newssystemboot.entity.News;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kato Megumi
 * @since 2024-01-22
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsMapper newsMapper;
    @Resource
    private INewsService newsService;

    @GetMapping("/findLastEightNews")
    public List<NewsDTO> findLastEightNews() {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "title", "addtime")
                .orderByDesc("addtime")
                .last("LIMIT 8");
        List<News> newsList = newsMapper.selectList(queryWrapper);

        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : newsList) {
            NewsDTO newsDTO = new NewsDTO(news.getId(), news.getTitle(), news.getAddtime());
            // 将News对象的属性复制到NewsDTO对象中...
            newsDTOList.add(newsDTO);
        }

        return newsDTOList;
    }

    @GetMapping("/shownews")
    public ShowNewsDTO showNews(@RequestParam(value = "id", required = false) Integer id) {
        News news = newsService.showNews(id);
        if (news != null) {
            ShowNewsDTO showNewsDTO = new ShowNewsDTO(news.getId(), news.getTitle(), news.getAddtime(), news.getContent());
            // 根据实际需要将News对象的其他属性复制到ShowNewsDTO对象中...
            return showNewsDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No news found with the specified ID.");
        }
    }

    @GetMapping("/findLastFiveNews")
    public List<NewsDTO> findLastFiveNews() {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "title", "addtime")
                .orderByDesc("addtime")
                .last("LIMIT 5");
        List<News> newsList = newsMapper.selectList(queryWrapper);

        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : newsList) {
            NewsDTO newsDTO = new NewsDTO(news.getId(), news.getTitle(), news.getAddtime());
            // 将News对象的属性复制到NewsDTO对象中...
            newsDTOList.add(newsDTO);
        }

        return newsDTOList;
    }

    @GetMapping("/search")
    public List<News> search(@RequestParam(value = "title", required = false) String title) {
        if (title == null || title.isEmpty()) {
            try {
                throw new MissingServletRequestParameterException("title", "string");
            } catch (MissingServletRequestParameterException e) {
                throw new RuntimeException(e);
            }
        }
        return newsService.search(title);
    }

    @PostMapping
    public boolean save(@RequestBody News news) {
        // 新增或更新
        return newsService.saveOrUpdate(news);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return newsService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return newsService.removeByIds(ids);
    }

    @GetMapping
    public List<News> findAll() {
        return newsService.list();
    }

    @GetMapping("/{id}")
    public News findOne(@PathVariable Integer id) {
        return newsService.getById(id);
    }

    @GetMapping("/page")
    public Page<News> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String title
                               ) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        if (!title.isEmpty()) {
            queryWrapper.like("title", title);
        }
        queryWrapper.orderByDesc("id");
        return newsService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
}

