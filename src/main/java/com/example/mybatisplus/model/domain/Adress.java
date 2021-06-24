package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * ��ַ��
 * </p>
 *
 * @author lxp
 * @since 2021-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Adress对象", description="��ַ��")
public class Adress extends Model<Adress> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "address_id",type= IdType.ASSIGN_ID )
    private Long id;

    private Long userId;

    private String nation;

    private String provice;

    private String city;

    private String district;

    private String addr;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
