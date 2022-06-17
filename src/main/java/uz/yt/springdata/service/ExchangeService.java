package uz.yt.springdata.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.dto.TimeTableDTO;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

@Service
public class ExchangeService {

    @Value("${abdulloh.host}")
    private String host;

    public ResponseEntity<String> getRemoteUsers(){
        RestTemplate restTemplate = new RestTemplate();

        String url = host + "/rosp/get";

        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<?> postTimeTable(TimeTableDTO dto){
        RestTemplate restTemplate = new RestTemplate();

        String url = host + "/rosp/add";

        HttpEntity<TimeTableDTO> httpEntity = new HttpEntity<>(dto);

        ResponseEntity<ResponseDTO<TimeTableDTO>> response = restTemplate
                .exchange(url,
                        HttpMethod.POST,
                        httpEntity,
                        ParameterizedTypeReference
                                .forType(ResolvableType
                                        .forClassWithGenerics(ResponseDTO.class, TimeTableDTO.class)
                                        .getType()));

        return response.getStatusCode() == HttpStatus.OK ?
                response :
                ResponseEntity.status(response.getStatusCode()).body("Abdullohni serveri bilan muammo");
    }
}
