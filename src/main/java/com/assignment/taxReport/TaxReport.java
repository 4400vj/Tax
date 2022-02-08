package com.assignment.taxReport;

import com.assignment.constraints.TaxType;

import java.text.MessageFormat;

public class TaxReport
{
    private String customerID;
    private String invoiceNumber;
    private String timeStamp;
    private double amount;
    private double TotalAmount;
    private TaxType taxType;
    private double tax;
    private boolean error = false;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        TotalAmount = totalAmount;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * This method prints the tax report message
     * @return Tax Report message
     */
    public String printTaxReport(){
        String taxReportMessage;

        if (this.error){
            taxReportMessage = "Unable to find records for the given Tax type and the customer id";
        }else {
            taxReportMessage  = MessageFormat.format("For tax {0}, customer {1} has declared ${2}", this.taxType, this.customerID, this.tax);
        }

        System.out.println(taxReportMessage);
        return taxReportMessage;
    }
}
