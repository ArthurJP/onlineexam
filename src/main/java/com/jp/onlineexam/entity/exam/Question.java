package com.jp.onlineexam.entity.exam;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/21/2018
 */
@Data
@NoArgsConstructor
@Entity
public class Question implements Serializable {

    private static final long serialVersionUID = 5035567074694281122L;

    @Id
    @Generated
    private long id;

    private String question;

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String trueAnswer;

    public Question(long id, String question, String answerA, String answerB, String answerC, String answerD, String trueAnswer) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.trueAnswer = trueAnswer;
    }
}
