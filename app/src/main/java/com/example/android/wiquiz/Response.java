package com.example.android.wiquiz;

import java.util.List;

/**
 * Created by raghu on 24/3/16.
 */
public class Response {

    /**
     * category : GK
     * question : [{"problem":"Who is PM ?","answerArray":["ManMohan Ji","Sonia","Rahul","Modi"],"correctAnswer":"Modi"},{"problem":"Who is Prez ?","answerArray":["Manas Ji","Shub","mridul","shubmoy"],"correctAnswer":"Shubmoy"}]
     */

    private List<CategoriesArray> categoriesArray;

    public List<CategoriesArray> getCategoriesArray() {
        return categoriesArray;
    }

    public void setCategoriesArray(List<CategoriesArray> categoriesArray) {
        this.categoriesArray = categoriesArray;
    }

    public static class CategoriesArray {
        private String category;
        /**
         * problem : Who is PM ?
         * answerArray : ["ManMohan Ji","Sonia","Rahul","Modi"]
         * correctAnswer : Modi
         */

        private List<Question> question;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<Question> getQuestion() {
            return question;
        }

        public void setQuestion(List<Question> question) {
            this.question = question;
        }

        public static class Question {
            private String problem;
            private String correctAnswer;
            private List<String> answerArray;

            public String getProblem() {
                return problem;
            }

            public void setProblem(String problem) {
                this.problem = problem;
            }

            public String getCorrectAnswer() {
                return correctAnswer;
            }

            public void setCorrectAnswer(String correctAnswer) {
                this.correctAnswer = correctAnswer;
            }

            public List<String> getAnswerArray() {
                return answerArray;
            }

            public void setAnswerArray(List<String> answerArray) {
                this.answerArray = answerArray;
            }
        }
    }
}
