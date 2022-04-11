package arithmetic;

public class FiniteGroupOfOrderTwo implements Group<PlusOrMinusOne>{

	@Override
	public PlusOrMinusOne binaryOperation(PlusOrMinusOne one, PlusOrMinusOne other) {
				
		return one.multi(other);			
	}

	@Override
	public PlusOrMinusOne identity() {
		
		return PlusOrMinusOne.PLUSONE;
	}

	@Override
	public PlusOrMinusOne inverseOf(PlusOrMinusOne t) {
			
		return t.inverse();
	}
	
}
