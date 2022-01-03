package com.inlym.lifehelper.auth;

/**
 * 角色名称
 */
public interface RoleName {
    /**
     * 普通用户
     */
    String USER = "ROLE_USER";

    /**
     * 开发者
     * <p>
     * 主要用于调试部分接口
     */
    String DEVELOPER = "ROLE_DEVELOPER";

    /**
     * 管理员
     * <p>
     * 用于调试部分权限较高的接口。
     */
    String ADMIN = "ROLE_ADMIN";
}
