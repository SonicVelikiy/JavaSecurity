package uz.pdp.cardtransfer.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping("/")
    public HttpEntity<?> HomePage(){
        return ResponseEntity.ok("Ok");
    }
    @GetMapping("/test")
    public HttpEntity<?> TestPage(){
        return ResponseEntity.ok("Sistemaga kirdik");
    }
}
