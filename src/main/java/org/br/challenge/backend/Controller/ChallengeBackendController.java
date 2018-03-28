package org.br.challenge.backend.Controller;

import org.br.challenge.backend.Controller.dto.ItemDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/challenge-backend")
public class ChallengeBackendController {

  private static final String REST_SERVICE_URI = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

  @RequestMapping(method = RequestMethod.GET, value = "/item")
  public List<ItemDTO> findAll(
      @DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam(value = "begindate")
          final Date begindate,
      @DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam(value = "finaldate")
          final Date finaldate) {

    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<ItemDTO[]> response =
        restTemplate.getForEntity(REST_SERVICE_URI, ItemDTO[].class);

    return Arrays.asList(response.getBody())
        .stream()
        .filter(i -> i.getDate().before(finaldate) && i.getDate().after(begindate))
        .collect(Collectors.toList());
  }
}
