import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import javax.swing.text.html.HTMLDocument.Iterator;


public class Metier
{
    private Controleur ctrl;
    private BufferedImage bufImg;

    private int   nbPixel;
    private int[] tabColor;
    private List<Color> lstColor;


    public Metier(Controleur ctrl)
    {
        this.ctrl     = ctrl;
        this.bufImg   = this.ctrl.getBufImage();

        this.nbPixel  = this.bufImg.getWidth()*this.bufImg.getHeight();
        this.tabColor  = new int[this.nbPixel];
        this.lstColor = new ArrayList<Color>();
    }

    public void couleur()
    {
        // réinitialisation de tout les éléments
        this.bufImg    = this.ctrl.getBufImage();
        this.nbPixel   = this.bufImg.getWidth()*this.bufImg.getHeight();
        this.tabColor  = new int[this.nbPixel];
        this.lstColor.removeAll(this.lstColor);

        // Récupération de tout les pixels de l'image dans un tableau
        this.tabColor = this.bufImg.getRGB(0, 0, this.bufImg.getWidth(), this.bufImg.getHeight(), this.tabColor, 0, this.bufImg.getWidth());
        
        // Transformation du tableau en ArrayList
        for (int i : this.tabColor)
            this.lstColor.add(new Color(i));

        // traitement des métadonnées



        // Traitement des pixels
        double rouge = 0, green = 0, blue = 0;
        for (Color c : lstColor)
        {
            rouge += (double)(c.getRed  ())/(3*100);
            green += (double)(c.getGreen())/(3*100);
            blue  += (double)(c.getBlue ())/(3*100);
        }

        // Affichage du résutat du traitement des pixels
        System.out.println("\nTableau : " + this.tabColor.length);
        System.out.println("Liste   : " + this.lstColor.size() + "\n");

        System.out.println(rouge + " | " + green + " | " + blue);

        if (rouge == 0 && green == 0 && blue == 0)
            System.out.println("Cette image est noir");
        else
            System.out.println("Cette image est constitué à " + String.format("%2.2f", rouge/nbPixel*100) + "% de rouge, " + String.format("%2.2f", green/nbPixel*100) + "% de vert, et à " + String.format("%2.2f", blue/nbPixel*100) + "% de bleu");
    }
}
