package com.example.demo.API;

import com.example.demo.BACK.HibernateClass;
import com.example.demo.BACK.JDBCClass;
import com.example.demo.BACK.Strategy;
import com.example.demo.MODEL.Record1;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org. springframework. stereotype. Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;


@Controller
public class MyController {


    private String DATABASE_URL;
    private String USER;
    private String PASSWORD;

    private Strategy a = null;

    public MyController(@Value("${spring.datasource.url}") String DATABASE_URL,
                        @Value("${spring.datasource.username}") String USER,
                        @Value("${spring.datasource.password}") String PASSWORD) {
        this.DATABASE_URL = DATABASE_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        a = new JDBCClass(DATABASE_URL, USER, PASSWORD);
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ResponseEntity<List<Record1>> getJSON() {
        a.createConnection();
        ResponseEntity<List<Record1>> b = a.select();
        a.deleteConnection();
        return b;
    }
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    public void postJSON(@RequestBody Record1 obj) {
        a.createConnection();
        a.insert(obj.getName(), obj.getData());
        a.deleteConnection();
    }
    @RequestMapping(value = "/strategy", method = RequestMethod.POST)
    @ResponseBody
    public void strategySwitch(String cl) {
        if("jdbc".equals(cl.toLowerCase())) {
            a = new JDBCClass(DATABASE_URL, USER, PASSWORD);
        }
        else if("hibernate".equals(cl.toLowerCase())){
            a = new HibernateClass(DATABASE_URL, USER, PASSWORD);
        }
    }
}

