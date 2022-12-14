package com.gxa.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gxa.common.utils.Result;
import com.gxa.modules.sys.entity.Student;
import com.gxa.modules.sys.entity.StudentAttendance;
import com.gxa.modules.sys.entity.StudentClass;
import com.gxa.modules.sys.form.StudentAttStatusForm;
import com.gxa.modules.sys.form.StudentStartAttFrom;
import com.gxa.modules.sys.form.StudentTodayForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAttendanceService extends IService<StudentAttendance> {
    //根据老师id查询该学校所有年级
    public List<StudentClass> queryStudentClassByUserId(Integer userId);
    //根据老师id查询该老师所管班级学生
    public Result<List<StudentAttendance>> queryAllStudentBy(StudentTodayForm studentTodayFrom);
    //根据条件获取当前该班所有学生初始化考勤状态
    public Result<List<StudentAttendance>> queryMeStudentBy(StudentStartAttFrom studentStartAttFrom);
    //根据学生id和日期修改学生考勤状态
    public Result updateStudentStatus(StudentAttStatusForm studentAttStatusForm);
    //根据当前登录用户ID，和班级ID，查询该班级所有学生
    public List<Student> queryXAllStudent(Integer userId,Integer classId);
    public List<Student> queryXAllStudentName(Integer classId);


}
