package com.example.caesarcipher.controller

import com.example.caesarcipher.service.CaesarCipherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CaesarCipherController {

    @Autowired
    CaesarCipherService caesarCipherService

    @GetMapping("/")
    String index() {
        return "index"
    }

    @PostMapping("/encrypt")
    String encrypt(@RequestParam("input") String input, @RequestParam("shift") int shift, Model model) {
        String encrypted = caesarCipherService.encrypt(input, shift)
        model.addAttribute("encrypted", encrypted)
        return "result"
    }
}
