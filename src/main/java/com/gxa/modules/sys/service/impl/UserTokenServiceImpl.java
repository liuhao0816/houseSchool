package com.gxa.modules.sys.service.impl;

import com.gxa.common.utils.Base64Utils;
import com.gxa.common.utils.Result;
import com.gxa.common.utils.TokenGenerator;
import com.gxa.modules.sys.entity.User;
import com.gxa.modules.sys.entity.UserPower;
import com.gxa.modules.sys.form.UserPowerFrom;
import com.gxa.modules.sys.redis.SysUserRedis;
import com.gxa.modules.sys.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl  implements UserTokenService {

    @Autowired
    private SysUserRedis sysUserRedis;

    @Override
    public Result createToken(UserPowerFrom userPowerFrom) {
        //生成token
        String uuid = TokenGenerator.generateValue();
        String token = sysUserRedis.addToken(uuid, userPowerFrom);
        String encodeToken = Base64Utils.encode(token);
        return new Result().ok(encodeToken);
    }

    /**
     * 生成验证码token，并出入redis
     * @param resultValue
     * @return
     */
    @Override
    public String verificationCodeNo(String resultValue) {
        //生成token
        String uuid = TokenGenerator.generateValue();

        uuid = sysUserRedis.addToken(uuid, resultValue);

        return uuid;
    }

    @Override
    public String queryByCaptch(String uuid) {
        String resultValue = sysUserRedis.queryByCaptch(uuid);
        return resultValue;
    }

    @Override
    public void deleteToken(String token) {
        String decodeToken = Base64Utils.decode(token);
        sysUserRedis.deleteToken(decodeToken);
    }

    @Override
    public UserPowerFrom validateToken(String token) {
        String decodeToken = Base64Utils.decode(token);
        UserPowerFrom userPowerFrom = sysUserRedis.getUserByToken(decodeToken);
        return userPowerFrom;
    }
}
