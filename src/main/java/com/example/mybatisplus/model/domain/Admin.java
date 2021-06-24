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
 * @since 2021-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "admin_id",type= IdType.ASSIGN_ID )
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableField(value = "admin_account")
    private String adminAccount;

    @TableField(value = "admin_password")
    private String adminPassword;

    private Integer type;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
