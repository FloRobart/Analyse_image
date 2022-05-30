import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataController;
import javax.imageio.stream.ImageInputStream;
import javax.swing.text.html.HTMLDocument.Iterator;


public class TestMetaData
{
    public static void main(String[] args)
    {
        File file = new File("./images/2020-09-08__13.09.50.jpeg");
        TestMetaData.Image(file);
    }


    
    public static void Image(File oImage)
    {
        try
        {
            ImageInputStream iis = ImageIO.createImageInputStream(oImage);
            java.util.Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
            
            while (iter.hasNext())
            {
                ImageReader ir =  iter.next();
                ir.setInput(iis);
        
                System.out.println("\tCette photo mesure : " + ir.getWidth(0) + " x " + ir.getHeight(0) + " pixels");
                System.out.println("\tElle est de type : " + ir.getFormatName());
        
                IIOMetadata metaData = ir.getImageMetadata(0);

                // test
                String[] test = metaData.getExtraMetadataFormatNames();
                if (test == null) {System.out.println("c'est null");}
                else {
                    for (int i = 0; i < test.length; i++) {
                        System.out.println(test[i]);
                    }
                }
                
                
                

                try
                {
                    System.out.println("\t\t" + metaData.getNativeMetadataFormatName());
                    String[] asMetaData = metaData.getMetadataFormatNames();
                    for (String sMetaData : asMetaData)
                    {
                        System.out.println("\t\t" + sMetaData);
                    }
                }
                catch (NullPointerException ex)
                {
                    Logger.getLogger(Metier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("programme fini");
        }

        catch (IOException ex)
        {
            Logger.getLogger(Metier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
