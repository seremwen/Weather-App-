package zw.nseremwe.controller;

import org.springframework.web.bind.annotation.*;
import zw.nseremwe.entity.WeatherResponse;
import zw.nseremwe.service.WeatherService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("weather/{city}")
    public String getWeather(@PathVariable String city) {
        return weatherService.getWeatherDetails(city);
    }

    @GetMapping("coordinates/{city}")
    public String getCoordinates(@PathVariable String city) {
        return weatherService.getCoordinates(city);
    }
}