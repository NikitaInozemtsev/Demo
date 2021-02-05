package com.example.demo.BACK;

import com.example.demo.Reps.ModelRepository;
import com.example.demo.MODEL.Record1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class HibernateClass implements Strategy {


    private ModelRepository reps;

    public HibernateClass(ModelRepository reps) {
        this.reps = reps;
    }


    @Override
    public ResponseEntity<List<Record1>> select() {
        return new ResponseEntity<List<Record1>>(reps.findAll(), HttpStatus.OK);
    }

    @Override
    public void insert(String name, String data) {
        Record1 s = new Record1();
        s.setName(name);
        s.setData(data);
        this.reps.save(s);
    }

}
