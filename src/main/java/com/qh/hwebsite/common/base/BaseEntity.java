package com.qh.hwebsite.common.base;
/*
 * @Author: zhangxd
 * @Version: v1.0
 * @CreateTime: 2019-09-02 11:03
 * @Package: com.elshou.sun.base.http
 * @Description: BaseEntity
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntity extends Model {

    private static final long serialVersionUID = -8085507948689885710L;

    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedAt;

    @TableLogic
    private Integer deleted;


}
