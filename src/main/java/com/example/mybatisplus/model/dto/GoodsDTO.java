package com.example.mybatisplus.model.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
public class GoodsDTO {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
}
