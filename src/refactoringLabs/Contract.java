package refactoringLabs;

public abstract class Contract {

    private static final double PENSION = 0.0976;
    private static final double DISABLED = 0.015;
    private static final double ILLNESS = 0.02456;
    private static final double HEALTH1 = 0.09;
    private static final double HEALTH2 = 0.0775;
    private static final double ADVANCE_TAX = 0.18;

    static final double INCOME_COST = 111.25;
    static final double EXEMPTED_VALUE = 46.33;

    String contractType;
    double pensionTax;
    double disabilityTax;
    double illnessInsuranceTax;
    double healthInsuranceBasis;
    double healthInsurance1;
    double healthInsurance2;
    double incomeCost;
    double taxBasis;
    double advanceTax;
    double exemptedTax;
    double advanceTaxOffice;
    double salary;
    double income;

    Contract(double income){
        this.income = income;
    }

    protected abstract Contract createSummary();

    double calculateAdvanceTax(double basis){
        return basis * ADVANCE_TAX;
    }

    double calculateHealthInsurance1(double basis){
        return basis * HEALTH1;
    }

    double calculateHealthInsurance2(double basis){
        return basis * HEALTH2;
    }

    double calculatePension(double basis){
        return basis * PENSION;
    }

    double calculateDisabled(double basis){
        return basis * DISABLED;
    }

    double calculateIllness(double basis){
        return  basis * ILLNESS;
    }

    double calculateHealthInsuranceBasis(double basis){
        return basis - calculatePension(basis) - calculateDisabled(basis) - calculateIllness(basis);
    }

    double calculateAdvanceTaxOffice(double basis, double exemptedValue){
        return calculateAdvanceTax(basis) - calculateHealthInsurance2(basis) - exemptedValue;
    }
}
