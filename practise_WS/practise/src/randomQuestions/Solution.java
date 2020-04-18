package randomQuestions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the buildString function below.
     */
    static int buildString(int a, int b, String s) {
         int count =0;
         StringBuilder strngBldr = new StringBuilder();
         String tempStrngBldr = "";
         for(int i=0;i<s.length();i++){
               if(i==0 || i==1){
                   count+=a;
                   tempStrngBldr+=s.charAt(i);
               } else if(!tempStrngBldr.contains(strngBldr.append(s.charAt(i)))){
                   if(strngBldr.length()<=2) {
                       count+=a*strngBldr.length();
                       tempStrngBldr+=strngBldr;
                       strngBldr.delete(0, strngBldr.length());
                   } else if(strngBldr.length()>tempStrngBldr.length()) {
                       count+=b;
                       tempStrngBldr+=strngBldr.substring(0, strngBldr.length()-1);
                       if(tempStrngBldr.indexOf(strngBldr.charAt(strngBldr.length()-1))==-1){
                           count+=a;
                       }else {
                           strngBldr.delete(0, strngBldr.length()-1);
                       }
                   } else {
                       count+=a+b;
                       tempStrngBldr+=strngBldr;
                       strngBldr.delete(0, strngBldr.length());
                   }
               }
         }
         
             if(strngBldr.length()==1){
                 count+=a;
             } else {
                 count+=b;
             }
           return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nab = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nab[0].trim());

            int a = Integer.parseInt(nab[1].trim());

            int b = Integer.parseInt(nab[2].trim());

            String s = scanner.nextLine();

            int result = buildString(a, b, s);
        }

        bufferedWriter.close();
    }
}
