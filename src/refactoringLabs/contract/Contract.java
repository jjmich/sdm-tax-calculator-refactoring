package refactoringLabs.contract;

public abstract class Contract {

    public static final double INCOME_COST = 111.25;
    public static final double EXEMPTED_VALUE = 46.33;
    private static final double PENSION = 0.0976;
    private static final double DISABLED = 0.015;
    private static final double ILLNESS = 0.02456;
    private static final double HEALTH1 = 0.09;
    private static final double HEALTH2 = 0.0775;
    private static final double ADVANCE_TAX = 0.18;

    protected String contractType;
    protected double pensionTax;
    protected double disabilityTax;
    protected double illnessInsuranceTax;
    protected double healthInsuranceBasis;
    protected double healthInsurance1;
    protected double healthInsurance2;
    protected double incomeCost;
    protected double taxBasis;
    protected double advanceTax;
    protected double exemptedTax;
    protected double advanceTaxOffice;
    protected double salary;
    protected double income;

    protected Contract(double income) {
        this.income = income;
    }

    public abstract Contract createSummary();

    protected double calculateAdvanceTax(double basis) {
        return basis * ADVANCE_TAX;
    }

    protected double calculateHealthInsurance1(double basis) {
        return basis * HEALTH1;
    }

    protected double calculateHealthInsurance2(double basis) {
        return basis * HEALTH2;
    }

    protected double calculatePension(double basis) {
        return basis * PENSION;
    }

    protected double calculateDisabled(double basis) {
        return basis * DISABLED;
    }

    protected double calculateIllness(double basis) {
        return basis * ILLNESS;
    }

    protected double calculateHealthInsuranceBasis(double basis) {
        return basis - calculatePension(basis) - calculateDisabled(basis) - calculateIllness(basis);
    }

    protected double calculateAdvanceTaxOffice(double basis, double exemptedValue) {
        return calculateAdvanceTax(basis) - calculateHealthInsurance2(basis) - exemptedValue;
    }

    public String getContractType() {
        return contractType;
    }

    public double getPensionTax() {
        return pensionTax;
    }

    public double getDisabilityTax() {
        return disabilityTax;
    }

    public double getIllnessInsuranceTax() {
        return illnessInsuranceTax;
    }

    public double getHealthInsuranceBasis() {
        return healthInsuranceBasis;
    }

    public double getHealthInsurance1() {
        return healthInsurance1;
    }

    public double getHealthInsurance2() {
        return healthInsurance2;
    }

    public double getIncomeCost() {
        return incomeCost;
    }

    public double getTaxBasis() {
        return taxBasis;
    }

    public double getAdvanceTax() {
        return advanceTax;
    }

    public double getExemptedTax() {
        return exemptedTax;
    }

    public double getAdvanceTaxOffice() {
        return advanceTaxOffice;
    }

    public double getSalary() {
        return salary;
    }

    public double getIncome() {
        return income;
    }
}
