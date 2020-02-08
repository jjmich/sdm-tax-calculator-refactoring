package refactoringLabs;

public enum ContractType {
	ORDINARY, CIVIL;

	private ContractType(){}

	public static ContractType fromChar(char ch) throws Exception{
		switch(ch){
			case 'O':
				return ORDINARY;
			case 'C':
				return CIVIL;
			default:
				throw new Exception("Unrecognized contract type!");
		}
	}
}
