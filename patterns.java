import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
  public static void main(String[] args) {
    try {
      // Load file
      BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

      // Read file line by line
      String line;
      StringBuilder stringBuilder = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
      }
      reader.close();

      // Extract <HEADER> content
      Pattern headerPattern = Pattern.compile("<HEADER>(.*?)</HEADER>");
      Matcher headerMatcher = headerPattern.matcher(stringBuilder.toString());
      String headerContent = "";
      if (headerMatcher.find()) {
        headerContent = headerMatcher.group(1);
      }

      // Extract <RuleFired> contents
      Pattern ruleFiredPattern = Pattern.compile("<RuleFired>(.*?)</RuleFired>");
      Matcher ruleFiredMatcher = ruleFiredPattern.matcher(stringBuilder.toString());
      ArrayList<String> ruleFiredContentList = new ArrayList<String>();
      while (ruleFiredMatcher.find()) {
        String ruleFiredContent = ruleFiredMatcher.group(1);
        ruleFiredContentList.add(ruleFiredContent);
      }

      // Print results
      System.out.println("<HEADER> content: " + headerContent);
      System.out.println("<RuleFired> contents: " + ruleFiredContentList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
