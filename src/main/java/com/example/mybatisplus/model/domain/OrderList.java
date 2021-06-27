package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * ������
 * </p>
 *
 * @author lxp
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderList对象", description="������")
public class OrderList extends Model<OrderList> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id",type= IdType.ASSIGN_ID )
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long adressId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String transportNumber;

    private Boolean getBySelf;

    private Boolean paid;

    private Integer orderStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime order_date;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
