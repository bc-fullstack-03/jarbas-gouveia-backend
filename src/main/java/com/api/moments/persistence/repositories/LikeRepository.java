package com.api.moments.persistence.repositories;

import com.api.moments.persistence.entities.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LikeRepository extends MongoRepository<Like, UUID> {
  Like findByMomentIdAndUserId(UUID momentId, UUID userId);
}
