package rest_spring_boot_with_java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_spring_boot_with_java.service.MathOperations;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathOperations mathOperations;

    public MathController(MathOperations mathOperations) {
        this.mathOperations = mathOperations;
    }


    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum (@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo){
        return mathOperations.sum(numberOne, numberTwo);
    }

    // subtraction

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction (@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo){
        return mathOperations.subtraction(numberOne, numberTwo);
    }


    // multiplication

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication (@PathVariable("numberOne") String numberOne,
                               @PathVariable("numberTwo") String numberTwo){
        return mathOperations.multiplication(numberOne, numberTwo);
    }

    // division

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division (@PathVariable("numberOne") String numberOne,
                               @PathVariable("numberTwo") String numberTwo){
       return mathOperations.division(numberOne, numberTwo);
    }

}
