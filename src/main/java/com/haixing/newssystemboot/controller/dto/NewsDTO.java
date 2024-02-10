package com.haixing.newssystemboot.controller.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("sys_news")
public class NewsDTO {
    private Integer id;
    private String title;
    private LocalDateTime addtime;

    public NewsDTO(Integer id, String title, LocalDateTime addtime) {
        this.id = id;
        this.title = title;
        this.addtime = addtime;
    }
}
