package refactoringLabs;

import java.text.DecimalFormat;

class Output {

    private static final DecimalFormat df00 = new DecimalFormat("#.00");
    private static final DecimalFormat df = new DecimalFormat("#");

    static void printSummary(Contract contract) {
        System.out.println("Contract type: " + contract.contractType + "\n" +
                "Basis for taxes " + contract.income + "\n" +
                "Pension tax " + df00.format(contract.pensionTax) + "\n" +
                "Disability tax " + df00.format(contract.disabilityTax) + "\n" +
                "Illness insurance tax " + df00.format(contract.illnessInsuranceTax) + "\n" +
                "Health insurance basis: " + contract.healthInsuranceBasis + "\n" +
                "Health insurance: 9% = " + df00.format(contract.healthInsurance1) + " 7,75% = " + df00.format(contract.healthInsurance2) + "\n" +
                "Constant income tax cost " + contract.incomeCost + "\n" +
                "Tax basis " + contract.taxBasis + " rounded " + df.format(contract.taxBasis) + "\n" +
                "Advance for income tax 18 % = " + contract.advanceTax + "\n" +
                "Tax taken = " + df00.format(contract.advanceTax) + "\n" +
                "Exempted value = " + Contract.EXEMPTED_VALUE + "\n" +
                "Exempted tax = " + df00.format(contract.exemptedTax) + "\n" +
                "Advance for the tax office = " + df00.format(contract.advanceTaxOffice) + " rounded = " + df.format(contract.advanceTaxOffice) + "\n" +
                "\n" +
                "Net salary = " + df00.format(contract.salary));
    }
}
