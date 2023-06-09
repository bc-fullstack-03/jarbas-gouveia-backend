package com.api.moments.persistence.entities;

import com.api.moments.util.Timestamp;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
@Data
public class Comment {
  @Id
  private UUID id;
  private String content;
  private UUID momentId;
  private UUID userId;
  private LocalDateTime createdAt;

  public Comment(String content, UUID userId, UUID momentId) {
    this.setId();
    this.setContent(content);
    this.setMomentId(momentId);
    this.setUserId(userId);
    this.setCreatedAt();
  }

  public void setId() {
    this.id = UUID.randomUUID();
  }

  public void setCreatedAt() {
    this.createdAt = Timestamp.getTimestamp();
  }
}
