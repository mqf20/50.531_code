package week4;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

class CompliantMethodInvoker {	
	public void invokeMethod() {
		AccessController.doPrivileged(new PrivilegedAction<Object>() {
			public Object run() {
				try {
					Class<?> thisClass = CompliantMethodInvoker.class;
					String methodName = getMethodName();
					Method method = thisClass.getMethod(methodName, null);
					method.invoke(new CompliantMethodInvoker(), null); //
				} catch (Throwable t) {
					// Forward to handler
				}
				return null;
			}
		});
	}
	
	final String getMethodName() { //add final here so that it can't be overrridden 
		return "someMethod";
	}

	public void someMethod() {
		System.out.println("some method is executing");
	}
	
	public void someOtherMethod() {
		System.out.println("some other method is executing");
	}}

public class CompliantOBJ00 extends CompliantMethodInvoker {
	public static void main (String[] args) throws Exception {
		CompliantOBJ00 t = new CompliantOBJ00();
		t.invokeMethod();
	}
}