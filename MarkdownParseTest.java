import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
  /*  @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void test2() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-2.md"));
        List<String> expect = List.of("https://test2.com", "an-image.jpeg");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void test3() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file3.md"));
        List<String> expect = List.of("Hello");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile3() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file3.md"));
        List<String> expect = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile4() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file4.md"));
        List<String> expect = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile5() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file5.md"));
        List<String> expect = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
    @Test
    public void testFile6() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file6.md"));
        List<String> expect = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile7() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file7.md"));
        List<String> expect = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile8() throws IOException {
        String contents= Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/test-file8.md"));
        List<String> expect = List.of("a link on the first line");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }*/
    @Test
    public void testSnippet1() throws IOException {
        String contents = Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/Snippet1.md"));
        List<String> expect = List.of("`google.com", "google.com","ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testSnippet2() throws IOException {
        String contents = Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/Snippet2.md"));
        List<String> expect = List.of("a.com","a.com(())", "example.com");
       assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testSnippet3() throws IOException {
        String contents = Files.readString(Path.of("/Users/michellechen/Documents/GitHub/markdown-parse - Mchellei/Snippet3.md"));
        List<String> expect = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/","https://cse.ucsd.edu/");
       assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}

    