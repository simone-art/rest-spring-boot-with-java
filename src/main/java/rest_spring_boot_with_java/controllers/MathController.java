package rest_spring_boot_with_java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

//    public Double sum (Double var1, Double var2){
//        return var1 + var2;
//    }

//    @RequestMapping("/sum/{numberOne}/{numberTwo}")
//    public Double sum (@PathVariable("numberOne") String numberOne,
//                       @PathVariable("numberTwo") String numberTwo){
//        return 1D;
//    }



    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum (@PathVariable("numberOne") Double numberOne,
                       @PathVariable("numberTwo") Double numberTwo){
        return numberOne + numberTwo;
    }
}
