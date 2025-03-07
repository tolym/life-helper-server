package com.inlym.lifehelper.weather.weatherplace;

import com.inlym.lifehelper.common.annotation.UserId;
import com.inlym.lifehelper.common.annotation.UserPermission;
import com.inlym.lifehelper.weather.weatherplace.entity.WeatherPlace;
import com.inlym.lifehelper.weather.weatherplace.pojo.WeixinChooseLocationDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 天气地点控制器
 *
 * @author inlym
 * @date 2022-02-13 20:50
 **/
@RestController
public class WeatherPlaceController {
    private final WeatherPlaceService weatherPlaceService;

    public WeatherPlaceController(WeatherPlaceService weatherPlaceService) {
        this.weatherPlaceService = weatherPlaceService;
    }

    /**
     * 新增天气地点
     */
    @PostMapping("/weather/place")
    @UserPermission
    public WeatherPlace add(@Validated @RequestBody WeixinChooseLocationDTO dto, @UserId int userId) {
        return weatherPlaceService.add(userId, dto);
    }

    /**
     * 删除一条天气地点
     */
    @DeleteMapping("/weather/place/{id}")
    @UserPermission
    public Map<String, Object> delete(@PathVariable("id") int id, @UserId int userId) {
        weatherPlaceService.delete(userId, id);
        return Map.of("id", id);
    }

    /**
     * 获取天气地点列表
     */
    @GetMapping("/weather/place")
    @UserPermission
    public Map<String, Object> list(@UserId int userId) {
        return Map.of("list", weatherPlaceService.list(userId));
    }
}
