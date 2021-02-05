package com.example.demo.Reps;


import com.example.demo.MODEL.Record1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Record1, Long> {

}