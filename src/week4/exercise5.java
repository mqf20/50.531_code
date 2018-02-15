package week4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Submission by FOO, Ming Qing (1003260, mingqing_foo@mymail.sutd.edu.sg),
 * 
 * The problem with the non-compliant code is: 
 * - If an exception occurs within the try {...} block, the lock will not be released.
 * 
 * The fix is to: 
 * - Place the unlock() method in the finally {...} block, which will always execute regardless of
 *   what happens within the try {...} block.
 * - It is also a good idea to close the FileInputStream.
 */
public class exercise5 {
  
  public final class NoncompliantLCK8 {
    
    public void doSomething(File file) throws Exception {
      final Lock lock = new ReentrantLock();
      InputStream in = null;
      try {
        lock.lock();
        in = new FileInputStream(file);
        in.read();
      } catch (FileNotFoundException x) {
        // handle FileNotFoundException
      } finally {
        if (in != null) {
          in.close();
        }
        lock.unlock();
      }
    }
  }

  /**
   * Unit test
   */
  public static void main(String[] args) throws Exception {
    
    NoncompliantLCK8 nc = new exercise5().new NoncompliantLCK8();
    nc.doSomething(new File("exercise5.java"));

  }

}