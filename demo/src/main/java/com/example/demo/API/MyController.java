package com.example.demo.API;

import org.json.JSONObject;
import org. springframework. stereotype. Controller;
import org. springframework. web. bind. annotation. RequestMapping;
import org. springframework. web. bind. annotation. RequestMethod;
import  java.sql.*;

@Controller
public class MyController {
    @RequestMapping(value = "/records", method = RequestMethod. GET)
    public JSONObject getJSON() {
        return null;
    }
    @RequestMapping(value = "/records", method = RequestMethod. POST)
    public void postJSON(JSONObject object) {

    }
    @RequestMapping(value = "/strategy", method = RequestMethod. POST)
    public void strategySwitch() {

    }
}
