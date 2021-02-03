package com.example.demo.BACK;


import com.example.demo.MODEL.Record1;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Strategy {
    public void createConnection();
    public ResponseEntity<List<Record1>> select();
    public void insert(String name, String data);
    public void deleteConnection();
}
