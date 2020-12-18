package com.dev.fshop.services.impl;

import com.dev.fshop.entity.ReviewEntity;
import com.dev.fshop.repositories.ReviewRepository;
import com.dev.fshop.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewEntity findReviewByReviewId(String  reviewId) {
        return  reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public List<ReviewEntity> findReviewByProductId(String proId) {
//        return reviewRepository.findReviewByProductId(proId);
        return null;
    }


    @Override
    public ReviewEntity createNewReview(ReviewEntity reviewEntity) {
//        ReviewEntity checkExisted = reviewRepository.findById(reviewEntity.getReviewId()).orElse(null);
//        if(checkExisted == null) {
//
//        }
//        return reviewRepository.insertReviewWithEntityManager(reviewEntity);
        return null;
    }

    @Override
    public ReviewEntity updateReviewContentStar(String content, Integer star, String reviewId) {
        //        ReviewEntity checkExisted = reviewRepository.findById(reviewEntity.getReviewId()).orElse(null);
//        if(checkExisted == null) {
//
//        }
        return null;
//        return reviewRepository.updateReviewContentStar(content,star,reviewId);
    }

    @Override
    public boolean deleteReview(String reviewId) {
        ReviewEntity checkExisted = reviewRepository.findById(reviewId).orElse(null);
        if(checkExisted == null) {
            return false;
        }else {
//            reviewRepository.deleteReview(reviewId);
            return true;
        }
    }


}
