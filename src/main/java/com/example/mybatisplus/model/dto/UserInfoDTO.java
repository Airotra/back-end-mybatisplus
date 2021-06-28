package com.example.mybatisplus.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserInfoDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Long userType;
}
