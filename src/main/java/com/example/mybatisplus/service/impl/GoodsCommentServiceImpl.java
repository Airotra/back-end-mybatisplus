package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.GoodsComment;
import com.example.mybatisplus.mapper.GoodsCommentMapper;
import com.example.mybatisplus.model.dto.CommentDTO;
import com.example.mybatisplus.model.vo.GoodsCommentVO;
import com.example.mybatisplus.service.GoodsCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-27
 */
@Service
public class GoodsCommentServiceImpl extends ServiceImpl<GoodsCommentMapper, GoodsComment> implements GoodsCommentService {

    @Override
    public <T> Page<GoodsCommentVO> commentList(Page<T> tPage, CommentDTO commentDTO) {
        return baseMapper.commentList(tPage,commentDTO);
    }

    @Override
    public void deleteCommentByIds(List<Long> ids) {
        baseMapper.deleteCommentByIds(ids);
    }
}
