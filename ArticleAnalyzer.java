import java.util.ArrayList;
import java.util.regex.Pattern;
public class ArticleAnalyzer {

    private ArrayList<String> stopWords; //load from FileOperators
    private ArrayList<Article> articles; //load from FileOperators json 

    public ArticleAnalyzer(){
        stopWords = FileOperator.getStringList("stopwords.txt");
        System.out.println("Stopword Count" + stopWords.size());
        articles = new ArrayList<>();
        System.out.println("Articles Count "+articles.size());
    }

    public static void main(String[] args){
        ArticleAnalyzer analyzer = new ArticleAnalyzer();
    }
    public void addStopWord(String word){
    }

    public void addArticle(Article article){
    }

    public Article parseJson(String jsonLine){
        Article result;
        String text = 
        Pattern c = Pattern.compile("re");
        Pattern h = Pattern.compile("re");
        Pattern d = Pattern.compile("re");
        Pattern a = Pattern.compile("re");
        Pattern t = Pattern.compile("re");



        return result;
    } 

    public String removeStopWords(String text){
        String result;

        return result;
    }
}