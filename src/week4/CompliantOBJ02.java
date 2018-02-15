package week4;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

class Compliant2MethodInvoker {	
	public void invokeMethod() {
		AccessController.doPrivileged(new PrivilegedAction<Object>() {
			public Object run() {
				try {
					Class<?> thisClass = Compliant2MethodInvoker.class;
					String methodName = (new Compliant2MethodInvoker()).getMethodName(); //make sure it uses this class not its subclass
					System.out.println("method name is: " + methodName);
					Method method = thisClass.getMethod(methodName, null);
					method.invoke(new Compliant2MethodInvoker(), null);
				} catch (Throwable t) {
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
		System.out.println("some method is executing");
	}
	
	public void someOtherMethod() {
		System.out.println("some other method is executing");
	}
}

public class CompliantOBJ02 extends Compliant2MethodInvoker {
	public static void main (String[] args) throws Exception {
		CompliantOBJ02 t = new CompliantOBJ02();
		t.invokeMethod();
	}
	
	String getMethodName() {
		return "someOtherMethod";
	}
}