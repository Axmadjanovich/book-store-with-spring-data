package uz.yt.springdata.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.dto.UserDTO;
import uz.yt.springdata.dto.UserLoginDto;
import uz.yt.springdata.service.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping
    public ResponseDTO<String> login(@RequestBody UserLoginDto userLoginDto, HttpServletRequest request) {
        return userDetailsService.getToken(userLoginDto, request);
    }

    @GetMapping
    public String check(){
        return "Assalomu alaykum";
    }
}
