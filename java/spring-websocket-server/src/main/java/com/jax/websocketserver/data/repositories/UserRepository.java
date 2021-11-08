package com.jax.websocketserver.data.repositories;

import com.jax.websocketserver.data.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

    Boolean existsUserByEmail(String email);

    Boolean existsUserByUsername(String username);

}
