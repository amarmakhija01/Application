package com.evive.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
USED FOR STORING TASK
* */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    int primeNumber;
    String cronExpression;
}
