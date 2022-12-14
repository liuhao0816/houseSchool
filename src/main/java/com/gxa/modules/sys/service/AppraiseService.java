package com.gxa.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gxa.common.utils.PageUtils;
import com.gxa.modules.sys.entity.*;

import java.util.List;
import java.util.Map;

public interface AppraiseService extends IService<Appraise>{
    List<Appraise> queryAll();
    void add(Appraise appraise);
    List<Appraise> queryByPublisher(int id);
    void update(Appraise appraise);
    void delete(int id);
    List<Appraise> queryByAppraiseDto(String firstDateTime, String lastDateTime,String studentName,String gradeClass,String appraiseTime );
    /**
     * 只是单独的分页，不带查询条件
     * @param params
     * @return
     */
    PageUtils queryByPage01(Map<String,Object> params);

    List<Appraise> queryByAppraiseDtos(String studentName,String gradeClass);

    List<User> queryByPermissionsTeacher();


    List<Appraise> queryAll01(String userName);
}
