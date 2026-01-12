import java.util.regex.*;
public class re{

    public static void main(String[] args) {
    //     String re="#\\w\\s";
    //     String text="ABBBBBBBBA";
    //     //read posts.txt
    //     //Step 1 File Operator obj
    //     ArrayList<String> posts = FileOperator.getStringList("posts.txt");
    //     System.out.println(posts);
    //     //iterate each post and find #\w
    //     for(String post : posts){
    //         String result = post.matches(re)
    //     }

    //     boolean result = text.matches(re);
    //     System.out.println(result);
    // }
    String re="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
    String email = "dommos26@bergen.org";
    boolean emailValid = email.matches(re);

    System.out.println("Email Pattern" + re);
    System.out.println("Email Text: " + email);
    System.out.println("Is it a valid email? " + emailValid);
    System.out.println();

    String text = "Computer Science Period 8 is a smart class.";
    String capitalWords = "\\b[A-Z][a-z]+\\b";
    System.out.println("Capital Words Pattern: " + capitalWords);
    System.out.println("Text: " + text);
    System.out.println("Capital Letters:");

    Pattern pattern = Pattern.compile(capitalWords);
    Matcher matcher = pattern.matcher(text);

    while(matcher.find()){
        System.out.println(matcher.group());
    }




}
}