package refactoringLabs;

public class CivilContract extends Contract {

    public CivilContract(double income) {
        super(income);
    }

    @Override
    protected String createSummary() {
        double healthInsuranceBasis = calculateHealthInsuranceBasis(income);
        double incomeCost = INCOME_COST * 0.2;
        double taxBasis = healthInsuranceBasis - incomeCost;
        double taxBasis0 = Double.parseDouble(df.format(taxBasis));
        double advanceTax = calculateAdvanceTax(income);
        double advanceTaxOffice = calculateAdvanceTaxOffice(income, 0);
        double advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
        double salary = income
                - ((calculatePension(income) + calculateDisabled(income)
                + calculateIllness(income))
                + calculateHealthInsurance1(income)
                + advanceTaxOffice0);

        return "Civil contract\n" +
               "basis for taxes " + income + "\n" +
               "Pension tax " + df00.format(calculatePension(income)) + "\n" +
               "Disability tax " + df00.format(calculateDisabled(income)) + "\n" +
               "Illness insurance tax " + df00.format(calculateIllness(income)) + "\n" +
               "Health insurance basis: " + healthInsuranceBasis + "\n" +
               "Health insurance: 9% = " + df00.format(calculateHealthInsurance1(income)) + " 7,75% = " + df00.format(calculateHealthInsurance2(income)) + "\n" +
               "Constant income tax cost " + incomeCost + "\n" +
               "Tax basis " + taxBasis + " rounded " + df.format(taxBasis0) + "\n" +
               "Advance for income tax 18 % = " + advanceTax + "\n" +
               "Tax taken = " + df00.format(advanceTax) + "\n" +
               "Advance for the tax office = " + df00.format(advanceTaxOffice) + " rounded = " + df.format(advanceTaxOffice0) + "\n" +
               "\n" +
               "Net salary = " + df00.format(salary);
    }
}
