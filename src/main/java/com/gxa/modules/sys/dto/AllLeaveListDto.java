package com.gxa.modules.sys.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class AllLeaveListDto {
    @ApiModelProperty("id")
    @TableField("id")
    private Integer id ;

    @ApiModelProperty("学生姓名")
    @TableField("student_name")
    private String studentName;

    @ApiModelProperty("年级班级")
    @TableField("class_grade_name")
    private String classGradeName;

    @ApiModelProperty("学生id")
    @TableField("student_id")
    private Integer studentId;

    @ApiModelProperty("请假时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField("launch_time")
    private Date launchTime;

    @ApiModelProperty("请假类型")
    @TableField("leave_type")
    private String leaveType;

    @ApiModelProperty("请假理由")
    @TableField("reason")
    private String reason;

    @ApiModelProperty("老师确认")
    @TableField("teacher_approve")
    private String teacherApprove;

    @ApiModelProperty("开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField("start_time")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField("end_time")
    private Date endTime;

    @ApiModelProperty("发起人")
    @TableField("sponsor")
    private String sponsor;

    @ApiModelProperty("家长确认")
    @TableField("parents_confirm")
    private String parentsConfirm;

    @ApiModelProperty("请假状态")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("病假")
    private Integer sick;

    @ApiModelProperty("事假")
    private Integer absence;

    @TableLogic
    private Integer isDeleted;
}
