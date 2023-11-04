package com.work.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.work.demo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
