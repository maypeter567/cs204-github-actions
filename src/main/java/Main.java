import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while(true){
            Scanner scanner = new Scanner(System.in);
            int a = -1, b = -1, temp = 0, loops = 0;
            Integer result = null;
            
            System.out.print("Enter an argument: ");
            String input = scanner.nextLine();
            StringBuilder tempString = new StringBuilder();
            String argument = "";
            
            for(int i = 0; i < input.length(); i++){
                if (input.charAt(i) == ' ' || i == input.length() - 1){
                    for (int j = temp; j <= i; j++){
                        if (input.charAt(j) != ' ') {
                            tempString.append(input.charAt(j));
                        }
                    }
                    temp = i + 1;
                    if (loops == 0){
                        argument = tempString.toString();
                    } else if (loops == 1){
                        a = Integer.parseInt(tempString.toString());
                    } else if (loops == 2){
                        b = Integer.parseInt(tempString.toString());
                    }
                    loops++;
                    tempString = new StringBuilder();
                }
            }
            
            if (argument.equals("add")) {
                result = calculator.add(a, b);
            } else if (argument.equals("subtract")) {
                result = calculator.subtract(a, b);
            } else if (argument.equals("multiply")) {
                result = calculator.multiply(a, b);
            } else if (argument.equals("divide")) {
                result = calculator.divide(a, b);
            } else if (argument.equals("fibonacci")) {
                result = calculator.fibonacciNumberFinder(a);
            } else if (argument.equals("binary")) {
                String result2 = calculator.intToBinaryNumber(a);
                System.out.println(result2);
            } else if (argument.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
            if (result != null) {
                System.out.println(result);
            }
        }
    }
}
