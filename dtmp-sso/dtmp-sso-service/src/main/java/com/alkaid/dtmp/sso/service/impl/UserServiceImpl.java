package com.alkaid.dtmp.sso.service.impl;

import com.alkaid.dtmp.common.base.BaseServiceImpl;
import com.alkaid.dtmp.common.constants.DtmpConstants;
import com.alkaid.dtmp.common.pojo.DtmpResult;
import com.alkaid.dtmp.common.util.FastJsonConvert;
import com.alkaid.dtmp.redis.boot.client.JedisClient;
import com.alkaid.dtmp.sso.api.UserService;
import com.alkaid.dtmp.sso.dao.mapper.UserMapper;
import com.alkaid.dtmp.sso.dao.model.User;
import com.alkaid.dtmp.sso.dao.model.UserExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service(version = DtmpConstants.DTMP_SSO_VERSION)
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User, UserExample> implements UserService {

    @Value("${redisKey.prefix.user_session}")
    private String USER_SESSION;

    @Value("${redisKey.expire_time}")
    private Integer EXPIRE_TIME;

    @Value("${login.validation.ispinengaged}")
    private String ISPINENGAGED;

    @Value("${login.validation.isemailengaged}")
    private String ISEMAILENGAGED;

    @Value("${login.validation.ismobileengaged}")
    private String ISMOBILEENGAGED;

    @Value("${login.random_number}")
    private Integer RANDOM_NUMBER;

    @Value("${redisKey.prefix.verifycode}")
    private String VERIFYCODE;

    @Value("${redisKey.prefix.mobile_login_code}")
    private String MOBILE_LOGIN_CODE;

    @Value("${login.success_url}")
    private String SUCCESS_URL;

    @Autowired
    private UserMapper userMapper;

    //@Reference(version = DtmpConstants.DTMP_REDIS_VERSION)
    @Autowired
    private JedisClient jedisClient;

    @Override
    public String getUserName(User user) {
        return user.toString();
    }

    @Override
    public User getUser(User user) {
        return user;
    }

    @Override
    public DtmpResult login(User user) {
        if (user == null) {
            return new DtmpResult(400, "error", "数据为空");
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> list = userMapper.selectByExample(userExample);
        if (list == null || list.size() == 0) {
            return new DtmpResult(400, "用户名或密码错误", null);
        }

        User check = list.get(0);
        if (!check.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))) {
            return new DtmpResult(400, "用户名或密码错误", null);
        }

        User thisUser = new User();
        thisUser.setUserId(check.getUserId());
        thisUser.setUsername(check.getUsername());

        String token = UUID.randomUUID().toString().replaceAll("-", "");
        String key = USER_SESSION + token;
        jedisClient.set(key, FastJsonConvert.convertObjectToJSON(thisUser));
        jedisClient.expire(key, EXPIRE_TIME);
        return new DtmpResult(200, "success", token);
    }
}
