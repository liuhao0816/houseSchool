package com.gxa.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("healthy")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("健康信息实体")
public class Healthy {
    @ApiModelProperty(name = "id",value = "序号")
    private Integer id;
    @ApiModelProperty(name = "studentName",value = "学生姓名")
    private String studentName;
    @ApiModelProperty(name = "gradeClass",value = "年级班级")
    private String gradeClass;
    @ApiModelProperty(name = "content",value = "带药提醒")
    private String content;
    @ApiModelProperty(name = "healthyTime",value = "用药时间")
    private String healthyTime;
    @ApiModelProperty(name = "userName",value = "发送者")
    private String userName;
    @ApiModelProperty(name = "createTime",value = "发送时间")
    private String createTime;
    @ApiModelProperty(name = "recipient",value = "接收人")
    private String recipient;
    @ApiModelProperty(name = "image",value = "图片地址")
    private String image;
}
