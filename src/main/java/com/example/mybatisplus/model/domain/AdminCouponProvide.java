package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxp
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AdminCouponProvide对象", description="")
public class AdminCouponProvide extends Model<AdminCouponProvide> {

    private static final long serialVersionUID = 1L;

    @TableField(value = "admin_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long adminId;

    @TableField(value = "coupon_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long couponId;


    @Override
    protected Serializable pkVal() {
        return this.adminId;
    }

}
