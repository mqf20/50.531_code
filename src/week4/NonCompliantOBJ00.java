package week4;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

class MethodInvoker {	
	public void invokeMethod() {
		AccessController.doPrivileged(new PrivilegedAction<Object>() {
			public Object run() {
				try {
					Class<?> thisClass = MethodInvoker.class;					
					String methodName = getMethodName();
					Method method = thisClass.getMethod(methodName, null);
					method.invoke(new MethodInvoker(), null);
				} catch (Throwable t) {
					System.out.println("some exception is thrown.");
					// Forward to handler
				}
				return null;
			}
		});
	}
	
	String getMethodName() {
		return "someMethod";
	}

	public void someMethod() {
		// do some non-malicious things
		System.out.println("some method is executing");
	}
	// Other methods
	
	public void someOtherMethod() {
		// do some non-malicious things
		System.out.println("some other method is executing");
	}
}

public class NonCompliantOBJ00 extends MethodInvoker {
	public static void main (String[] args) throws Exception {
		NonCompliantOBJ00 t = new NonCompliantOBJ00();
		t.invokeMethod();
	}
	
	String getMethodName() {
		return "someOtherMethod";
	}
		
	//...
}
