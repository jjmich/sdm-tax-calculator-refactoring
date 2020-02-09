package refactoringLabs;

import java.util.Optional;

public class TaxCalculator {

    public static void main(String[] args) {
        Input input;
        try {
            input = Input.getInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Optional.ofNullable(ContractFactory.getContract(input))
                .ifPresent(contract -> Output.printSummary(contract.createSummary()));
    }
}

