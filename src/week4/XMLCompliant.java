package week4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class XMLCompliant {
	void createXMLStream(BufferedOutputStream outStream, String quantity) throws IOException {
		// Write XML string if quantity contains numbers only.
		// Blacklisting of invalid characters can be performed in conjunction.
		if (!Pattern.matches("[0-9]+", quantity)) {
			throw new IOException("Potential XML Injection Attack Detected.");
		}
		String xmlString = "<item>\n<description>Widget</description>\n" + "<price>500</price>\n" + "<quantity>"
				+ quantity + "</quantity></item>";
		outStream.write(xmlString.getBytes());
		outStream.flush();
	}
}
