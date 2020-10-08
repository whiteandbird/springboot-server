package com.itwang.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: whiteanbird
 * @Descripter:
 * @Date: 2020:10:06  20:10
 */
@Component
public class TeacherHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("gmtCreate",new Date(),metaObject);
        setFieldValByName("gmtModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
