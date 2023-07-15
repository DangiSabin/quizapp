create database questiondb;

use questiondb;

select * from question;

select * from quiz_questions;

select count(*) from question;

DROP TABLE question;

select * from hibernate_sequence;  


ALTER TABLE hibernate_sequence AUTO_INCREMENT = 11;


INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES
    ('Question 1', 'Option 1.1', 'Option 1.2', 'Option 1.3', 'Option 1.4', 'Option 1.1', 'Easy', 'Category 1'),
    ('Question 2', 'Option 2.1', 'Option 2.2', 'Option 2.3', 'Option 2.4', 'Option 2.3', 'Medium', 'Category 2'),
    ('Question 3', 'Option 3.1', 'Option 3.2', 'Option 3.3', 'Option 3.4', 'Option 3.4', 'Hard', 'Category 1'),
    ('Question 4', 'Option 4.1', 'Option 4.2', 'Option 4.3', 'Option 4.4', 'Option 4.4', 'Hard', 'Category 1'),
    ('Question 5', 'Option 5.1', 'Option 5.2', 'Option 5.3', 'Option 5.4', 'Option 5.3', 'Easy', 'Category 3'),
    ('Question 6', 'Option 6.1', 'Option 6.2', 'Option 6.3', 'Option 6.4', 'Option 6.1', 'Medium', 'Category 2'),
    ('Question 7', 'Option 7.1', 'Option 7.2', 'Option 7.3', 'Option 7.4', 'Option 7.2', 'Easy', 'Category 2'),
    ('Question 8', 'Option 8.1', 'Option 8.2', 'Option 8.3', 'Option 8.4', 'Option 8.3', 'Easy', 'Category 1'),
    ('Question 9', 'Option 9.1', 'Option 9.2', 'Option 9.3', 'Option 9.4', 'Option 9.1', 'Medium', 'Category 3'),
    ('Question 10', 'Option 10.1', 'Option 10.2', 'Option 10.3', 'Option 10.4', 'Option 10.2', 'Hard', 'Category 3');


select * from quiz;

select * from quiz_questions;




select id,right_answer from question
where id in(9,5,2);
