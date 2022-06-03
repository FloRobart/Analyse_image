package recuperation_page_web;

import java.io.*;
import java.net.*;
import iut.algo.Clavier;


public class TestRecupPage
{
    public static String getHTML(String urlToRead) throws Exception
    {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())))
        {
            for (String line; (line = reader.readLine()) != null;)
                result.append(line);
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception
    {
        if (args.length != 0)
            System.out.println(getHTML(args[0]));
        else
        {
            System.out.println("saisissez une URL : ");
            args[0] = Clavier.lireString();
        }
    }
}
