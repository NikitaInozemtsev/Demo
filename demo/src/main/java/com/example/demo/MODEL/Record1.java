package com.example.demo.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "bruh")
public class Record1 {
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    int id;
    @Column(name = "name")
    @JsonProperty("name")
    String name;
    @Column(name = "data")
    @JsonProperty("data")
    String data;

    public Record1() {}

    public Record1(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}