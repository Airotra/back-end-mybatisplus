package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
 * @since 2021-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type= IdType.ASSIGN_ID )
    private Long id;

    @TableField("trolley_id")
    private Long trolleyId;

    @TableField("nick_name")
    private String nickName;

    @TableField("phone_number")
    private String phoneNumber;

    private String password;

    private Integer point;

    private String avatar;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
