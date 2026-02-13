package com.QR_Generator.Controller;

import com.QR_Generator.QRLogic.ModelSwitcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QRController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/generate")
    public String QRGenerator(@RequestParam("text") String text, Model model){
        System.out.println("User Entered : " + text);
        model.addAttribute("message", "You entered: " + text);
        return "index";
    }
}
