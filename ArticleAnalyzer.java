import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleAnalyzer {

    private ArrayList<String> stopWords; //load from FileOperators
    private ArrayList<Article> articles; //load from FileOperators json 

    public ArticleAnalyzer(){
        stopWords = FileOperator.getStringList("stopwords.txt");
        articles = new ArrayList<>();
        System.out.println("Stopword Count" + stopWords.size());
        System.out.println("Articles Count "+articles.size());

        }

    public static void main(String[] args){
        ArticleAnalyzer analyzer = new ArticleAnalyzer();
        ArrayList<String> lines = FileOperator.getStringList("data.txt");
        String line = lines.get(0);
        Article a = analyzer.parseJson(line);
        System.out.println(a);
    }
    public void addStopWord(String word){

    }

    public void addArticle(Article article){
    }

    public Article parseJson(String jsonLine){
        Article result;
        Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\""); 
        Matcher lm =l.matcher(jsonLine);
        String lt = lm.find() ? lm.group(1) : "";
        result = new Article(lt, "", "", "", "", "");


        return result;
    } 

    public String removeStopWords(String text){
        String result = text;

        return result;
    }
}