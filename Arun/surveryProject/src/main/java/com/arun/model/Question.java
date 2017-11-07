package com.arun.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

//Create the category table by labeling it as @Entity and giving a name for it
@Entity
@Table(name = "question")
public class Question {

//	Define the column names for each of the variable by using @Column(name = "")
	@Column(name = "id")
	private int id;
	@Column(name = "question_name")
	private String Question_name;
	@Column(name = "parent_id")
	private int parent_id;
	@Enumerated(EnumType.STRING)
	@Column(name = "question_type")
	private QuestionType Question_type;
	
	
//	Get the category reference
	private Category category;
	
//	Get all the answers from Answer class
	private List<Question_Choice> answers;

//	Generate the required constructors
	public Question() {

	}

	public Question(String Question_name, QuestionType Question_type) {
		this.Question_name = Question_name;
		this.Question_type = Question_type;
	}

	public Question(String Question_name, QuestionType Question_type, Category category) {
		this.Question_name = Question_name;
		this.Question_type = Question_type;
		this.category = category;
	}

//	Generate the getters and setters
//	Assign the primary Key by using @Id annotation and auto generate the value
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion_name() {
		return Question_name;
	}

	public void setQuestion_name(String question_name) {
		Question_name = question_name;
	}

	public QuestionType getQuestion_type() {
		return Question_type;
	}

	public void setQuestion_type(QuestionType question_type) {
		Question_type = question_type;
	}
	
	
public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	//	Establish many to one relationship by @ManyToOne annotation and mention the
//	foreign key by @JoinColumn annotation
	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	Establish One to many relationship with Answer by @OneToMany annotation and 
//	mention the mapped by reference
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	public List<Question_Choice> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Question_Choice> answers) {
		this.answers = answers;
	}
	

}
