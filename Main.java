import java.nio.file.attribute.*;
import java.nio.file.*;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
  try {
    
    Path file = Paths.get("./images/2020-09-08__13.09.50.jpeg");
    BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

    System.out.println("Date de création: " + attr.creationTime());
    System.out.println("Date du dernier accès: " + attr.lastAccessTime());
    System.out.println("Date derniere modification: " + attr.lastModifiedTime());
    
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    }
}