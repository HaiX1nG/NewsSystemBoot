package com.haixing.newssystemboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haixing.newssystemboot.entity.News;
import com.haixing.newssystemboot.mapper.NewsMapper;
import com.haixing.newssystemboot.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Kato Megumi
 * @since 2024-01-22
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {
    public List<News> search(String title) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", "%" + title + "%");
        return this.list(queryWrapper);
    }
}
