package com.alkaid.dtmp.sso.api;


import com.alkaid.dtmp.common.base.BaseService;
import com.alkaid.dtmp.common.pojo.DtmpResult;
import com.alkaid.dtmp.sso.dao.model.User;
import com.alkaid.dtmp.sso.dao.model.UserExample;

public interface UserService extends BaseService<User, UserExample> {

    public String getUserName(User user);

    public User getUser(User user);

    public DtmpResult login(User user);
}
