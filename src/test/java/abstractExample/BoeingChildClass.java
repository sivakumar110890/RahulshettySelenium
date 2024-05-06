package abstractExample;

public class BoeingChildClass extends ParentClass {

	public static void main(String[] args) {
		BoeingChildClass b = new BoeingChildClass();
		b.Engine();
		b.Cruzing();
		b.color();
	}

	@Override
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("This method basically implemented it on child class");
	}

}
