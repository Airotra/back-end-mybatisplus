package com.example.mybatisplus.common.utls;

import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.model.dto.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityUtils {
    /**
     * 获取当前用户
     *
     * @return
     */
    public static User getCurrentUserInfo() {
        User userInfo = SessionUtils.getCurrentUserInfo();
        //模拟登录
        if (userInfo == null) {
            userInfo = new User();
            userInfo.setNickName("模拟用户");
        }

        return userInfo;
    }

    public static UserInfoDTO getUserInfo() {
        User userInfo = SessionUtils.getCurrentUserInfo();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        //模拟登录
        if (userInfo == null) {
            userInfo = new User();
            userInfo.setNickName("模拟用户2");
            userInfoDTO.setId(1L);
            userInfoDTO.setName("模拟用户2");
            userInfoDTO.setUserType(1L);
        }else{
            userInfoDTO.setId(userInfo.getId());
            userInfoDTO.setName(userInfo.getNickName());
            userInfoDTO.setUserType(1L);
        }

        return userInfoDTO;
    }
}
