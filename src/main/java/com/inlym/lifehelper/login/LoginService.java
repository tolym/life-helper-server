package com.inlym.lifehelper.login;

import com.inlym.lifehelper.common.auth.jwt.JwtService;
import com.inlym.lifehelper.common.constant.Role;
import com.inlym.lifehelper.external.weixin.WeixinService;
import com.inlym.lifehelper.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * 登录服务
 *
 * @author <a href="https://www.inlym.com">inlym</a>
 * @date 2022-01-23
 * @since 1.0.0
 **/
@Service
@Slf4j
public class LoginService {
    private final UserService userService;

    private final WeixinService weixinService;

    private final JwtService jwtService;

    public LoginService(UserService userService, WeixinService weixinService, JwtService jwtService) {
        this.userService = userService;
        this.weixinService = weixinService;
        this.jwtService = jwtService;
    }

    /**
     * 通过微信获取的 code 登录，并返回登录凭证
     *
     * @param code 微信小程序中获取的 code
     *
     * @return JWT 字符串
     *
     * @since 1.0.0
     */
    public String loginByCode(String code) {
        String openid = weixinService.getOpenidByCode(code);
        int userId = userService.getUserIdByOpenid(openid);
        String token = jwtService.create(userId, Duration.ofDays(30), new String[0]);

        log.info("[用户登录] code={}, openid={}, userId={}", code, openid, userId);

        return token;
    }

    /**
     * 开发者登录
     *
     * @param userId 用户 ID
     *
     * @return 具有开发者角色的 JWT
     *
     * @since 1.0.0
     */
    public String loginForDeveloper(int userId) {
        return jwtService.create(userId, new String[]{Role.DEVELOPER});
    }
}
