package com.evive.Service;

import com.evive.Model.Task;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrimeNumberServiceImpl implements PrimeNumberService{

  private List<Task> tasks=new ArrayList<> (  );


  public List<Integer> getAllPrimeNumber(int n){
    // Compute factorials and apply Wilson's
    // theorem.
    List<Integer> primeList=new ArrayList<> (  );
    int fact = 1;
    for(int k=2;k<=n;k++){
      fact = fact * (k - 1);
      if ((fact + 1) % k == 0)
        primeList.add ( k );
    }

    log.info ( "prime List{}:",primeList );
    return primeList;
  }

  public void addCronExpression(int primeNumber,String expression) {
    log.info ( "Added in Task List" );
    tasks.add ( new Task ( primeNumber,expression ) );

  }

  public List<Task> getTasks() {
    return tasks;
  }
}
