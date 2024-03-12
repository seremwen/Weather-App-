package zw.nseremwe.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";
    private final String geoApiUrl = "http://api.openweathermap.org/geo/1.0/direct?q={city}&limit=5&appid={apiKey}";
    private final String weatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={apiKey}";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherDetails(String cityName) {
        String url = apiUrl.replace("{city}", cityName).replace("{apiKey}", apiKey);
        return restTemplate.getForObject(url, String.class);
    }
    public String getWeatherDetails(double lat, double lon) {
        String url = weatherApiUrl.replace("{lat}", String.valueOf(lat))
                .replace("{lon}", String.valueOf(lon))
                .replace("{apiKey}", apiKey);
        return restTemplate.getForObject(url, String.class);
    }
    public String getCoordinates(String cityName) {
        String url = geoApiUrl.replace("{city}", cityName).replace("{apiKey}", apiKey);
        return restTemplate.getForObject(url, String.class);
    }
}