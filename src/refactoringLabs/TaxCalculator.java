package refactoringLabs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {

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

		Contract contract = ContractFactory.getContract(contractType, income);

		if (contract != null){
			System.out.println(contract.createSummary());
		}

//		switch(contractType){
//			case ORDINARY:
//			{
//				double cBasis = calculatedBasis(income);
//				calculateInsurance(cBasis);
//				double taxBasis = cBasis - incomeCost;
//				double taxBasis0 = Double.parseDouble(df.format(taxBasis));
//				double basis = calculateBasis(taxBasis0);
//				double exemtedTax = advanceTax - exemptedValue;
//				double advance = calculateAdvance();
//				advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
//				double salary = income - ((pension + disabled + illness) + health1 + advanceTaxOffice0);
//
//				System.out.println(
//						"Ordinary contract" +
//								"basis for taxes " + income +
//								"Pension tax basis " + df00.format(pension) +
//								"Disability tax basis " + df00.format(disabled) +
//								"Illness insurance basis " + df00.format(illness) +
//								"Health insurance basis: " + cBasis +
//								"Health insutance: 9% = " + df00.format(health1) + " 7,75% = " + df00.format(health2) +
//								"Constant income tax cost " + incomeCost +
//								"Tax basis " + taxBasis + " rounded " + df.format(taxBasis0) +
//								"Advance for income tax 18 % = " + advanceTax +
//								"Exempted value = " + exemptedValue +
//								"Exempted tax = " + df00.format(exemtedTax) +
//								"Advance for the tax office = " + df00.format(advanceTaxOffice) + " rounded = " + df.format(advanceTaxOffice0) +
//								"\n" +
//								"Net salary = " + df00.format(salary)
//						);
//				break;
//			}
//			case CIVIL: {
//				double oBasis = calculatedBasis(income);
//				calculateInsurance(oBasis);
//				exemptedValue = 0;
//				incomeCost = oBasis * 0.2;
//				double basisTax = oBasis - incomeCost;
//				double basisTax0 = Double.parseDouble(df.format(basisTax));
//				double basis = calculateBasis(basisTax0);
//				double taxTaken = advanceTax;
//				double advance = calculateAdvance();
//				advanceTaxOffice0 = Double.parseDouble(df.format(advanceTaxOffice));
//				double salary = income - ((pension + disabled + illness) + health1 + advanceTaxOffice0);
//
//				System.out.println(
//						"Basis for taxes " + income +
//								"Pension tax " + df00.format(pension) +
//								"Disability tax " + df00.format(disabled) +
//								"Illness insurance tax " + df00.format(illness) +
//								"Basis for the health tax: " + oBasis +
//								"Health tax: 9% = " + df00.format(health1) + " 7,75% = " + df00.format(health2) +
//								"Income tax cost (constant) " + incomeCost +
//								"Basis tax " + basisTax + " rounded " + df.format(basisTax0) +
//								"Advance for income tax 18 % = " + advanceTax +
//								"Tax taken = " + df00.format(taxTaken) +
//								"Advance for tax office = " + df00.format(advanceTaxOffice) + " rounded = " + df.format(advanceTaxOffice0) +
//								"\n" +
//								"Net salary = " + df00.format(salary)
//						);
//				break;
//			}
//			default: {
//				System.out.println("Unknown contract!");
//				break;
//			}
//		}
	}

//	public static double calculateAdvance() {
//		return ADVANCE_TAX - health2 - EXEMPTED_VALUE;
//	}
//
//	public static double calculateBasis(double basis) {
//		return basis * ADVANCE_TAX;
//	}
//
//	public static double calculatedBasis(double basis) {
//		return basis * (1 - PENSION - DISABLED - ILLNESS);
//	}
//
//	public static void calculateInsurance(double basis) {
//		health1 = (basis * 9) / 100;
//		health2 = (basis * 7.75) / 100;
//	}
}
