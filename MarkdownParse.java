import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkdownParse {
    public static Map<String, List<String>> getLinks(File dirOrFile) throws IOException {
        Map<String, List<String>> result = new HashMap<>();
        if(dirOrFile.isDirectory()) {
            for(File f: dirOrFile.listFiles()) {
                result.putAll(getLinks(f));
            }
            return result;
        }
        else {
            Path p = dirOrFile.toPath();
            int lastDot = p.toString().lastIndexOf(".");
            if(lastDot == -1 || !p.toString().substring(lastDot).equals(".md")) {
                return result;
            }
            ArrayList<String> links = getLinks(Files.readString(p));
            result.put(dirOrFile.getPath(), links);
            return result;
        }
    }
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            if (markdown.indexOf("[", currentIndex) == -1) {
                break;
            }
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if (nextOpenBracket!=0 && markdown.charAt(nextOpenBracket - 1) == '!') {
                currentIndex = nextOpenBracket + 1;
                continue;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if (nextCloseBracket == -1) {
                break;
            }
            int openParen = markdown.indexOf("(", nextCloseBracket);  
            if (openParen == -1 || openParen >= nextCloseBracket + 2) {
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if (closeParen == -1) {
                break;
            }
            
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        } 
        return toReturn;
    
    }

    public static void main(String[] args) throws IOException {
        File dirOrFile = new File(args[0].toString());
        if(dirOrFile.isDirectory()){
            getLinks(dirOrFile);
        }else{
        Path fileName = Path.of(args[0]);
       
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
        }
    }
}


