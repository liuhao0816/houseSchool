package com.gxa.modules.sys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("V-投票管理列表/发布投票实体")
public class VoteList {
    @ApiModelProperty(value = "投票ID",name = "voteId")
    private int voteId;
    @ApiModelProperty(value = "标题",name = "voteTitle")
    private String voteTitle;
    @ApiModelProperty(value = "状态  1-进行中/2-已结束",name = "voteStatus")
    private int voteStatus;
    @ApiModelProperty(value = "发送范围",name = "voteScope")
    private String voteScope;
    @ApiModelProperty(value = "参与对象",name = "voteRoles")
    private List<Role> voteRoles;
    @ApiModelProperty(value = "发布者",name = "user")
    private User user;
    @ApiModelProperty(value = "发布时间",name = "voteStartTime")
    private Date voteStartTime;

    @ApiModelProperty(value = "投票说明",name = "voteExplain")
    private String voteExplain;
    @ApiModelProperty(value = "投票选项",name = "voteOptions")
    private List<VoteOption> voteOptions;
    @ApiModelProperty(value = "投票类型  1-单选/2-多选",name = "voteType")
    private int voteType;
    @ApiModelProperty(value = "截止时间",name = "voteEndTime")
    private Date voteEndTime;
    @ApiModelProperty(value = "投票结果   1-公开/2-不公开",name = "voteIsopen")
    private int voteIsopen;
    @ApiModelProperty(value = "参与对象字符串",name = "roleStr")
    private String roleStr;
    @ApiModelProperty(value = "参与对象ID集合",name = "roleIds")
    private List<Integer> roleIds;


}
