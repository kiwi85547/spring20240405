package com.study.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/main42")
public class Controller42 {
    @GetMapping("sub1")
    @ResponseBody
    public String sub1() {
        return "어떤 데이터";
    }

    @GetMapping("/sub2")
    // return값이 view로 해석되지 않게
    @ResponseBody
    public String sub2() {
        double random = Math.random();
        String result = "";
        if (random < 1.0 / 3) {
            return "가위";
        } else if (random > 1.0 / 3 && random < 2.0 / 3) {
            return "바위";
        } else return "보";
    }

    @GetMapping("sub3")
    @ResponseBody
    public Map<String, Object> sub3() {
        return Map.of("name", "화영",
                "age", 33,
                "married", true,
                "info", Map.of("team", "family", "city", "서울"),
                "person", List.of("수환", "수아", "재후"));
    }

    @GetMapping("sub4")
    @ResponseBody
    public Map<String, Object> sub4() {
        return Map.of("게임", "가위바위보", "game", List.of("가위", "바위", "보"));
    }
}
