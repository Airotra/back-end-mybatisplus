package com.example.mybatisplus.model.vo;

import com.example.mybatisplus.model.domain.Adress;
import com.example.mybatisplus.model.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class UserVo extends User {
    private List<Adress> list;
}
