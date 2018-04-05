package com.practice.java.enumpack;

public enum ArithmaticOperator implements Operator{
	
	PLUS("add"){
		@Override
		public int apply(int a, int b) {
			return a+b;
		}
	},MINUS("sub"){
		@Override
		public int apply(int a, int b) {
			return a-b;
		}
	},DIVIDE("div"){
		@Override
		public int apply(int a, int b) {
			return a/b;
		}
	},MULTYPLY("multy"){
		@Override
		public int apply(int a, int b) {
			return a*b;
		}
	},NONE("none");
	
	private String opertaorCode;
	
	ArithmaticOperator(String code){
		this.opertaorCode = code;
	}
	
	public static ArithmaticOperator fromOperatorCode(String code){
		for(ArithmaticOperator operator: ArithmaticOperator.values()){
			if(operator.opertaorCode == code)
				return operator;
		}
		return ArithmaticOperator.NONE;
	}

	@Override
	public int apply(int a, int b) {
		return 0;
	}

}
