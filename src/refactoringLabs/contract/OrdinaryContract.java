package refactoringLabs.contract;

public class OrdinaryContract extends Contract {


    OrdinaryContract(double income) {
        super(income);
    }

    @Override
    public Contract createSummary() {
        contractType = "Ordinary";
        pensionTax = calculatePension(income);
        disabilityTax = calculateDisabled(income);
        illnessInsuranceTax = calculateIllness(income);
        healthInsuranceBasis = calculateHealthInsuranceBasis(income);
        healthInsurance1 = calculateHealthInsurance1(income);
        healthInsurance2 = calculateHealthInsurance2(income);
        taxBasis = healthInsuranceBasis - INCOME_COST;
        advanceTax = calculateAdvanceTax(income);
        exemptedTax = advanceTax - EXEMPTED_VALUE;
        advanceTaxOffice = calculateAdvanceTaxOffice(income, EXEMPTED_VALUE);
        salary = income
                - (pensionTax + disabilityTax + illnessInsuranceTax
                + healthInsurance1 + advanceTaxOffice);
        return this;
    }
}
