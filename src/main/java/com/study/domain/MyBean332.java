package com.study.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MyBean332 {
    private String stringCol; //varchar
    private Integer intCol; //INT
    private Double decCol;
    private LocalDate dateCol;
    private LocalDateTime dateTimeCol;
}
