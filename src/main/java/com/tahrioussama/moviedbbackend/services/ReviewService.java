package com.tahrioussama.moviedbbackend.services;

import com.tahrioussama.moviedbbackend.entities.Review;

public interface ReviewService {
    Review createReview(String reviewBody, String imdbId);
}
