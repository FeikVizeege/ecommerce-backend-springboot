package com.group.ecommerce_backend_springboot.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.group.ecommerce_backend_springboot.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{

}
