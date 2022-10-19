*Welcome to the Horror Movie Review Application!*

Use the following instructions to navigate through 
the reviews in rest client.

***********************************
To view a review by its ID request:

GET  http://localhost:8080/review/{review id}

***********************************
To view reviews by CATEGORY request:

GET http://localhost:8080/categories

***********************************
To ADD REVIEW enter the following request and fill
quotations with corresponding information:

POST http://localhost:8080/reviews
Content-Type: application/json

{
"title": "Enter Title Here",
"author": "Enter Author Here",
"description": "Enter Review Description Here",
"rating":"Enter Rating Here",
"category": "Enter Subgenre Here"
}

***********************************
To ASSIGN HASHTAG to review request:

PUT http://localhost:8080/hashtags/{hashTagid}/addToReview/{id}

***********************************
To CREATE A HASHTAG enter the following request and fill in 
the quotation with the hashtag you would like to create:

POST http://localhost:8080/hashtags
Content-Type: application/json

{
"contentTag": "Enter Hashtag Here"
}

***********************************
To VIEW ALL REVIEWS BY HASHTAG enter the following request:

GET http://localhost:8080/hashtag/{hashTagId/reviews