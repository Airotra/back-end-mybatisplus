package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Goods;
import com.example.mybatisplus.model.dto.CommentDTO;
import com.example.mybatisplus.model.dto.CommentDeleteDTO;
import com.example.mybatisplus.model.dto.GoodsDTO;
import com.example.mybatisplus.model.vo.GoodsCommentVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.GoodsCommentService;
import com.example.mybatisplus.model.domain.GoodsComment;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-27
 * @version v1.0
 */
@Controller
@RequestMapping("/api/goodsComment")
public class GoodsCommentController {

    private final Logger logger = LoggerFactory.getLogger( GoodsCommentController.class );

    @Autowired
    private GoodsCommentService goodsCommentService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        GoodsComment  goodsComment =  goodsCommentService.getById(id);
        return JsonResponse.success(goodsComment);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        goodsCommentService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateGoodsComment(@PathVariable("id") Long  id,GoodsComment  goodsComment) throws Exception {
        goodsComment.setCommentId(id);
        goodsCommentService.updateById(goodsComment);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建GoodsComment
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(GoodsComment  goodsComment) throws Exception {
        goodsCommentService.save(goodsComment);
        return JsonResponse.success(null);
    }
    /************************************************************************************/
    /**
     * 描述:根据条件查询评论列表，实现分页器和等级查询
     * 多表联合查询，要同时查出user的基本信息
     */
    @PostMapping("/listByPage")
    @ResponseBody
    public JsonResponse commentList(@RequestBody CommentDTO commentDTO, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        Page<GoodsCommentVO> page;
        page = goodsCommentService.commentList(new Page<>(commentDTO.getPageNo(),commentDTO.getPageSize()),commentDTO);
        return JsonResponse.success(page);
    }

    /**
     * 描述:根据id列表批量删除
     * 接受Post请求
     */
    @PostMapping("/deleteCommentByList")
    @ResponseBody
    public JsonResponse deleteCommentByList(@RequestBody CommentDeleteDTO commentDeleteDTO, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        List<Long> ids = commentDeleteDTO.getIds();
        goodsCommentService.deleteCommentByIds(ids);
        return JsonResponse.success(null);
    }

}

