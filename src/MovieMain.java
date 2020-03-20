import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
 
public class MovieMain{
 
    public static void main(String[] args) throws IOException {
        Movietree movies = new Movietree();
        File file = new File("data/movies.csv");
        Scanner sc = new Scanner(file);
        int movieId = 0, releaseYear = 0;
        String title = "", finalTitle = "";
        String[] genres = {};
        sc.nextLine();
        while (sc.hasNextLine()) {
            String str  = sc.nextLine();
            String[] tokens = sc.nextLine().split(",");
            String line = tokens[1];
            movieId = Integer.parseInt(tokens[0]);
            int len = 0;
               
            if (line.charAt(0) == '"') {
                title = line;
                len = title.length();
                if (tokens.length >= 4) {
                    title += ", ";
                    for (int i = 2; i<tokens.length-1; i++) {title += tokens[i];}
                    genres = tokens[3].split("\\|");
                } 
                else {genres = tokens[2].split("\\|");}
               
                if (title.charAt(len-1) == ' ') {len = title.length()-6;} 
                else {len = title.length()-5;}
                finalTitle = title.substring(0, len-2);
               
                if (tokens.length >= 4)
                    genres = tokens[3].split("\\|");
                releaseYear = Integer.parseInt(title.substring(len, len+4));
            } 
            
            else {
                title = line;
                len = title.length();
                if (title.charAt(len-1) == ' ') {len = title.length()-6;} 
                else {len = title.length()-5;}
                finalTitle = title.substring(0, len-2);
                System.out.println(finalTitle);
                releaseYear = Integer.parseInt(title.substring(len, len+4));
                if (tokens.length >= 3)genres = tokens[2].split("\\|");}

            movies.addNode(finalTitle, releaseYear, movieId, genres);
        }
       
        Set s1 = movies.subSet("Bug's Life", "Harry Potter");
        System.out.println(s1);
    }
 
}