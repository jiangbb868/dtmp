package com.alkaid.dtmp.sso.common.serial;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.alkaid.dtmp.sso.dao.model.User;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SsoOptimizerImpl implements SerializationOptimizer {
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        //这里可以把所有需要进行序列化的类进行添加
        classes.add(JSONObject.class);
        classes.add(User.class);
        return classes;
    }
}
