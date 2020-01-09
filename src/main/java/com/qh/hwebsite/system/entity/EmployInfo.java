package com.qh.hwebsite.system.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门招聘信息表
 * </p>
 *
 * @author jianch
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EmployInfo对象", description="部门招聘信息表")
public class EmployInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "所属部门ID")
    private Long pid;

    @ApiModelProperty(value = "部门名称")
    private String pname;

    @ApiModelProperty(value = "岗位名称")
    private String station;

    @ApiModelProperty(value = "岗位数量")
    private String number;

    @ApiModelProperty(value = "岗位描述")
    private String depict;

    @ApiModelProperty(value = "岗位要求")
    private String demand;

    @ApiModelProperty(value = "发布时间")
    private String time;

    @TableLogic
    private Integer deleted;

    @TableField(exist = false)
    private String page;

    @TableField(exist = false)
    private String limit;

}
