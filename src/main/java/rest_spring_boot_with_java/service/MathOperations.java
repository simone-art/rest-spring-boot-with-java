package rest_spring_boot_with_java.service;

import org.springframework.stereotype.Service;
import rest_spring_boot_with_java.exception.ResourceNotFoundException;

@Service
public class MathOperations {


    public Double sum ( String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new ResourceNotFoundException("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble((numberTwo));
    }

    // subtraction

    public Double subtraction (String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new ResourceNotFoundException("Please set a numeric value");
        return convertToDouble(numberOne) - convertToDouble((numberTwo));
    }

    // multiplication
    public Double multiplication (String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new ResourceNotFoundException("Please set a numeric value");
        return convertToDouble(numberOne) * convertToDouble((numberTwo));
    }

    // division
    public Double division (String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new ResourceNotFoundException("Please set a numeric value");
        return convertToDouble(numberOne) / convertToDouble((numberTwo));
    }


    private Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty()) throw new ResourceNotFoundException("Please set a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber){
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("-?\\d+(\\.\\d+)?");
    }
}
