package uz.yt.springdata.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.yt.springdata.dto.TimeTableDTO;
import uz.yt.springdata.service.ExchangeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/exchange")
public class ExchangeResource {

    private final ExchangeService exchangeService;

    public ExchangeResource(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://192.168.0.247:2004/rosp/get");
    }

    @PostMapping("/time-table")
    public ResponseEntity<?> addTimeTable(@RequestBody TimeTableDTO dto){
        return exchangeService.postTimeTable(dto);
    }

    @GetMapping
    public ResponseEntity<String> getAllUsers(){
        return exchangeService.getRemoteUsers();
    }
}
