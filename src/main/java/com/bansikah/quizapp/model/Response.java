package com.bansikah.quizapp.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {
    private Integer id;
    private String responses;

    public boolean isError() {
        return id == null;
    }
}
