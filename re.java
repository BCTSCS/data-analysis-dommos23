import java.util.*;
public class re{

    public static void main(String[] args) {
        String re="#\\w\\s";
        String text="ABBBBBBBBA";
        //read posts.txt
        //Step 1 File Operator obj
        ArrayList<String> posts = FileOperator.getStringList("posts.txt");
        System.out.println(posts);
        //iterate each post and find #\w
        for(String post : posts){
            String result = post.matches(re)
        }

        boolean result = text.matches(re);
        System.out.println(result);
    }


}