package com.assignment.taxGenerator;


import com.assignment.constraints.TaxType;
import com.assignment.taxReport.TaxReport;

public class TaxGenerator {
    public static void main(String[] args) {
        TaxReport taxReport;
        TaxCalculation taxCalculation = new TaxCalculation();

        // takes input arguments from the command line and generates the tax report
        //eg: java -jar assignment-1.0.jar "PAYROLL" "223" "/Users/vjselva/Desktop/1/resources/Book1.csv"
        try {
            taxReport = taxCalculation.getCustomerTax(TaxType.valueOf(args[0]), args[1], args[2]);
            taxReport.printTaxReport();
        } catch (IllegalArgumentException e){
            System.out.println("Invalid Tax Type");
        }


    }
}
