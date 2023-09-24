package Laba2kurs_1.PervayaLaba.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    List<String> myArrList;
    Map<String, String> stringMap;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "name") String s) {

        if (myArrList==null) {

            myArrList = new ArrayList<>();
        }

            myArrList.add(s);
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {

        return myArrList;
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "name") String s) {

        if (stringMap==null) {

            stringMap = new HashMap<>();
        }

        stringMap.put(s,s);
    }

    @GetMapping("/show-map")
    public Map<String, String> showHashMap() {

        return stringMap;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {

        return "Total element " + (stringMap.size() + myArrList.size());
    }
}
