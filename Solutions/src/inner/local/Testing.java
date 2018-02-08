package inner.local;

interface LocalWR {
	void access();
}

public class Testing {

	private static final int intPrimitivConstStatic = 10; 
	private static final Integer intWrapperConstStatic = 20;
	private static int intPrimitivStatic = 4; 
	private static Integer intWrapperStatic = 5;
	private final int intPrimitivConst = 30; 
	private final Integer intWrapperConst = 40;
	private int intPrimitiv = 8; 
	private Integer intWrapper = 9;
	
	
	
	static void testStaticAccess() {

		final int intLocalPrimitivConst = 80; 
		final Integer intLocalWrapperConst = 90;
		int intLocalPrimitiv = 58; 
		Integer intLocalWrapper = 59;

		class LocalClass implements LocalWR {
			@Override
			public void access() {
				intPrimitivStatic = 14; 
				intWrapperStatic = 15;
				//intPrimitiv = 18;       // error
				//intWrapper = 19;        // error
				//intLocalPrimitiv = 68;  // error
				//intLocalWrapper = 69;   // error
			}
			@Override
			public String toString() {
				StringBuffer buffer = new StringBuffer(512); 
				buffer.append(String.format("\tTesting an access from non static function:%n"));
				buffer.append(String.format("\tintPrimitivConstStatic = %2d%n", intPrimitivConstStatic)); 
				buffer.append(String.format("\tintWrapperConstStatic  = %2d%n", intWrapperConstStatic));
				buffer.append(String.format("\tintPrimitivStatic      = %2d%n", intPrimitivStatic));
				buffer.append(String.format("\tintWrapperStatic       = %2d%n", intWrapperStatic));
				buffer.append(String.format("\tintPrimitivConst       = non accessible%n"));
				buffer.append(String.format("\tintWrapperConst        = non accessible%n"));
				buffer.append(String.format("\tintPrimitiv            = non accessible%n"));
				buffer.append(String.format("\tintWrapper             = non accessible%n"));

				buffer.append(String.format("\tintLocalPrimitivConst  = %2d%n", intLocalPrimitivConst));
				buffer.append(String.format("\tintLocalWrapperConst   = %2d%n", intLocalWrapperConst));
				buffer.append(String.format("\tintLocalPrimitiv       = %2d%n", intLocalPrimitiv));
				buffer.append(String.format("\tintLocalWrapper        = %2d%n", intLocalWrapper));
				return buffer.toString();
			}		
		}
		LocalClass lc = new LocalClass();
		lc.access();
		System.out.println(lc.toString());
	}

	void testMemberAccess() {
		final int intLocalPrimitivConst = 80; 
		final Integer intLocalWrapperConst = 90;
		int intLocalPrimitiv = 58; 
		Integer intLocalWrapper = 59;

		class LocalClass implements LocalWR {
			@Override
			public void access() {
				intPrimitivStatic = 24; 
				intWrapperStatic = 25;
				intPrimitiv = 28; 
				intWrapper = 29;
				//intLocalPrimitiv = 68;  // error
				//intLocalWrapper = 69;   // error
			}
			@Override
			public String toString() {
				StringBuffer buffer = new StringBuffer(512); 
				buffer.append(String.format("\tTesting an access from non static function:%n"));
				buffer.append(String.format("\tintPrimitivConstStatic = %2d%n", intPrimitivConstStatic)); 
				buffer.append(String.format("\tintWrapperConstStatic  = %2d%n", intWrapperConstStatic));
				buffer.append(String.format("\tintPrimitivStatic      = %2d%n", intPrimitivStatic));
				buffer.append(String.format("\tintWrapperStatic       = %2d%n", intWrapperStatic));
				buffer.append(String.format("\tintPrimitivConst       = %2d%n", intPrimitivConst));
				buffer.append(String.format("\tintWrapperConst        = %2d%n", intWrapperConst));
				buffer.append(String.format("\tintPrimitiv            = %2d%n", intPrimitiv));
				buffer.append(String.format("\tintWrapper             = %2d%n", intWrapper));

				buffer.append(String.format("\tintLocalPrimitivConst  = %2d%n", intLocalPrimitivConst));
				buffer.append(String.format("\tintLocalWrapperConst   = %2d%n", intLocalWrapperConst));
				buffer.append(String.format("\tintLocalPrimitiv       = %2d%n", intLocalPrimitiv));
				buffer.append(String.format("\tintLocalWrapper        = %2d%n", intLocalWrapper));
				return buffer.toString();
			}		
		}
		LocalClass lc = new LocalClass();
		lc.access();
		System.out.println(lc.toString());
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(512); 
		buffer.append(String.format("Current state:%n"));
		buffer.append(String.format("\tintPrimitivConstStatic = %2d%n", intPrimitivConstStatic)); 
		buffer.append(String.format("\tintWrapperConstStatic  = %2d%n", intWrapperConstStatic));
		buffer.append(String.format("\tintPrimitivStatic      = %2d%n", intPrimitivStatic));
		buffer.append(String.format("\tintWrapperStatic       = %2d%n", intWrapperStatic));
		buffer.append(String.format("\tintPrimitivConst       = %2d%n", intPrimitivConst));
		buffer.append(String.format("\tintWrapperConst        = %2d%n", intWrapperConst));
		buffer.append(String.format("\tintPrimitiv            = %2d%n", intPrimitiv));
		buffer.append(String.format("\tintWrapper             = %2d%n", intWrapper));
		return buffer.toString();
	}
	
	
	public static void main(String[] args) {
		testStaticAccess();
		new Testing().testMemberAccess();
	}
}
