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
    public Double sum (@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new IllegalArgumentException("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble((numberTwo));
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty()) throw new IllegalArgumentException("Please set a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber){
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("-?\\d+(\\.\\d+)?");
    }
}
