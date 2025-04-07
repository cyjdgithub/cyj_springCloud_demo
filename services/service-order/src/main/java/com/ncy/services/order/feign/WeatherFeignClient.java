package com.ncy.services.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather-client",url = "https://restapi.amap.com")
public interface WeatherFeignClient {

    @GetMapping("/v3/weather/weatherInfo")
    String getWeather(@RequestParam("city") String city, @RequestParam("key") String key);
}
