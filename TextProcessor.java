import java.util.*;
public class TextProcessor {
    private ArrayList<String> textList;   // The list of text from the file
    /*
     * Constructor to create a TextProcessor with the specified filename
     */
    public TextProcessor(ArrayList<String> lines) {
        setTextList(lines);
    }
    /*
    * Changes the textList to the newTextList
    */
   public void setTextList(ArrayList<String> newTextList) {
    textList = newTextList;
   }
   /*
   * Finds and removes all occurrences of each stop word from textList
   */
  public void removeStopWords(ArrayList<String> stopWords) {
    for(String stopWord : stopWords){
      int i = 0;
      while(i<textList.size()){
        if(textList.get(i).equals(stopWord)){
          textList.remove(i);
        }
        else{
          i++;
        }
      }
    }

  }
   /*
   * Returns a String containing the text in textList
   */
  public String toString() {
    String text = "";

    for (String value : textList) {
      text = text + value + "\n";
    }

    return text;
  }






    public static void main(String[] args) {
        ArrayList<String> stopwords = FileOperator.getWords("stopwords.txt");
        ArrayList<String> posts = FileOperator.getWords("posts.txt");
        TextProcessor t = new TextProcessor(posts);
        t.removeStopWords(stopwords);
        System.out.println(t);
    }
    
}
