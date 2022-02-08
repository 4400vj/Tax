package com.taxGeneratorTest;

import com.assignment.constraints.TaxType;
import com.assignment.taxGenerator.TaxCalculation;
import com.assignment.taxReport.TaxReport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaxCalculationTest {

    private TaxCalculation taxCalculation;
    private TaxReport taxReport;

    @Before
    public void setUp() {
        taxCalculation = new TaxCalculation();
    }

    @Test
    public void ValidateTax() {
        taxReport = taxCalculation.getCustomerTax(TaxType.GST,"123","resources/Book1.csv");
        Assert.assertEquals("Tax calculation is not correct",7.911, taxReport.getTax(),0.0000001);

    }

    @Test
    public void ValidateTotalAmount() {
        taxReport = taxCalculation.getCustomerTax(TaxType.PAYROLL,"123","resources/Book1.csv");
        Assert.assertEquals("Tax calculation is not correct",8.01,taxReport.getTax(), 0.0000001);
    }
}
