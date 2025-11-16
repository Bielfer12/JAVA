package com.exercicio.apikey;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clima")
public class ApiKeyController {

    private final ApiKeyService service;

    public ApiKeyController(ApiKeyService service) {
        this.service = service;
    }

    @GetMapping("/{cidade}")
    public Map<String, Object> respostaCriativa(@PathVariable String cidade) {

        Map<String, Object> dados = service.consultarClima(cidade);

        Double temp = (Double) ((Map<String, Object>) dados.get("main")).get("temp");
        String desc = (String) ((Map<String, Object>) ((java.util.List<?>) dados.get("weather")).get(0)).get("description");

        String msg;

        if (temp < 10) {
            msg = "🥶 Frio extremo em " + cidade + "! Ideal para programar debaixo do cobertor.";
        } else if (temp <= 20) {
            msg = "⛅ Clima ameno em " + cidade + ". Perfeito para estudar Spring Boot.";
        } else {
            msg = "🔥 Calorão em " + cidade + "! Só um ar-condicionado salva o programador.";
        }

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("cidade", cidade);
        resposta.put("temperatura", temp);
        resposta.put("descricao", desc);
        resposta.put("mensagem_criativa", msg);

        return resposta;
    }
}
