package com.crud.me.springbootextended.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.me.springbootextended.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
