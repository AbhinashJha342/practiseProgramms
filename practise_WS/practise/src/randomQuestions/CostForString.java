package randomQuestions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CostForString {

    /*
     * Complete the buildString function below.
     */
    static int buildString(int a, int b, String s) {
         int count =0;
         StringBuilder strngBldr = new StringBuilder();
         String tempStrngBldr = "";
         int temp = b/a; 
         for(int i=0;i<s.length();i++){
               if(i==0 || i==1){
                   count+=a;
                   tempStrngBldr+=s.charAt(i);
               } else if(!tempStrngBldr.contains(strngBldr.append(s.charAt(i)))){
                   if(strngBldr.length()<=2) {
                	   if(tempStrngBldr.indexOf(strngBldr.charAt(strngBldr.length()-1))==-1){
                		   count+=a*strngBldr.length();
                		   tempStrngBldr+=strngBldr;
                		   strngBldr.delete(0, strngBldr.length());
                	   } else {
                		   count+=a;
                		   tempStrngBldr+=strngBldr.charAt(0);
                		   strngBldr.delete(0, strngBldr.length()-1);
                	   }
                   }
                   else {
                	   if(tempStrngBldr.contains(strngBldr.substring(1, strngBldr.length()))){
                		   count+=a;
                		   tempStrngBldr+=strngBldr.charAt(0);
                		   strngBldr.deleteCharAt(0);
                	   }else {
                		   if(strngBldr.length()-1<temp) {
                    		   count+=a*(strngBldr.length()-1);
                    	   } else {
                    		   count+=b;
                    	   }
                    	   tempStrngBldr+=strngBldr.substring(0, strngBldr.length()-1);
                    	   if(tempStrngBldr.indexOf(strngBldr.charAt(strngBldr.length()-1))==-1){
                    		   count+=a;
                    		   tempStrngBldr+=strngBldr.charAt(strngBldr.length()-1);
                    		   strngBldr.delete(0, strngBldr.length());
                    	   }else {
                    		   strngBldr.delete(0, strngBldr.length()-1);
                    	   }
                	   }
                   }
               }
         }
         
        	 if(strngBldr.length()==1){
        		 count+=a;
        	 } else if(strngBldr.length()>1){
        		 if(strngBldr.length()-1<temp) {
          		   count+=a*strngBldr.length();
          	   } else {
          		   count+=b;
          	   }
        	 }
           return count;
    }

    public static void main(String[] args) throws IOException {
    	int result = buildString(8987, 8990, "cbcbdbcapcdbcbehbsdkbcapccapcdcbedgscdgscdmhbsdkapccapcdapbcbdbcapcnhcdapbcbdbaedgscdgsclbaedgscdgaegcbdbaedtpbcbdbaedpcaedgscdgaehhmbeoaedtpbcdnbhhmbeocdapblbdbcbcbdbcimhbsdkapccdojbcascdgaehccdnbhhkcdgaqmbhhmbeocdkadiccipridrapcdcbedlblbdbcbcbddojbcascdgbmmhhkcdgaqmbhmbiepccapcdiinrmdcbedlrmcntbfd");
    	//int result = buildString(1, 3, "acbbqbbqbb");
        System.out.println(result);
        Map<Object, Object> newMap = new HashMap<Object, Object>();
        newMap.put("1", "value1");
        newMap.put("2", "value2");
        newMap.put("3", "value3");
        System.out.println(newMap.keySet().contains("1"));
        System.out.println("  MY NAME IS".replaceAll(" ", ""));
        System.out.println(Integer.valueOf("0031"));
    }
}