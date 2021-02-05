package com.example.demo.API;

import com.example.demo.BACK.HibernateClass;
import com.example.demo.BACK.JDBCClass;
import com.example.demo.MODEL.Record1;
import com.example.demo.Reps.ModelRepository;
import org.springframework.http.ResponseEntity;
import com.example.demo.BACK.Strategy;

import java.util.List;

public class Context {
    private String DATABASE_URL;
    private String  USER;
    private String PASSWORD;
    private ModelRepository reps;
    private Strategy st = null;

    Context(String DATABASE_URL, String USER, String PASSWORD, ModelRepository rep){
        this.DATABASE_URL = DATABASE_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.reps = rep;
        st = new JDBCClass(DATABASE_URL, USER, PASSWORD);
    }

    public ResponseEntity<List<Record1>> select() {
        return st.select();
    }
    public void insert(Record1 obj) {
        st.insert(obj.getName(), obj.getData());
    }

    public void strategySwitch(String cl) {
        if("jdbc".equals(cl.toLowerCase())) {
            st = new JDBCClass(DATABASE_URL, USER, PASSWORD);
        }
        else if("hibernate".equals(cl.toLowerCase())){
            st = new HibernateClass(this.reps);
        }
    }

}
