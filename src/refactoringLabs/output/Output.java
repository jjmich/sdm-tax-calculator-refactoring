package refactoringLabs.output;

import refactoringLabs.contract.Contract;

import java.text.DecimalFormat;

public class Output {

    private static final DecimalFormat DF_00 = new DecimalFormat("#.00");
    private static final DecimalFormat DF = new DecimalFormat("#");

    public static void printSummary(Contract contract) {
        System.out.println("Contract type: " + contract.getContractType() + "\n" +
                "Basis for taxes " + contract.getIncome() + "\n" +
                "Pension tax " + DF_00.format(contract.getPensionTax()) + "\n" +
                "Disability tax " + DF_00.format(contract.getDisabilityTax()) + "\n" +
                "Illness insurance tax " + DF_00.format(contract.getIllnessInsuranceTax()) + "\n" +
                "Health insurance basis: " + contract.getHealthInsuranceBasis() + "\n" +
                "Health insurance: 9% = " + DF_00.format(contract.getHealthInsurance1()) + " 7.75% = " + DF_00.format(contract.getHealthInsurance2()) + "\n" +
                "Constant income tax cost " + contract.getIncomeCost() + "\n" +
                "Tax basis " + contract.getTaxBasis() + " rounded " + DF.format(contract.getTaxBasis()) + "\n" +
                "Advance for income tax 18 % = " + contract.getAdvanceTax() + "\n" +
                "Tax taken = " + DF_00.format(contract.getAdvanceTax()) + "\n" +
                "Exempted value = " + Contract.EXEMPTED_VALUE + "\n" +
                "Exempted tax = " + DF_00.format(contract.getExemptedTax()) + "\n" +
                "Advance for the tax office = " + DF_00.format(contract.getAdvanceTaxOffice()) + " rounded = " + DF.format(contract.getAdvanceTaxOffice()) + "\n" +
                "\n" +
                "Net salary = " + DF_00.format(contract.getSalary()));
    }
}
