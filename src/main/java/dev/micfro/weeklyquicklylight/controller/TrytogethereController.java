package dev.micfro.weeklyquicklylight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrytogethereController {

    @GetMapping("/trytogethere")
    public String userForm() {
        return "trytogethere";
    }
}
