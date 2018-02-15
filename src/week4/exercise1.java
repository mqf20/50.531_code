package week4;

/**
 * Submission by FOO, Ming Qing (1003260, mingqing_foo@mymail.sutd.edu.sg),
 * 
 * This class demonstrates how to sanitize an untrusted string to be displayed on a web page and
 * prevent XSS attacks. We assume that the string will be rendered by HTML -- this affects how we
 * perform sanitization.
 * 
 */
public class exercise1 {

  /**
   * In sanitizeString(), we substitute "risky" characters such as "<" and ">" from a input string
   * with their alternate representations called entities. When a browser encounters these entities,
   * they will display them by converting them back to HTML rather than run them. Thus, the "look"
   * of the string will be preserved but it cannot perform XSS attacks.
   * 
   * See https://en.wikipedia.org/wiki/Character_encodings_in_HTML for list of character encodings.
   */
  public static String sanitizeString(String input) {
    if (input == null) {
      return input;
    }
    String output = input.replace(" ", "&nbsp"); // replace white spaces
    output = output.replace("<", "&lt"); // replace <
    output = output.replace(">", "&gt"); // replace >
    output = output.replace("&", "&amp"); // replace &
    output = output.replace("\"", "&quot"); // replace "
    output = output.replace("\'", "&apos"); // replace '
    return output;
  }

  /**
   * Unit test
   */
  public static void main(String[] args) {
    String input = "<script>alert(\"you are attacked\")</script>";
    String output = sanitizeString(input);
    System.out.printf("sanitized version of\n\n%s\n\nis\n\n%s", input, output);
  }

}