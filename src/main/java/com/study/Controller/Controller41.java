package com.study.Controller;

import com.study.domain.MyBean411;
import com.study.domain.MyBean412;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/main41")
public class Controller41 {
    @PostMapping("sub1")
    public void sub1(@RequestBody Map<String, Object> map) {
        System.out.println("Controller41.sub1");
        // 역직렬화(파싱, 디코딩) JSON -> Map
        System.out.println("map = " + map);
    }

    @PostMapping("sub2")
    public void sub2(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    @PostMapping("sub3")
    public void sub3(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    @PostMapping("sub4")
    public void sub4(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    @PostMapping("sub5")
    public void sub5(@RequestBody Map<String, Object> map) {
        // map = {name=son, age=33, married=false, team={location=london, name=토트넘}, item=[0, 1, 2, 3, 4, 가, 나, 다], address=null}
        //son
        //{location=london, name=토트넘}
        //class java.util.LinkedHashMap
        //class java.util.ArrayList
        System.out.println("map = " + map);
        System.out.println(map.get("name"));
        System.out.println(map.get("team"));
        System.out.println(map.get("team").getClass());
        System.out.println(map.get("item").getClass());
    }

    @PostMapping("sub6")
    public void sub6(@RequestBody MyBean411 bean411) {
        // bean411 = MyBean411(name=son, age=33)
        System.out.println("bean411 = " + bean411);
    }

    @PostMapping("sub7")
    public void sub7(@RequestBody MyBean412 bean412) {
        System.out.println("bean412 = " + bean412);
        System.out.println(bean412.get한글()); // [가, 나, 다]
        System.out.println(bean412.getAlphabet()); // {a=a, b=b}
        System.out.println(bean412.getInfo()); // MyBean411(name=jaehoo, age=7)
        System.out.println(bean412.getInfo().getClass()); // class com.study.domain.MyBean411
        System.out.println(bean412.get한글().getClass()); // class java.util.ArrayList
    }
}
