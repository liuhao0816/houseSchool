package com.gxa.modules.sys.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel("请假多条件查询")
public class LeaveListDto {

    @ApiModelProperty(value = "当前页码",name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页记录数",name = "limit")
    private Integer limit;

    @ApiModelProperty("开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField("start_time")
    private Date startTime;

    @ApiModelProperty("结束时间")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField("end_time")
    private Date endTime;

    @ApiModelProperty("请假类型")
    @TableField("leave_type")
    private String leaveType;

    @ApiModelProperty("请假状态")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty("学生姓名")
    @TableField("student_name")
    private String studentName;

    @ApiModelProperty("年假班级")
    @TableField("class_grade_name")
    private String classGradeName;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("病假")
    private Integer sick;

    @ApiModelProperty("事假")
    private Integer absence;
}
