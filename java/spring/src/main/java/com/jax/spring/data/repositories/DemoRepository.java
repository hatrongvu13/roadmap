package com.jax.spring.data.repositories;

import com.jax.spring.data.entities.Demo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends MongoRepository<Demo, ObjectId> {
}
