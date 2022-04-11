package arithmetic;

public enum PlusOrMinusOne {
	
	PLUSONE(1), MINUSONE(-1);
	
	int number;
	
	PlusOrMinusOne(int number){
		this.number = number;
	}
	
	
	public PlusOrMinusOne multi(PlusOrMinusOne y){
		
		int temp = this.number * y.number;
		
		switch(temp) {
			case 1: return PLUSONE;
			case -1: return MINUSONE;
			default: return null;
		}
		
	}


	public PlusOrMinusOne inverse() {
		
		switch(this.number) {
			case 1: return MINUSONE;
			case -1: return PLUSONE;
			default: return null;
		}
	}
	
	@Override
	public String toString() {
		switch(this.number) {
			case 1: return "1";
			case -1: return "-1";
			default: return null;
		}
	}
	
	

}
