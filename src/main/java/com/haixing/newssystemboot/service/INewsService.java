package com.haixing.newssystemboot.service;

import com.haixing.newssystemboot.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kato Megumi
 * @since 2024-01-22
 */
public interface INewsService extends IService<News> {

    List<News> search(String title);
}
