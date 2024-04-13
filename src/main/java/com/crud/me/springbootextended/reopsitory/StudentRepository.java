package com.crud.me.springbootextended.reopsitory;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.me.springbootextended.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
