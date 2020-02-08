package refactoringLabs;

public class ContractFactory {
    public static Contract getContract(ContractType type, double income){
        if(type.equals(ContractType.CIVIL)) return new CivilContract(income);
        else if(type.equals(ContractType.ORDINARY)) return new OrdinaryContract(income);
        return null;
    }
}
