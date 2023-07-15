package com.dangisabin.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dangisabin.quizapp.model.Question;
import com.dangisabin.quizapp.service.QuestionService;

@RestController
@RequestMapping("question") //this is http://localhost:9090/question
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions") // this will be http://localhost:9090/question/allQuestions
	public ResponseEntity<List<Question>> getAllQuestions(){
		
		return questionService.getAllQuestions();
	}
	
	//this is http://localhost:9090/question/category/{category}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question){
		return questionService.addQuestion(question);
		
	}
	
	//delete : http://localhost:9090/question/delete/{id}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
		return questionService.deleteQuestion(id);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateQuestion(@RequestBody Question question){
		return questionService.updateQuestion(question);
		
	}
	
}
