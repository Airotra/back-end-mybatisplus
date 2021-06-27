package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author lxp
 * @since 2021-06-27
 */
@Data
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsComment对象", description="")
public class GoodsComment extends Model<GoodsComment> {

    private static final long serialVersionUID = 1L;

    private Long commentId;

    private Long goodsId;

    private Long userId;

    private String comment;

    @TableField("class")
    private Integer commentClass;


    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

}
