package refactoringLabs;

public class CivilContract extends Contract {

    CivilContract(double income) {
        super(income);
    }

    @Override
    protected Contract createSummary() {
        contractType = "Civil";
        pensionTax = calculatePension(income);
        disabilityTax = calculateDisabled(income);
        illnessInsuranceTax = calculateIllness(income);
        healthInsuranceBasis = calculateHealthInsuranceBasis(income);
        healthInsurance1 = calculateHealthInsurance1(income);
        healthInsurance2 = calculateHealthInsurance2(income);
        incomeCost = INCOME_COST * 0.2;
        taxBasis = healthInsuranceBasis - incomeCost;
        advanceTax = calculateAdvanceTax(income);
        advanceTaxOffice = calculateAdvanceTaxOffice(income, 0);
        salary = income
                - (pensionTax + disabilityTax + illnessInsuranceTax
                + healthInsurance1 + advanceTaxOffice);
        return this;
    }
}
