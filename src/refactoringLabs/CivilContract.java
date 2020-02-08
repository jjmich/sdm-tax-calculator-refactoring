package refactoringLabs;

public class CivilContract extends Contract {

    public CivilContract(double income) {
        super(income);
    }

    @Override
    protected String createSummary() {
        return null;
    }
}
