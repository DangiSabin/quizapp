package com.dangisabin.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dangisabin.quizapp.dao.QuestionDao;
import com.dangisabin.quizapp.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		
		try{
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		
		try{
		return new ResponseEntity<>( questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteQuestion(Integer id) {
		questionDao.deleteById(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}

	public ResponseEntity<String> updateQuestion(Question newQuestion) {
		//questionDao.save(question);
		Question oldQuestion=questionDao.findByQuestionTitle(newQuestion.getQuestionTitle()).get(0);
		if (oldQuestion == null) {
			return new ResponseEntity<>("Question not found",HttpStatus.BAD_REQUEST);
        }
		else{
			  // Update  existing question
			oldQuestion.setCategory(newQuestion.getCategory());
			oldQuestion.setDifficultyLevel(newQuestion.getDifficultyLevel());
			oldQuestion.setOption1(newQuestion.getOption1());
			oldQuestion.setOption2(newQuestion.getOption2());
			oldQuestion.setOption3(newQuestion.getOption3());
			oldQuestion.setOption4(newQuestion.getOption4());
			oldQuestion.setQuestionTitle(newQuestion.getQuestionTitle());
			oldQuestion.setRightAnswer(newQuestion.getRightAnswer());
			
			//
			questionDao.save(oldQuestion);
			
			
		}
		return new ResponseEntity<>("Updated",HttpStatus.OK);
	}

}
