package com.example.android.wiquiz;

import java.util.List;

/**
 * Created by raghu on 24/3/16.
 */
public class Response {

    /**
     * CategoryName : GK
     * CategoryId : 1
     * Question : [{"QuestionId":"1001","Problem":"Entomology is the science that studies","AnswerArray":["Behavior of human beings","Insects","The origin and history of technical and scientific terms","The formation of rocks"],"CorrectAnswer":"Insects"},{"QuestionId":"1002","Problem":"Garampani sanctuary is located at ?","AnswerArray":["Junagarh, Gujarat","Diphu, Assam","Kohima, Nagaland","Gangtok, Sikkim"],"CorrectAnswer":"Diphu, Assam"},{"QuestionId":"1003","Problem":"For which of the following disciplines is Nobel Prize awarded?","AnswerArray":["Physics and Chemistry","Physiology or Medicine","Literature, Peace and Economics","All of the above"],"CorrectAnswer":"All of the above"},{"QuestionId":"1004","Problem":"Who was the first Indian Chief of Army Staff of the Indian Army ?","AnswerArray":["Gen. K.M. Cariappa","Vice-Admiral R.D. Katari","Gen. Maharaja Rajendra Singhji","None of the above"],"CorrectAnswer":"Gen. K.M. Cariappa"},{"QuestionId":"1005","Problem":"For the Olympics and World Tournaments, the dimensions of basketball court are","AnswerArray":["26 m x 14 m","28 m x 15 m","27 m x 16 m","28 m x 16 m"],"CorrectAnswer":"28 m x 15 m"},{"QuestionId":"1006","Problem":"GNLF stands for","AnswerArray":["Gorkha National Liberation Front","Gross National Liberation Form","Both option A and B","None of the above"],"CorrectAnswer":"Gorkha National Liberation Front"}]
     */

    private List<CategoriesArray> CategoriesArray;

    public List<CategoriesArray> getCategoriesArray() {
        return CategoriesArray;
    }

    public void setCategoriesArray(List<CategoriesArray> CategoriesArray) {
        this.CategoriesArray = CategoriesArray;
    }

    public static class CategoriesArray {
        private String CategoryName;
        private String CategoryId;
        /**
         * QuestionId : 1001
         * Problem : Entomology is the science that studies
         * AnswerArray : ["Behavior of human beings","Insects","The origin and history of technical and scientific terms","The formation of rocks"]
         * CorrectAnswer : Insects
         */

        private List<Question> Question;

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public String getCategoryId() {
            return CategoryId;
        }

        public void setCategoryId(String CategoryId) {
            this.CategoryId = CategoryId;
        }

        public List<Question> getQuestion() {
            return Question;
        }

        public void setQuestion(List<Question> Question) {
            this.Question = Question;
        }

        public static class Question {
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
