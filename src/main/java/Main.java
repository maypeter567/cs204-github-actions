import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Main {
    static void usage() {
        System.out.println("Usage: <+, -, *, /> <number 1> <number 2>");
        System.out.println("or, Usage: <fibonacci, binary> <number 1>");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        usage();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] arguments = input.split(" ");
            
            Calculator calculator = new Calculator();
            
            if (arguments.length != 3 && arguments.length != 2) {
                System.out.println("Invalid input");
                usage();
            }
            
            String operator = arguments[0];
            int number1 = Integer.parseInt(arguments[1]);
            int number2;
            Integer outputInt = null;
            String outputString = null;
            
            if (arguments.length == 3) {
                number2 = Integer.parseInt(arguments[2]);
                
                switch (operator) {
                    case "add":
                    case "+": {
                        outputInt = calculator.add(number1, number2);
                        break;
                    }
                    case "subtract":
                    case "-": {
                        outputInt = calculator.subtract(number1, number2);
                        break;
                    }
                    case "multiply":
                    case "*": {
                        outputInt = calculator.multiply(number1, number2);
                        break;
                    }
                    case "divide":
                    case "/": {
                        outputInt = calculator.divide(number1, number2);
                        break;
                    }
                    default:
                        System.out.println("Invalid operator");
                        break;
                }
            } else if (arguments.length == 2) {
                switch (operator) {
                    case "fibonacci": {
                        outputInt = calculator.fibonacciNumberFinder(number1);
                        break;
                    }
                    case "binary": {
                        outputString = calculator.intToBinaryNumber(number1);
                        break;
                    }
                }
            }
            
            if (outputInt != null) {
                System.out.println(outputInt);
            } else {
                System.out.println(outputString);
            }
        }
    }
}