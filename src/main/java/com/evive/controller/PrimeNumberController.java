package com.evive.controller;

import com.evive.Service.PrimeNumberService;
import com.evive.util.AttributeNames;
import com.evive.util.ViewNames;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class PrimeNumberController {

    private PrimeNumberService primeNumberService;

    @Autowired
    public PrimeNumberController(PrimeNumberService primeNumberService) {
      this.primeNumberService = primeNumberService;
    }

  @RequestMapping(method = RequestMethod.POST, value = ViewNames.PRIME)
    public String primeGenerator(@RequestParam(value = "primeNumber", required = true)Integer primeNumber,Model model){

      // Sending Input-Number and All the PrimeNUmber In List to Prime View
      log.info ( "Prime Number{}",primeNumber );
      String primeNumberString="The Prime Number within in range of "+primeNumber +" are : ";
      List<Integer> integerList=primeNumberService.getAllPrimeNumber ( primeNumber );
      model.addAttribute ( AttributeNames.PRIME_NO,primeNumberString );
      model.addAttribute ( AttributeNames.PRIME_LIST,integerList );
      log.info ( "List:{}",integerList );

      return ViewNames.PRIME;
    }


  @RequestMapping(method = RequestMethod.GET, value = ViewNames.SCHEDULING)
  public String addSchedulingTask(){
      return ViewNames.SCHEDULING;
  }

  @RequestMapping(method = RequestMethod.POST, value = ViewNames.SCHEDULING)
  public String getSchedulingTask(@RequestParam(value = "primeNumber")Integer primeNumber,@RequestParam(value = "cronExpression")String ex){

    // Redirect to Home after adding Task in List through Service
    log.info ( "primeNumber : {}",primeNumber );
    log.info ( "expression : {}",ex );
    primeNumberService.addCronExpression ( primeNumber,ex );
    return ViewNames.HOME;
  }

}
