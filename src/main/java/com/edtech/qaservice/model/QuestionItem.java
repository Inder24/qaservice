package com.edtech.qaservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Set;

@DynamoDBTable(tableName="QuestionService")
public class QuestionItem {
    private String id;
    private String author;
    private String questionTitle;
    private String createDate;
    private String questionText;
    private Set<String> questionTag;

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() { return id;}
    public void setId(String id) {this.id = id;}

    @DynamoDBAttribute(attributeName = "author")
    public String getAuthor() { return author;}
    public void setAuthor(String author) {this.author = author;}

    @DynamoDBAttribute(attributeName = "createDate")
    public String getCreateDate() { return createDate;}
    public void setCreateDate(String createDate) {this.createDate = createDate;}

    @DynamoDBAttribute(attributeName="questionTitle")
    public String getQuestionTitle() { return questionTitle;}
    public void setQuestionTitle(String questionTitle) {this.questionTitle = questionTitle;}

    @DynamoDBAttribute(attributeName = "questionText")
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    @DynamoDBAttribute(attributeName = "questionTag")
    public Set<String> getQuestionTag() { return questionTag; }
    public void setQuestionTag(Set<String> questionTag) { this.questionTag = questionTag; }

    @Override
    public String toString() {
        return "Question [id=" + id + ", questionTitle=" + questionTitle + ", createDate=" + createDate
                + ", questionText=" + questionText + ", author=" + author + ", questionTag=" + questionTag + "]";
    }
}
