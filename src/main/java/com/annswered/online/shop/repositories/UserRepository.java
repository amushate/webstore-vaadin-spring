package com.annswered.online.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annswered.online.shop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
