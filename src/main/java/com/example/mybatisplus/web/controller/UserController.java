package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.model.domain.Trolley;
import com.example.mybatisplus.service.TrolleyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.UserService;
import com.example.mybatisplus.model.domain.User;

import javax.servlet.http.HttpServletResponse;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-19
 * @version v1.0
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger( UserController.class );

    @Autowired
    private UserService userService;

    @Autowired
    private TrolleyService trolleyService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        User  user =  userService.getById(id);
        return JsonResponse.success(user);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        userService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateUser(@PathVariable("id") Long  id,User  user) throws Exception {
        user.setId(id);
        userService.updateById(user);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建User
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(User  user) throws Exception {
        userService.save(user);
        return JsonResponse.success(null);
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public JsonResponse login(User user, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getPhoneNumber, user.getPhoneNumber()).eq(User::getPassword, user.getPassword());
        User one = userService.getOne(wrapper);
        if(one != null){
            SessionUtils.saveCurrentUserInfo(one);
        }
        return  JsonResponse.success(one);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public void logout(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        SessionUtils.removeCurrentAdminInfo();
        SessionUtils.removeCurrentUserInfo();
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public Boolean register(User user, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getPhoneNumber, user.getPhoneNumber());
        User one = userService.getOne(wrapper);
        if (one == null) {
            Trolley trolley = new Trolley();
            trolleyService.save(trolley);

            user.setTrolleyId(trolley.getId());
            System.out.println(trolley.getId());
            userService.save(user);

            return true;
        } else {
            return  false;
        }
    }
}

