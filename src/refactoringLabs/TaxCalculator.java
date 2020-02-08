package refactoringLabs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {

	// social taxes
	public static double t_pension = 0; // 9,76% of the income
	public static double t_disabled = 0; // 1,5% of the income
	public static double s_illness = 0; // 2,45% of the income

	private final static double PENSION = 0.0976;
	private final static double DISABLED = 0.015;
	private final static double ILLNESS = 0.02456;


	// health taxes
	public static double incomeCost = 111.25;
	public static double t_health1 = 0; // 9% of the incomeCost
	public static double t_health2 = 0; // 7,75 % of the incomeCost
	public static double advanceTax = 0; // income tax (18%) advance
	public static double exemptedValue = 46.33; // reduced value 46,33 PLN
	public static double advanceTaxOffice = 0;
	public static double advanceTaxOffice0 = 0;

	private static final double INCOME_COST = 111.25;
	private static final double HEALTH1 = 0.09;
	private static final double HEALTH2 = 0.0775;
	private static final double ADVANCE_TAX = 0.18;
	private static final double EXEMPTED_VALUE = 46.33;

	private final static DecimalFormat df00 = new DecimalFormat("#.00");
	private final static DecimalFormat df = new DecimalFormat("#");


	public static void main(String[] args) {

		ContractType contractType = null;
		double income = 0.0;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.print("Provide income: ");
			income = Double.parseDouble(br.readLine());

			System.out.print("Contract type: (O)rdinary, (C)ivil: ");
			contractType = ContractType.fromChar(br.readLine().charAt(0));

		} catch (Exception ex) {
			System.out.println("Incorrect value");
			System.err.println(ex);
			return;
		}
		switch(contractType){
			case ORDINARY:
			{
				double cBasis = calculatedBasis(income);
				calculateInsurance(cBasis);
				double taxBasis = cBasis - incomeCost;
				double taxBasis0 = Double.parseDouble(df.format(taxBasis));
				double basis = calculateBasis(taxBasis0);
				double exemtedTax = advanceTax - exemptedValue;
				double advance = calculateAdvance();
				advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
				double salary = income - ((t_pension + t_disabled + s_illness) + t_health1 + advanceTaxOffice0);

				System.out.println(
						"Ordinary contract" +
								"basis for taxes " + income +
								"Pension tax basis " + df00.format(t_pension) +
								"Disability tax basis " + df00.format(t_disabled) +
								"Illness insurance basis " + df00.format(s_illness) +
								"Health insurance basis: " + cBasis +
								"Health insutance: 9% = " + df00.format(t_health1) + " 7,75% = " + df00.format(t_health2) +
								"Constant income tax cost " + incomeCost +
								"Tax basis " + taxBasis + " rounded " + df.format(taxBasis0) +
								"Advance for income tax 18 % = " + advanceTax +
								"Exempted value = " + exemptedValue +
								"Exempted tax = " + df00.format(exemtedTax) +
								"Advance for the tax office = " + df00.format(advanceTaxOffice) + " rounded = " + df.format(advanceTaxOffice0) +
								"\n" +
								"Net salary = " + df00.format(salary)
						);
				break;
			}
			case CIVIL: {
				double oBasis = calculatedBasis(income);
				calculateInsurance(oBasis);
				exemptedValue = 0;
				incomeCost = oBasis * 0.2;
				double basisTax = oBasis - incomeCost;
				double basisTax0 = Double.parseDouble(df.format(basisTax));
				double basis = calculateBasis(basisTax0);
				double taxTaken = advanceTax;
				double advance = calculateAdvance();
				advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
				double salary = income - ((t_pension + t_disabled + s_illness) + t_health1 + advanceTaxOffice0);

				System.out.println(
						"Basis for taxes " + income +
								"Pension tax " + df00.format(t_pension) +
								"Disability tax " + df00.format(t_disabled) +
								"Illness insurance tax " + df00.format(s_illness) +
								"Basis for the health tax: " + oBasis +
								"Health tax: 9% = " + df00.format(t_health1) + " 7,75% = " + df00.format(t_health2) +
								"Income tax cost (constant) " + incomeCost +
								"Basis tax " + basisTax + " rounded " + df.format(basisTax0) +
								"Advance for income tax 18 % = " + advanceTax +
								"Tax taken = " + df00.format(taxTaken) +
								"Advance for tax office = " + df00.format(advanceTaxOffice) + " rounded = " + df.format(advanceTaxOffice0) +
								"\n" +
								"Net salary = " + df00.format(salary)
						);
				break;
			}
			default: {
				System.out.println("Unknown contract!");
				break;
			}
		}
	}

	public static double calculateAdvance() {
		return ADVANCE_TAX - HEALTH2 - EXEMPTED_VALUE;
	}

	public static double calculateBasis(double basis) {
		return basis * ADVANCE_TAX;
	}

	public static double calculatedBasis(double basis) {
		return basis * (1 - PENSION - DISABLED - ILLNESS);
	}

	public static void calculateInsurance(double basis) {
		t_health1 = (basis * 9) / 100;
		t_health2 = (basis * 7.75) / 100;
	}
}
