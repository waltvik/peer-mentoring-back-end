package com.codecool.peermentoringbackend.service;

import com.codecool.peermentoringbackend.entity.ReviewEntity;
import com.codecool.peermentoringbackend.entity.UserEntity;
import com.codecool.peermentoringbackend.model.ReviewModel;
import com.codecool.peermentoringbackend.repository.ReviewRepository;
import com.codecool.peermentoringbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;


    public void addNewReview(ReviewModel review, String username) {

        UserEntity reviewedUser = userRepository.findDistinctById(review.getReviewedUser());

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .rating(review.getRating())
                .review(review.getReview())
                .reviewer(username)
                .reviewed_user(reviewedUser)
                .build();

        reviewRepository.save(reviewEntity);


    }
}
