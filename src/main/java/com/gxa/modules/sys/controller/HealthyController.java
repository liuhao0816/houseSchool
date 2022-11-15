package com.gxa.modules.sys.controller;

import com.gxa.common.utils.PageUtils;
import com.gxa.common.utils.Result;
import com.gxa.modules.sys.entity.*;
import com.gxa.modules.sys.service.HealthyService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "健康中心接口")
@RestController
@Slf4j
public class HealthyController {
    @Autowired
    private HealthyService healthyService;

    @GetMapping("/healthy01")
    @ResponseBody
    @ApiOperation(value = "查找接口",notes = "查找全部信息",httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 0,message = "ok",response = Healthy.class)
    })
    public Result appraiseList(){
        List<Healthy> healthy01 = this.healthyService.queryAll();
        Map map = new HashMap();
        map.put("healthy01",healthy01);
        return new Result<>().ok(map);
    }
    @GetMapping("/healthy02")
    @ResponseBody
    @ApiOperation(value = "查找接口",notes = "单个遍历查询",httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 0,message = "ok",response = Appraise.class)
    })
    public Result healthyUpdateList(@RequestParam String userName,String createTime){
        List<Healthy> healthyList = this.healthyService.queryByPublisher(userName,createTime);
        Map map = new HashMap();
        map.put("healthyList",healthyList);
        return new Result<>().ok(map);
    }
    @GetMapping("/healthy/recipient01")
    @ResponseBody
    @ApiOperation(value = "查找接口",notes = "添加处查询用户孩子班级",httpMethod = "GET")
    public Result healthyRecipient01(@RequestParam int userId){
        List<ClassGrade> healthyClass = this.healthyService.queryByHealthyClass(userId);

        return new  Result<>().ok(healthyClass);
    }
    @GetMapping("/healthy/recipient02")
    @ResponseBody
    @ApiOperation(value = "查找接口",notes = "添加处根据班级查询老师名",httpMethod = "GET")
    public Result healthyRecipient02(@RequestParam int classId){
        List<User> healthyTeacher = this.healthyService.queryByHealthyTeacher(classId);
        return new  Result<>().ok(healthyTeacher);
    }


    @PostMapping("/healthy/add")
    @ResponseBody
    @ApiOperation(value = "添加",notes = "添加健康提醒",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 0,message = "ok",response = Healthy.class)
    })
    public Result healthyAdd(@RequestBody Healthy healthy){
        try {
            this.healthyService.add(healthy);
        } catch (Exception e) {
            e.printStackTrace();
            new Result<>().ok("fail");
        }
        return new Result<>().ok("succes");
    }
    @DeleteMapping("/healthy/delete")
    @ApiOperation(value = "删除接口",notes = "健康通知删除",httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code = 0,message = "ok")
    })
    public Result healthyDelete(@RequestParam String userName,String createTime){
        try {
            this.healthyService.delete(userName,createTime);
        } catch (Exception e) {
            e.printStackTrace();
            new Result<>().ok("fail");
        }
        return new  Result<>().ok("succes");
    }
    @PostMapping("/healthy/search")
    @ResponseBody
    @ApiOperation(value = "查询接口",notes = "搜索查询",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 0,message = "ok",response = Healthy.class)
    })
    public Result healthySearch(@RequestBody HealthyDto healthyDto){
        String tollDate = healthyDto.getCreateTime();
        System.out.println(tollDate);
        String firstDateTime =null;
        String lastDateTime = null;

        if (tollDate != null && !"".equals(tollDate)) {
            String[] dateTime = tollDate.split(",");
            firstDateTime = dateTime[0].trim();
            lastDateTime =  dateTime[1].trim();
            try {
                List<Healthy> healthyList = this.healthyService.queryByHealthyDto(firstDateTime,lastDateTime,healthyDto);
                Map map = new HashMap();
                map.put("healthyList",healthyList);
                return new Result<>().ok(map);
            } catch (Exception e) {
                e.printStackTrace();
                new Result<>().ok("fail");
            }
        } else {
            List<Healthy> healthyList = this.healthyService.queryByHealthyDtos(healthyDto);
            Map map = new HashMap();
            map.put("healthyList",healthyList);
            return new Result<>().ok(map);
        }
        return new Result<>().ok();
    }
    @ApiOperation(value="健康中心分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "page",value ="当前是第几页",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "limit",value ="每页显示多少条",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "username",value ="查询条件",dataType ="String"),
            @ApiImplicitParam(paramType = "query",name = "order",value ="升序asc，降序填desc",dataType ="String"),
            @ApiImplicitParam(paramType = "query",name = "sidx",value ="排序字段",dataType ="String"),

    })
    @GetMapping("/healthy/list01")
    public Result<PageUtils> list01(@RequestParam @ApiIgnore Map<String,Object> params){
        log.info("----params-----{}----",params);
        PageUtils pageUtils = this.healthyService.queryByPage01(params);
        return new Result<PageUtils>().ok(pageUtils);
    }
}