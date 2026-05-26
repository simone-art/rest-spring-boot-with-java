package rest_spring_boot_with_java.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import rest_spring_boot_with_java.exception.UnsupportedMathOperationException;

@Service
public class MathOperations {


    public Double sum (@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble((numberTwo));
    }

    // subtraction

    public Double subtraction (@PathVariable("numberOne") String numberOne,
                               @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) - convertToDouble((numberTwo));
    }

    // multiplication
    public Double multiplication (@PathVariable("numberOne") String numberOne,
                                  @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) * convertToDouble((numberTwo));
    }

    // division
    public Double division (@PathVariable("numberOne") String numberOne,
                            @PathVariable("numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) / convertToDouble((numberTwo));
    }



    private Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber){
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("-?\\d+(\\.\\d+)?");
    }
}
