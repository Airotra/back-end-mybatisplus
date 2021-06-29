package com.example.mybatisplus.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class CommentDeleteDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private List<Long> ids;
}
