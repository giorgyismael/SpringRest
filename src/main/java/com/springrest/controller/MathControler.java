package com.springrest.controller;

import org.springframework.web.bind.annotation.*;

import com.springrest.exception.ResourceNotFoundExceprion;

@RestController
public class MathControler {
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(isNotNumeric(numberOne)||isNotNumeric(numberTwo)){
            throw new ResourceNotFoundExceprion("Please set a number value!");
        }
        return 1D;
    }

    private boolean isNotNumeric(String number) {
        if (number == null) return Boolean.TRUE;
        String newNumber= number.replaceAll(",",".");
        return !newNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
