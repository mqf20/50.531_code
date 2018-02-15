package week4;

import java.util.HashMap;
import java.util.Map;

/**
 * Submission by FOO, Ming Qing (1003260, mingqing_foo@mymail.sutd.edu.sg),
 * 
 * The problem with the non-compliant code is: 
 * - The "final" modifier only prevents the memory address of hm from being modified -- the 
 * contents of hm can still be modified and hence it is unsafe to declare hm to be public.
 * 
 * The fix is to: 
 * - Declare hm to be private and perform a (deep) clone if other programs wish to read hm.
 * - Since Integer and String are immutable classes, a shallow copy of hm is sufficient.
 */
public class exercise3 {

  private static final HashMap<Integer, String> hm = new HashMap<Integer, String>();

  public exercise3(HashMap<Integer, String> h) {
        for (Map.Entry<Integer, String> entry : h.entrySet()) {
            hm.put(entry.getKey(), entry.getValue());
        }
    }

  public HashMap<Integer, String> getHashMap() {
    return (HashMap<Integer, String>) hm.clone();
  }

  /**
   * Unit test
   */
  public static void main(String[] args) {

    HashMap<Integer, String> a = new HashMap<Integer, String>();
    a.put(1, "hello");
    a.put(2, "world");

    exercise3 m = new exercise3(a);

    for (Map.Entry<Integer, String> entry : m.getHashMap().entrySet()) {
      System.out.printf("Key is %d, value is %s\n", entry.getKey(), entry.getValue());
    }

  }

}
