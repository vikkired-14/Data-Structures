import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaClassCounter {
    public static void main(String[] args) {
        // Call the countJavaClasses method to count Java classes in the current directory and its subdirectories
        int count = countJavaClasses(new File("."));

        // Print the result
        System.out.println("Number of Java class files in the current directory and its subdirectories: " + count);
    }

    public static int countJavaClasses(File directory) {
        // Initialize a list to store Java class files
        List<File> javaFiles = new ArrayList<>();

        // Call the recursive method to find Java class files
        findJavaClasses(directory, javaFiles);

        // Return the count of Java class files found
        return javaFiles.size();
    }

    public static void findJavaClasses(File directory, List<File> javaFiles) {
        // Get the list of files in the current directory
        File[] files = directory.listFiles();

        // If the directory is empty or null, return
        if (files == null || files.length == 0) {
            return;
        }

        // Iterate through the files in the directory
        for (File file : files) {
            if (file.isDirectory()) {
                // If it's a directory, recursively search for Java class files
                findJavaClasses(file, javaFiles);
            } else if (file.getName().endsWith(".java")) {
                // If it's a Java class file, add it to the list
                javaFiles.add(file);
            }
        }
    }
}
