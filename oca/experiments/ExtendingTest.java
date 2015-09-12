import java.io.IOException;
import java.sql.SQLException;

interface A {
	public void test() throws IOException;
}

interface B {
	public void test() throws SQLException;
}

interface C  extends A, B{
	public void test();
}

class D implements C {
	public void test() {}
}
