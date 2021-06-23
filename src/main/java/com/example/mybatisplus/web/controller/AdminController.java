package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.common.utls.SessionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AdminService;
import com.example.mybatisplus.model.domain.Admin;

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
@RequestMapping("/api/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger( AdminController.class );

    @Autowired
    private AdminService adminService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Admin  admin =  adminService.getById(id);
        return JsonResponse.success(admin);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        adminService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAdmin(@PathVariable("id") Long  id,@RequestBody Admin  admin) throws Exception {
        admin.setId(id);
        adminService.updateById(admin);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Admin
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Admin  admin) throws Exception {
        adminService.save(admin);
        return JsonResponse.success(null);
    }

    @RequestMapping("/adminLogin")
    @ResponseBody
    public JsonResponse login(Admin admin, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Admin::getAdminAccount, admin.getAdminAccount()).eq(Admin::getAdminPassword, admin.getAdminPassword());
        Admin one = adminService.getOne(wrapper);
        if(one!=null){
            SessionUtils.saveCurrentAdminInfo(one);
        }
        return  JsonResponse.success(one);
    }
}

