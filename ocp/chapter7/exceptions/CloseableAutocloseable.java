import java.io.IOException;
import java.io.Closeable;
import java.sql.SQLException;

class A implements AutoCloseable {
	public void close() throws Exception {}
}

class B implements AutoCloseable {
	public void close() {}
}

class C implements AutoCloseable {
	public void close() throws IOException {}
}

//class D implements Closeable {
//	public void close() throws Exception {} // BLAD: Exception nie jest
//			podklasa IOException
//}

class E implements Closeable {
	public void close() {}
}

class F implements Closeable {
	public void close() throws IOException {}
}
