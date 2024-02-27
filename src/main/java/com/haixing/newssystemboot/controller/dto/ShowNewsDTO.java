package com.haixing.newssystemboot.controller.dto;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sys_news")
public class ShowNewsDTO {
    private Integer id;
    private String title;
    private LocalDateTime addtime;
    private String content;

    public ShowNewsDTO(Integer id, String title, LocalDateTime addtime, String content) {
        this.id = id;
        this.title = title;
        this.addtime = addtime;
        this.content = content;
    }
}
