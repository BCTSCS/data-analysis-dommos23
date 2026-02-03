import java.io.*;
import java.util.*;
import java.util.regex.*;

class ProductReview{
    private String name;
    private String review;

    public ProductReview(String name, String review){
        this.name = name;
        this.review = review;

    }

    public String getName(){
        return name;
    }

    public String getReview(){
        return review;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setReview(String review){
        this.review = review;
    }

    public String toString(){
        return "Product: " + name + " | Review: " + review;
    }
}

class FileOperator{
    public static ArrayList<String> getStringList(String filename){
        ArrayList<String> lines = new ArrayList<>();
        
            try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + filename);
            e.printStackTrace();
        }
        return lines;
    }
}

public class ReviewCollector{
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    public ReviewCollector(){
        reviewList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addReview(ProductReview prodReview){
        reviewList.add(prodReview);

        String productName = prodReview.getName();
        boolean found = false;

        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).equals(productName)){
                found = true;
                break;
            }
        }
        if(!found){
            productList.add(productName);
        }
        System.out.println("ReviewList size: " + reviewList.size());
    }

    public int getNumGoodReviews(String prodName){
        int goodCount = 0;

        for(ProductReview elem : reviewList){
            if(elem.getName().equals(prodName)){
            String review = elem.getReview();
            String[] words = review.split(" ");
            double total = 0.0;

            for(String word : words){
                total+=getSentiments(word);
            }
            if(total>1){
                goodCount+=1;
            }

        }
    }
}
 public double getSentiments(String wordSearch) {
       // Read lines from sentiments.txt
       ArrayList<String> lines = FileOperator.getStringList("sentiments.txt");


       // Regex pattern to match word,decimal pairs
       Pattern pattern = Pattern.compile("([a-zA-Z0-9]+),(-?\\d+\\.\\d+)");




       // Process each line
       for (String line : lines) {
           Matcher matcher = pattern.matcher(line);
           if (matcher.find()) {
               String word = matcher.group(1); // Extract the word
               Double value = Double.parseDouble(matcher.group(2)); // Extract the value


           
                               if(wordSearch.equals(word)){
  // Print the result
               System.out.println(word + "   ----  " + value);


                   return value;
               }
            }
            return 0.0;
        }
    }


    public static void main(String[] args) {
        ReviewCollector reviewCollector = new ReviewCollector();
        ArrayList<String> lines = FileOperator.getStringList("reviews.txt");
        Pattern productPattern = Pattern.compile("Product:\\s*(.+)");
        Pattern reviewPattern = Pattern.compile("Review:\\s*(.+)");
        String productName = null;
        String review = null;
        
        for (String line : lines) {
            Matcher productMatcher = productPattern.matcher(line);
            Matcher reviewMatcher = reviewPattern.matcher(line);
            
            if (productMatcher.find()) {
                productName = productMatcher.group(1);
            } else if (reviewMatcher.find()) {
                review = reviewMatcher.group(1);
            }
            
            if (productName != null && review != null) {
                ProductReview product = new ProductReview(productName, review);
                reviewCollector.addReview(product);
                System.out.println(product);
                
                productName = null;
                review = null;
            }
        } 
    }  
}  