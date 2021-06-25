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
@ApiModel(value="User对象", description="")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type= IdType.ASSIGN_ID )
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableField(value = "trolley_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long trolleyId;

    @TableField(value = "nick_name")
    private String nickName;

    @TableField(value = "phone_number")
    private String phoneNumber;

    private String password;

    private Integer point;

    private String avatar;

    private Integer type;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
