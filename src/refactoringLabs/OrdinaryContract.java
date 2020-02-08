package refactoringLabs;

public class OrdinaryContract extends Contract {


    public OrdinaryContract(double income) {
        super(income);
    }

    @Override
    protected String createSummary() {

        double healthInsuranceBasis = calculateHealthInsuranceBasis(income);
        double taxBasis = healthInsuranceBasis - INCOME_COST;
        double taxBasis0 = Double.parseDouble(df.format(taxBasis));
        double advanceTax = calculateAdvanceTax(income);
        double exemptedTax = advanceTax - EXEMPTED_VALUE;
        double advanceTaxOffice = calculateAdvanceTaxOffice(income, EXEMPTED_VALUE);
        double advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
        double salary = income
                            - ((calculatePension(income) + calculateDisabled(income)
                                + calculateIllness(income))
                                + calculateHealthInsurance1(income)
                                + advanceTaxOffice0);

        return "Ordinary contract" + "\n" +
               "basis for taxes " + income + "\n" +
               "Pension tax basis " + df00.format(calculatePension(income)) + "\n" +
               "Disability tax basis " + df00.format(calculateDisabled(income)) + "\n" +
               "Illness insurance basis " + df00.format(calculateIllness(income)) + "\n" +
               "Health insurance basis: " + healthInsuranceBasis + "\n" +
               "Health insutance: 9% = " + df00.format(calculateHealthInsurance1(income)) + " 7,75% = " + df00.format(calculateHealthInsurance2(income)) + "\n" +
               "Constant income tax cost " + INCOME_COST + "\n" +
               "Tax basis " + taxBasis + " rounded " + df.format(taxBasis0) + "\n" +
               "Advance for income tax 18 % = " + advanceTax + "\n" +
               "Exempted value = " + EXEMPTED_VALUE + "\n" +
               "Exempted tax = " + df00.format(exemptedTax) + "\n" +
               "Advance for the tax office = " + df00.format(advanceTaxOffice) + " rounded = " + df.format(advanceTaxOffice0) + "\n" +
               "\n" +
               "Net salary = " + df00.format(salary);
    }
}
