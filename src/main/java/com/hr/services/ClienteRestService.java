package com.hr.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import com.hr.modelos.UsuarioRestModel;

@Service
@Primary
public class ClienteRestService {

  @Value("${henry.valores.api}")
  private String apiHost;

  @Autowired
  private RestTemplate clienteRest;

  public ClienteRestService(RestTemplateBuilder builder) {
    this.clienteRest = builder.build();
  }

  private HttpHeaders setHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.set("Authorization", "Bearer aquí_va_el_token");
    return headers;
  }

  public List<UsuarioRestModel> listaUsuarios() {
    HttpEntity<String> entity = new HttpEntity<String>(this.setHeaders());
    ResponseEntity<List<UsuarioRestModel>> response = this.clienteRest.exchange(this.apiHost + "todos", HttpMethod.GET,
        entity, new ParameterizedTypeReference<List<UsuarioRestModel>>() {
        });

    return response.getBody();
  }
}
