package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.GoodsComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.dto.CommentDTO;
import com.example.mybatisplus.model.vo.GoodsCommentVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-27
 */
public interface GoodsCommentMapper extends BaseMapper<GoodsComment> {
    <T> Page<GoodsCommentVO> commentList(Page<T> tPage, @Param("commentDTO") CommentDTO commentDTO);
}
