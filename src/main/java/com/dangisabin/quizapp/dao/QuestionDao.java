package com.dangisabin.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dangisabin.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
	
	List<Question> findByCategory(String category);
	
	List<Question> findByQuestionTitle(String title);
	
	@Query(value="select * from question q where q.category=:category order by RAND() LIMIT :numQ",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
		
}
