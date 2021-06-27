package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.GoodsComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.CommentDTO;
import com.example.mybatisplus.model.vo.GoodsCommentVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-27
 */
@Repository
public interface GoodsCommentService extends IService<GoodsComment> {
    <T> Page<GoodsCommentVO> commentList(Page<T> tPage, CommentDTO commentDTO);

    void deleteCommentByIds(List<Long> ids);
}
