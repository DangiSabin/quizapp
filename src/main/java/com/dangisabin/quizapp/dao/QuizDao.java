package com.dangisabin.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dangisabin.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{
	
  

}
