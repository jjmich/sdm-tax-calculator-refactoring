package refactoringLabs.contract;

import refactoringLabs.input.Input;

public class ContractFactory {
    public static Contract getContract(Input input) {
        if (input.getContractType().equals(ContractType.CIVIL)) return new CivilContract(input.getIncome());
        else if (input.getContractType().equals(ContractType.ORDINARY)) return new OrdinaryContract(input.getIncome());
        return null;
    }
}
