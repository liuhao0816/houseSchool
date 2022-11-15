package com.gxa.modules.sys.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxa.modules.sys.entity.NotifyType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 七天
 * @version 1.1
 * @date 2022/11/11
 */
@Repository
@Mapper
public interface NotifyTypeMapper extends BaseMapper<NotifyType> {
}