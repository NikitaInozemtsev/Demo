package com.example.demo.API;

import com.example.demo.BACK.JDBCClass;
import com.example.demo.MODEL.Record1;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org. springframework. stereotype. Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org. springframework. web. bind. annotation. RequestMapping;
import org. springframework. web. bind. annotation. RequestMethod;

import java.util.List;


@Controller
public class MyController {
    @Value("${general.key}")
    public static String DB = null;



    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ResponseEntity<List<Record1>> getJSON() {
        JDBCClass a = new JDBCClass();
        a.createConnection();
        ResponseEntity<List<Record1>> b = a.select();
        a.deleteConnection();
        return b;
    }
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    public void postJSON(@RequestBody Record1 obj) {
        JDBCClass a = new JDBCClass();
        a.createConnection();
        System.out.println(obj.toString());

            a.insert(obj.getName(), obj.getData());

        a.deleteConnection();
    }
    @RequestMapping(value = "/strategy", method = RequestMethod.POST)
    public void strategySwitch() {

    }
}

