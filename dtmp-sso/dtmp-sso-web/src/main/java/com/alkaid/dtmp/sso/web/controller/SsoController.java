package com.alkaid.dtmp.sso.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alkaid.dtmp.common.constants.DtmpConstants;
import com.alkaid.dtmp.common.pojo.DtmpResult;
import com.alkaid.dtmp.sso.api.UserService;
import com.alkaid.dtmp.sso.dao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sso")
public class SsoController {

    @Reference(version = DtmpConstants.DTMP_SSO_VERSION)
    private UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    @ResponseBody
    public DtmpResult login (User user) {
        DtmpResult result = userService.login(user);
        return result;
    }

    public DtmpResult logout(String token) {
        DtmpResult result = new DtmpResult(200, "", "");
        return result;
    }
}
