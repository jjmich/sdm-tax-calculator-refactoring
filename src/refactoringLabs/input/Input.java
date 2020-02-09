package refactoringLabs.input;

import refactoringLabs.contract.ContractType;

import java.util.Scanner;

public class Input {
    private final double income;
    private final ContractType contractType;

    private Input(double income, ContractType contractType) {
        this.income = income;
        this.contractType = contractType;
    }

    public static Input getInput() throws Exception {
        Scanner inScanner = new Scanner(System.in);
        System.out.print("Provide income: ");
        double income = inScanner.nextDouble();
        System.out.print("Contract type: (O)rdinary, (C)ivil: ");
        ContractType contractType = ContractType.fromChar(inScanner.next().charAt(0));
        return new Input(income, contractType);
    }

    public double getIncome() {
        return income;
    }

    public ContractType getContractType() {
        return contractType;
    }
}
