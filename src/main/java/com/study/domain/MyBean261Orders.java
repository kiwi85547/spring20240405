package com.study.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MyBean261Orders {
    private Integer orderId;
    private Integer customerId;
    private Integer employeeId;
    private String OrderDate;
    private Integer shipperId;
}
