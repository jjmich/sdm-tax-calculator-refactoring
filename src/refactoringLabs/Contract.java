package refactoringLabs;

import java.text.DecimalFormat;

public abstract class Contract {

    protected final static double PENSION = 0.0976;
    protected final static double DISABLED = 0.015;
    protected final static double ILLNESS = 0.02456;

    protected static final double INCOME_COST = 111.25;
    protected static final double HEALTH1 = 0.09;
    protected static final double HEALTH2 = 0.0775;
    protected static final double ADVANCE_TAX = 0.18;
    protected static final double EXEMPTED_VALUE = 46.33;

    protected static final DecimalFormat df00 = new DecimalFormat("#.00");
    protected static final DecimalFormat df = new DecimalFormat("#");

    protected double income;

    public Contract(double income){
        this.income = income;
    }

    protected abstract String createSummary();

    protected double calculateAdvanceTax(double basis){
        return basis * ADVANCE_TAX;
    }

    protected double calculateHealthInsurance1(double basis){
        return basis * HEALTH1;
    }

    protected double calculateHealthInsurance2(double basis){
        return basis * HEALTH2;
    }

    protected double calculatePension(double basis){
        return basis * PENSION;
    }

    protected double calculateDisabled(double basis){
        return basis * DISABLED;
    }

    protected double calculateIllness(double basis){
        return  basis * ILLNESS;
    }

    protected double calculateHealthInsuranceBasis(double basis){
        return basis - calculatePension(basis) - calculateDisabled(basis) - calculateIllness(basis);
    }

    protected double calculateAdvanceTaxOffice(double basis, double exemptedValue){
        return calculateAdvanceTax(basis) - calculateHealthInsurance2(basis) - exemptedValue;
    }

}
