enum MyEnum {
	A, B {
		public MyNestedEnum getType() {
			return MyNestedEnum.Type2;
		}
	}, C;
	
	private enum MyNestedEnum {
		Type1, Type2;
	}
	
	public MyNestedEnum getType() {
		return MyNestedEnum.Type1;
	}
}

public class ConstantSpecificClassBody {
	
	public static void main(String[] args) {
		System.out.println(MyEnum.A.getType());
		
		//System.out.println(MyEnum.MyNestedEnum.Type1);
		
		for (MyEnum me : MyEnum.values()) {
			System.out.println(me + " " + me.getType());
		}
	}
}
