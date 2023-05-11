package com.api.moments.controllers;

import com.api.moments.services.feed.FeedService;
import com.api.moments.services.moment.response.MomentResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController extends BaseController {
  @Autowired
  private FeedService feedService;

  @GetMapping("/feed/{page}/{pageSize}")
  public ResponseEntity<List<MomentResponse>> getFeed(HttpServletRequest request,
      @PathVariable int page, @PathVariable int pageSize) {

    try {
      var feed = feedService.getFeed(request.getAttribute("userId").toString(), page, pageSize);
      return ResponseEntity.status(HttpStatus.OK).body(feed);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
