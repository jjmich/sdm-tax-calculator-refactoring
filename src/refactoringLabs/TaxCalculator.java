package refactoringLabs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaxCalculator {

    public static void main(String[] args) {

        ContractType contractType;
        double income;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Provide income: ");
            income = Double.parseDouble(br.readLine());

            System.out.print("Contract type: (O)rdinary, (C)ivil: ");
            contractType = ContractType.fromChar(br.readLine().charAt(0));

        } catch (Exception ex) {
            System.out.println("Incorrect value");
            ex.printStackTrace();
            return;
        }

        Contract contract = ContractFactory.getContract(contractType, income);

        if (contract != null) {
            Output.printSummary(contract.createSummary());
        }
    }
}
