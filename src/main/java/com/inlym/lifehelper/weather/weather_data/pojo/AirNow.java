package com.inlym.lifehelper.weather.weather_data.pojo;

import lombok.Data;

/**
 * 实时空气质量数据
 *
 * @author inlym
 * @date 2022-02-19
 **/
@Data
public class AirNow {
    /** 空气质量指数 */
    private String aqi;

    /** 空气质量指数等级 */
    private String level;

    /** 空气质量指数级别 */
    private String category;

    /** 空气质量的主要污染物，空气质量为优时，返回值为NA */
    private String primary;

    /** PM10 */
    private String pm10;

    /** PM2.5 */
    private String pm2p5;

    /** 二氧化氮 */
    private String no2;

    /** 二氧化硫 */
    private String so2;

    /** 一氧化碳 */
    private String co;

    /** 臭氧 */
    private String o3;
}
