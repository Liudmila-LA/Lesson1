package Lesson2;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson1 {
    public static void main(String[] args) {
        Boolean aa;
        aa = true;
        Scanner scannerIncomingData = new Scanner(System.in);
        System.out.println("Введите строку и нажмите Enter, пожалуйста.");
        String incString = scannerIncomingData.nextLine();
        String result = getEncryptedString(incString);
        System.out.println(result);
    }

    public static String getEncryptedString(String inputString){
        String result = new String();
        String[] arrayDate = new String[3];
        int indexDelimiterString;
        String regexTelNumber= "\\d{11}";
        String regexEmail= "[a-zA-Z0-9]@[a-zA-Z0-9-.]+[.]";
        String regexFullName= "[А-Я][а-я]+\\s[А-Я][а-я]+\\s[А-Я][а-я]+";

        // Telephone
        Pattern pTelNumber = Pattern.compile(regexTelNumber);
        Matcher telNumber = pTelNumber.matcher(inputString);//.toString();
        if (telNumber.find()) {
           int start = telNumber.start();
           int end = telNumber.end();
           StringBuilder sbTelNumber = new StringBuilder(inputString.substring(start,end));
           inputString = telNumber.replaceFirst(sbTelNumber.replace(5, 7, "***").toString());
        }

       // E-mail
        Pattern pEmail = Pattern.compile(regexEmail);
        Matcher eMail = pEmail.matcher(inputString);
        if (eMail.find()) {
            int start = eMail.start();
            int end = eMail.end();
            StringBuilder sbEmail = new StringBuilder(inputString.substring(start, end));
            Pattern pSubstringEmail = Pattern.compile("[a-zA-Z0-9]");
            Matcher mSubstringEmail = pSubstringEmail.matcher(inputString.substring(start, end));
            mSubstringEmail.replaceAll("*");
            inputString = eMail.replaceFirst(mSubstringEmail.replaceAll("*"));
        }

        // Full name
        Pattern pFullName = Pattern.compile(regexFullName);
        Matcher fullName = pFullName.matcher(inputString);
        if (fullName.find()) {
            int start = fullName.start();
            int end = fullName.end();
            String sFullName = inputString.substring(start, end);
            String resultStringFullName = "";
            String[] arrayFullName = sFullName.split("\\s");

            String sFirstElementName;
            String sSecondElementName = arrayFullName[1];
            String sThirdElementName;

            // first element
            int lengthStingFullName = arrayFullName[0].length();
            Character cFirstCharName = arrayFullName[0].charAt(0);
            Character cLastCharName = arrayFullName[0].charAt(lengthStingFullName-1);
            sFirstElementName = cFirstCharName.toString();
            for (int i = 1; i<lengthStingFullName;i++){
                sFirstElementName = sFirstElementName+"*";
            }
            sFirstElementName = sFirstElementName + cLastCharName.toString();

            // third element
            Character cFirstCharFullName = arrayFullName[2].charAt(0);
            sThirdElementName = cFirstCharFullName.toString()+".";

            // result
            resultStringFullName = resultStringFullName.join(" ",sFirstElementName,sSecondElementName,sThirdElementName);
            inputString = fullName.replaceFirst(resultStringFullName);
        }
        return inputString;
        }

}
