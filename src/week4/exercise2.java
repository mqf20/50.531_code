package week4;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Pattern;

/**
 * Submission by FOO, Ming Qing (1003260, mingqing_foo@mymail.sutd.edu.sg),
 * 
 * The problem with the non-compliant code is: 
 * - the validation/pattern matching step should be executed last
 * - the pattern matching is not rigorous enough -- it fails to catch XSS attacks that call 
 *   "script" with varying cases and varying number of spaces between the closing brackets.
 *   
 * The fix is to:
 * - use a more general pattern matching criteria
 * - perform validation/pattern matching at the last step
 */
public class exercise2 {

  public static String sanitizeString(String s) {
    
    s = Normalizer.normalize(s, Form.NFKC);
    // Deletes all non-valid characters
    s = s.replaceAll("^\\p{ASCII}]", "");
    
//    Pattern pattern = Pattern.compile("<script>");  // not strict enough
//    Matcher matcher = pattern.matcher(s);  // not strict enough
//    if (matcher.find()) {  // not strict enough
    if (Pattern.matches("(?i).*<.*script.*>.*", s)) {
      System.out.println("\n*****blacklisted tag*****\n");
      return null;
    } else {
      System.out.println("\n*****safe tag*****\n");
    }
    
    return s;

  }

  /**
   * Unit test
   */
  public static void main(String[] args) {
    String input = "<   sCript   >alert(\"you are attacked\")</script>";
    String output = sanitizeString(input);
    System.out.printf("sanitized version of\n\n%s\n\nis\n\n%s", input, output);
  }
  
}