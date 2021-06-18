package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2021-06-17
 */
@Data
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Goods对象", description="")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "goods_id",type= IdType.ASSIGN_ID )
    private Long goodsId;

    private Integer category;

    private Double price;

    private Integer store;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime time;

    private String description;

    private String picture;

    @TableField(value = "purchase_times")
    private Integer purchaseTimes;

    @TableField(value = "side_dec_1")
    private String sideDec1;

    @TableField(value = "side_dec_2")
    private String sideDec2;

    @TableField(value = "side_dec_3")
    private String sideDec3;


    @Override
    protected Serializable pkVal() {
        return this.goodsId;
    }

}
