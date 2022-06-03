package recuperation_page_web;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class TestRecupIntranet
{
    public static void main(String[] args)
    {
        try
        {
            String urlString = "https://zeperfs.com/fiche8589-toyota-yaris-iv-gr.htm";
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            
            System.out.println(is.read());
        }
        catch (Exception e) { e.printStackTrace(); System.out.println("\n\n problème"); }
    }
}
