package com.alkaid.dtmp.attendance.common.serial;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.alkaid.dtmp.attendance.dao.model.WorkOvertime;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AttendanceOptimizerImpl implements SerializationOptimizer {
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        //这里可以把所有需要进行序列化的类进行添加
        classes.add(JSONObject.class);
        classes.add(WorkOvertime.class);
        return classes;
    }
}
