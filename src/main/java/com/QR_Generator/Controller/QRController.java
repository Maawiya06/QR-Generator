package com.QR_Generator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QRController {

    @PostMapping("/generate")
    public String getResponse(){
        return "index.html";
    }
}
