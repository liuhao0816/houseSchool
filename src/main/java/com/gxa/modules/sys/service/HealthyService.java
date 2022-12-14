package com.gxa.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gxa.common.utils.PageUtils;
import com.gxa.modules.sys.entity.ClassGrade;
import com.gxa.modules.sys.entity.Healthy;
import com.gxa.modules.sys.entity.HealthyDto;
import com.gxa.modules.sys.entity.User;

import java.util.List;
import java.util.Map;

public interface HealthyService extends IService<Healthy> {
    List<Healthy> queryAll();
    List<Healthy> queryByPublisher(String userName,String createTime);
    void add(Healthy healthy);
    void delete(int id);

    /**
     * 只是单独的分页，不带查询条件
     * @param params
     * @return
     */
    PageUtils queryByPage01(Map<String,Object> params);

    List<Healthy> queryByHealthyDtos(String studentName, String classGradeName);

    List<ClassGrade> queryByHealthyClass(int userId);

    List<User> queryByHealthyTeacher(int classId);

    List<Healthy> queryByHealthyDto(String firstDateTime, String lastDateTime, String createTime, String studentName, String classGradeName);
}
