package com.exercicio.apikey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class ApiKeyService {

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestClient client = RestClient.create();

    public Map<String, Object> consultarClima(String cidade) {
        return client.get()
                .uri(apiUrl + "?q=" + cidade + "&appid=" + apiKey + "&units=metric&lang=pt_br")
                .retrieve()
                .body(Map.class);
    }
}
