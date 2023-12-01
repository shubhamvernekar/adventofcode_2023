import java.util.*;
import java.io.*;

public class Day1 {
    static String numWords[] = {
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
    };

    public static int getNumberFromWord(String str, int i) {
        for(int j = 0; j < numWords.length; j++) {
            int len = numWords[j].length(); 
            if(i + len <= str.length() && numWords[j].compareTo(str.substring(i, i+len)) == 0) {
                return j+1;
            }
        }
        return -1;
    }
    
    public static int task1(String str) {
       int i = 0, j = str.length()-1;
       int result = 0;
       str.toLowerCase();

       while(i < str.length()) {
        char ch = str.charAt(i);
        if(Character.isDigit(ch)) {
            result += Character.getNumericValue(ch);
            break;
        }
        i++;
       }

       while (j >= 0) {
        char ch = str.charAt(j);
        if(Character.isDigit(ch)) {
            result = (result * 10) + Character.getNumericValue(ch);
            break;
        }
        j--;
       }
       if(result < 10) System.out.println(result + " " + str);
       return result;
    }

    public static int task2(String str) {
        int i = 0, j = str.length()-1;
        int result = 0;
        str.toLowerCase();
 
        while(i < str.length()) {
         char ch = str.charAt(i);
         if(Character.isDigit(ch)) {
             result += Character.getNumericValue(ch);
             break;
         }
         int tmpN = getNumberFromWord(str, i);
         if(tmpN != -1) {
             i += numWords[tmpN-1].length()-1;
             result += tmpN;
             break;
         }
         i++;
        }
 
        while (j >= 0) {
         char ch = str.charAt(j);
         if(Character.isDigit(ch)) {
             result = (result * 10) + Character.getNumericValue(ch);
             break;
         }
         int tmpN = getNumberFromWord(str, j);
         if(tmpN != -1) {
             result = (result * 10) + tmpN;
             break;
         }
         j--;
        }
        if(result < 10) System.out.println(result + " " + str);
        return result;
     }

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Please provide file path.");
            return;
        }

        String filePath = args[0];
        long task1result = 0;
        long task2result = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                task1result += task1(line);
                task2result += task2(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Task 1 Result = " + task1result);
        System.out.println("Task 2 Result = " + task2result);
    }
}