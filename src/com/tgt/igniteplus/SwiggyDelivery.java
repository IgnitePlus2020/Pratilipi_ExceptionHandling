/*Develop a method that accepts a zip code and validates against non-deliverable zip
codes.
• Example – zip codes 123, 456, 789 are non-deliverable.
• If the customer resides at a non-deliverable zip code, throw a custom exception.
• Handle the exception and display an appropriate message to the customer.
• If the customer resides at a deliverable zip code, display a message “Delivery available
in your area! “.
• Invoke this method
 */

package com.tgt.igniteplus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwiggyDelivery {
    static int zipcode;
    static List<Integer> codeList = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the zip code:\t");
        zipcode = in.nextInt();
        codeList.add(123);
        codeList.add(456);
        codeList.add(789);
        try {
            validate(zipcode);
        } catch (Exception e) {
            System.out.println("Delivery UNAVAILABLE in your area!");
        }
    }

    static void validate(int zipcode) throws NonDeliverableException {
        int flag = 0;
        for (int i = 0; i < codeList.size(); i++) {
            if (codeList.get(i) != zipcode)
                flag = 1;
            else
                throw new NonDeliverableException("Not Valid");
        }
        if (flag == 1)
            System.out.println("Delivery available in your area!");
    }
}

class NonDeliverableException extends Exception {
    NonDeliverableException(String s) {
        super(s);
    }
}
/*
Output 1:
Enter the zip code:	345
Delivery available in your area!

Output 2:
Enter the zip code:	123
Delivery UNAVAILABLE in your area!
 */