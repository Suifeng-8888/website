package com.qh.hwebsite.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 新闻资讯表
 * </p>
 *
 * @author jianch
 * @since 2019-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="News对象", description="新闻资讯表")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "新闻标题")
    private String title;

    @ApiModelProperty(value = "摘要")
    private String summary;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "日期")
    private String time;

    @ApiModelProperty(value = "新闻内容")
    private String content;

    @TableField(exist = false)
    private String page;

    @TableField(exist = false)
    private String limit;


    @ApiModelProperty(value = "上条ID")
    @TableField(exist = false)
    private Integer preid;

    @ApiModelProperty(value = "下条ID")
    @TableField(exist = false)
    private Integer nextid;


    @ApiModelProperty(value = "上条标题")
    @TableField(exist = false)
    private String prename;


    @ApiModelProperty(value = "下条标题")
    @TableField(exist = false)
    private String nextname;



}
