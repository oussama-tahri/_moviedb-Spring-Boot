# Movie Database Web Application

This is a web application built using Spring Boot as the backend framework and MongoDB Atlas Compass as the database. The application focuses on managing movies and their reviews. It provides functionality to store movie details and associated reviews.

## Technology Stack
- Spring Boot:  A Java-based framework for building web applications.
- MongoDB Atlas Compass: A cloud-based database service for MongoDB.

## Movie Class
The `Movie` class represents a movie and contains the following attributes:

```java
@Document(collection = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviews;
}
```

## Review Class
The `Review` class represents a review for a movie and contains the following attributes:

```java
@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;
}
```

## MovieService
The `MovieService` class provides methods to interact with the movie data:

```java
@Override
public List<Movie> allMovies() {
    return movieRepository.findAll();
}

@Override
public Optional<Movie> findMovieByImdbId(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
}
```

## ReviewService
The `ReviewService` class provides methods to manage movie reviews:

```java
public Review createReview(String reviewBody, String imdbId) {
    Review review = reviewRepository.insert(new Review(reviewBody));

    mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviews").value(review))
            .first();

    return review;
}
```

## Getting Started

### Prerequisites
- Java Development Kit (JDK) installed
- MongoDB Atlas Compass account with database credentials
- IDE (e.g., IntelliJ IDEA, Eclipse) for running the application

### Setup
1. Clone the repository or download the source code.
2. Import the project into your preferred IDE.
3. Set up the MongoDB Atlas Compass connection properties in the application's configuration file (`application.properties` or `application.yml`) with the appropriate database credentials.
4. Build and run the application.

## Usage
- Access the application through the provided URL.
- Use the exposed API endpoints to interact with movie data and reviews.
- Perform CRUD operations on movies and reviews using the defined services.

## Contributing
This project is open for contributions. Feel free to submit bug reports, feature requests, or pull requests to help improve the application.

## License
This project is licensed under the [MIT License](LICENSE).
