package com.evive.Service;

import com.evive.Model.Task;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public interface PrimeNumberService {

     List<Integer> getAllPrimeNumber(int n);
     void addCronExpression(int primeNumber,String expression);
      List<Task> getTasks();
}
