import javax.xml.transform.*;
import java.io.*;

public class XSLTransformHTML {
public static void main(String[] args) {
  try {

    TransformerFactory tFactory = TransformerFactory.newInstance();

    Transformer transformer =
      tFactory.newTransformer
         (new javax.xml.transform.stream.StreamSource
            ("res/Council.xsl"));

    transformer.transform
      (new javax.xml.transform.stream.StreamSource
            ("res/Council.xml"),
       new javax.xml.transform.stream.StreamResult
            ( new FileOutputStream("res/Council.html")));
    System.out.println("Successfully transformed.");
    }
  catch (Exception e) {
    e.printStackTrace( );
    }
  }
}