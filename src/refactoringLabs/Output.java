package refactoringLabs;

import java.text.DecimalFormat;

class Output {

    private static final DecimalFormat DF_00 = new DecimalFormat("#.00");
    private static final DecimalFormat DF = new DecimalFormat("#");

    static void printSummary(Contract contract) {
        System.out.println("Contract type: " + contract.contractType + "\n" +
                "Basis for taxes " + contract.income + "\n" +
                "Pension tax " + DF_00.format(contract.pensionTax) + "\n" +
                "Disability tax " + DF_00.format(contract.disabilityTax) + "\n" +
                "Illness insurance tax " + DF_00.format(contract.illnessInsuranceTax) + "\n" +
                "Health insurance basis: " + contract.healthInsuranceBasis + "\n" +
                "Health insurance: 9% = " + DF_00.format(contract.healthInsurance1) + " 7.75% = " + DF_00.format(contract.healthInsurance2) + "\n" +
                "Constant income tax cost " + contract.incomeCost + "\n" +
                "Tax basis " + contract.taxBasis + " rounded " + DF.format(contract.taxBasis) + "\n" +
                "Advance for income tax 18 % = " + contract.advanceTax + "\n" +
                "Tax taken = " + DF_00.format(contract.advanceTax) + "\n" +
                "Exempted value = " + Contract.EXEMPTED_VALUE + "\n" +
                "Exempted tax = " + DF_00.format(contract.exemptedTax) + "\n" +
                "Advance for the tax office = " + DF_00.format(contract.advanceTaxOffice) + " rounded = " + DF.format(contract.advanceTaxOffice) + "\n" +
                "\n" +
                "Net salary = " + DF_00.format(contract.salary));
    }
}
