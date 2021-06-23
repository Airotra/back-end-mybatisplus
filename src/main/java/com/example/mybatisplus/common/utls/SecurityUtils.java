package com.example.mybatisplus.common.utls;

import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.model.dto.AdminInfoDTO;
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

        Admin adminInfo = SessionUtils.getCurrentAdminInfo();
        AdminInfoDTO adminInfoDTO = new AdminInfoDTO();

        //模拟登录
        if (userInfo == null && adminInfo == null) {
            userInfo = new User();
            userInfo.setNickName("临时");
            userInfoDTO.setId(1L);
            userInfoDTO.setName("临时");
            userInfoDTO.setUserType(3L);
        }else if (userInfo != null){
            userInfoDTO.setId(userInfo.getId());
            userInfoDTO.setName(userInfo.getNickName());
            userInfoDTO.setUserType(userInfo.getType().longValue());
        }else {
            userInfoDTO.setId(adminInfo.getId());
            userInfoDTO.setName(adminInfo.getAdminAccount());
            userInfoDTO.setUserType(adminInfo.getType().longValue());
        }
        return userInfoDTO;
    }
}
