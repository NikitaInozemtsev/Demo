package com.example.demo.API;


import com.example.demo.MODEL.Record1;
import com.example.demo.Reps.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org. springframework. stereotype. Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MyController {


    private Context conte = null;

    public MyController(@Value("${spring.datasource.url}") String DATABASE_URL,
                        @Value("${spring.datasource.username}") String USER,
                        @Value("${spring.datasource.password}") String PASSWORD,
                        @Autowired ModelRepository r) {
        conte = new Context(DATABASE_URL, USER, PASSWORD, r);
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ResponseEntity<List<Record1>> getJSON() {
        return conte.select();
    }
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseBody
    public void postJSON(@RequestBody Record1 obj) {
        conte.insert(obj);
    }
    @RequestMapping(value = "/strategy", method = RequestMethod.POST)
    @ResponseBody
    public void strategySwitch(String cl) {
        conte.strategySwitch(cl);
    }
}

