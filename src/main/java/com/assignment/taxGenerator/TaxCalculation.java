package com.assignment.taxGenerator;

import com.assignment.constraints.TaxType;
import com.assignment.taxReport.TaxReport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TaxCalculation {

    /**
     * This method returns the TaxReport object
     * @param taxType
     * @param customerID
     * @param path
     * @return : TaxReport Object
     */
    public TaxReport getCustomerTax(TaxType taxType, String customerID, String path){
        String line = "";
        double totalAmount = 0;

        TaxReport taxReport = new TaxReport();

        taxReport.setCustomerID(customerID);
        taxReport.setTaxType(taxType);

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null){
                String[] csvLine = line.split(",");
                if((csvLine[0].equals(customerID)) && (csvLine[4].equals(taxType.toString()))) {
                    totalAmount= totalAmount + Double.parseDouble(csvLine[3]);
                }

                if (totalAmount == 0){
                    taxReport.setError(true);
                }else {
                    taxReport.setError(false);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Unable to read the source file");
        }

        taxReport.setTotalAmount(totalAmount);
        taxReport.setTax(this.calculateTax(totalAmount, 10.00));
        return taxReport;
    }

    /**
     * This method calculate and returns the amount
     * @param totalAmount
     * @param percentage
     * @return Tax Amount
     */
    private double calculateTax(double totalAmount, double percentage) {
        return  (totalAmount * percentage) /100;
    }
}
