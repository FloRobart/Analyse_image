import java.nio.file.attribute.*;
import java.nio.file.*;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Path path = Paths.get("./images/2020-09-08__13.09.50.jpeg");
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("creationTime: " + attr.creationTime());
            System.out.println("lastAccessTime: " + attr.lastAccessTime());
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

            System.out.println("isDirectory: " + attr.isDirectory());
            System.out.println("isOther: " + attr.isOther());
            System.out.println("isRegularFile: " + attr.isRegularFile());
            System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
            System.out.println("size: " + attr.size());
            
        } catch (Exception e) { System.out.println(e); }
    }
}