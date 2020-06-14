import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class MainClass {

    private static void writeFile(String content, String fileName){
        try {
            PrintStream ps = new PrintStream(new FileOutputStream(fileName));
            ps.write(content.getBytes());
            ps.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void readFile(StringBuilder sb, String fileName){
        try {
            Scanner s = new Scanner(new FileInputStream(fileName));
            while(s.hasNextLine()){
                sb.append(s.nextLine() + "\n");
            }
            s.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void concatFiles(String fileName1, String fileName2, String resultFileName){
        StringBuilder sb = new StringBuilder();
        readFile(sb, fileName1);
        readFile(sb, fileName2);
        writeFile(sb.toString(), resultFileName);
    }

    private static String getTheWord(){
        System.out.println("Type a word for search:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        return s;
    }

    private static boolean isPresent(String word, String fileName){
        try {
            Scanner s = new Scanner(new FileInputStream(fileName));
            while (s.hasNextLine()){
                if (s.nextLine().contains(word)){
                    s.close();
                    return true;
                }
            }
            s.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }

    private static void testFile(String word, String fileName){
        if (isPresent(word, fileName)) {
            System.out.println("File " + fileName + " contains word \"" + word + "\"");
        } else {
            System.out.println("File " + fileName + " does not contain word \"" + word + "\"");
        }
    }

    public static void main(String[] args) {
        String s1 = "oleg zhivet pod strahom smerti\n" +
                "s oksanoy v gorode norilsk\n" +
                "poskolku po drugoy prichine\n" +
                "ni tam ni s neyu zhit nelzya";
        String file1 = "file1.txt";

        String s2 = "letit po nebu bespilotnik\n" +
                "pod nim pronzaya oblaka\n" +
                "letit k zemle bezsamoletnik\n" +
                "otkryt pytayas parashut";
        String file2 = "file2.txt";

        String resultFileName = "concatenated_files.txt";

        writeFile(s1, file1);
        writeFile(s2, file2);

        concatFiles(file1, file2, resultFileName);

        String wordToSearch = getTheWord();

        File file = new File(System.getProperty("user.dir"));
        String[] files = file.list();
        for(String f : files){
            if (f.endsWith(".txt")) {
                testFile(wordToSearch, f);
            }
        }
    }
}
