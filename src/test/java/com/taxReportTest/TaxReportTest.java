package com.taxReportTest;

import com.assignment.constraints.TaxType;
import com.assignment.taxGenerator.TaxCalculation;
import com.assignment.taxReport.TaxReport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaxReportTest {

    private TaxCalculation taxCalculation;
    private TaxReport taxReport;

    @Before
    public void setUp() throws Exception {
        taxCalculation = new TaxCalculation();
    }

    @Test
    public void ValidateTaxReportMessage() {
        taxReport = taxCalculation.getCustomerTax(TaxType.GST,"123","resources/Book1.csv");
        Assert.assertEquals("TaxReport Message not correct","For tax GST, customer 123 has declared $7.911",taxReport.printTaxReport());
    }

    @Test
    public void ValidateTaxReportMessageWithPayRoll() {
        taxReport = taxCalculation.getCustomerTax(TaxType.PAYROLL,"223","resources/Book1.csv");
        Assert.assertEquals("TaxReport Message not correct","For tax PAYROLL, customer 223 has declared $1",taxReport.printTaxReport());
    }

    @Test
    public void ValidateTaxReportMessageWithInvalidInput() {
        taxReport = taxCalculation.getCustomerTax(TaxType.valueOf("GST"),"123856","resources/Book1.csv");
        Assert.assertEquals("TaxReport Message not correct","Unable to find records for the given Tax type and the customer id",taxReport.printTaxReport());
    }
}
