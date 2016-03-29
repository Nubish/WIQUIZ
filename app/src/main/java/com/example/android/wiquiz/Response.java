package com.example.android.wiquiz;

import java.util.List;

/**
 * Created by raghu on 24/3/16.
 */
public class Response {

    /**
     * CategoryName : GK
     * Question : [{"QuestionId":"001","Problem":"Who is PM ?","AnswerArray":["ManMohan Ji","Sonia","Rahul","Modi"],"CorrectAnswer":"Modi"},{"QuestionId":"002","Problem":"Who is Prez ?","AnswerArray":["Manas Ji","Shub","mridul","shubmoy"],"CorrectAnswer":"Shubmoy"}]
     */

    private List<CategoriesArrayBean> CategoriesArray;

    public List<CategoriesArrayBean> getCategoriesArray() {
        return CategoriesArray;
    }

    public void setCategoriesArray(List<CategoriesArrayBean> CategoriesArray) {
        this.CategoriesArray = CategoriesArray;
    }

    public static class CategoriesArrayBean {
        private String CategoryName;
        /**
         * QuestionId : 001
         * Problem : Who is PM ?
         * AnswerArray : ["ManMohan Ji","Sonia","Rahul","Modi"]
         * CorrectAnswer : Modi
         */

        private List<QuestionBean> Question;

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public List<QuestionBean> getQuestion() {
            return Question;
        }

        public void setQuestion(List<QuestionBean> Question) {
            this.Question = Question;
        }

        public static class QuestionBean {
            private String QuestionId;
            private String Problem;
            private String CorrectAnswer;
            private List<String> AnswerArray;

            public String getQuestionId() {
                return QuestionId;
            }

            public void setQuestionId(String QuestionId) {
                this.QuestionId = QuestionId;
            }

            public String getProblem() {
                return Problem;
            }

            public void setProblem(String Problem) {
                this.Problem = Problem;
            }

            public String getCorrectAnswer() {
                return CorrectAnswer;
            }

            public void setCorrectAnswer(String CorrectAnswer) {
                this.CorrectAnswer = CorrectAnswer;
            }

            public List<String> getAnswerArray() {
                return AnswerArray;
            }

            public void setAnswerArray(List<String> AnswerArray) {
                this.AnswerArray = AnswerArray;
            }
        }
    }
}
