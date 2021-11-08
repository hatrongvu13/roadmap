package com.jax.websocketserver.data.repositories;

import com.jax.websocketserver.data.entities.LoginLogs;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogRepository extends MongoRepository<LoginLogs, ObjectId> {
}
