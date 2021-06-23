package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AdressService;
import com.example.mybatisplus.model.domain.Adress;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-23
 * @version v1.0
 */
@Controller
@RequestMapping("/api/adress")
public class AdressController {

    private final Logger logger = LoggerFactory.getLogger( AdressController.class );

    @Autowired
    private AdressService adressService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Adress  adress =  adressService.getById(id);
        return JsonResponse.success(adress);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        adressService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAdress(@PathVariable("id") Long  id,Adress  adress) throws Exception {
        adress.setId(id);
        adressService.updateById(adress);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Adress
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Adress  adress) throws Exception {
        adressService.save(adress);
        return JsonResponse.success(null);
    }
}

