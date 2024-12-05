package code.metier;
/** GestionBruitageCacaClicker
  * date    : le 24/02/2024
  * @author : Théo Harel
  */ 
  
/*import pour le son */
/*------------------ */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/*------------------- */

public class GestionBruitage 
{

	public GestionBruitage()
	{
	}

	public void bruitage( String nomBruit )
	{

		URL soundFileUrl = GestionBruitage.class.getResource("../../fichier/bruitage/" + nomBruit + ".wav");
        try {
            File soundFile = new File(soundFileUrl.toURI());
            
            // Créer un AudioInputStream à partir du fichier
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            
            // Obtenir un Clip à partir de l'AudioInputStream
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            

			// Définir le niveau de gain (-80.0 à 6.0206, où -80.0 est le plus bas et 6.0206 est le plus haut)
            // Exemple: 0.0 pour le volume normal, -10.0 pour baisser le volume de 10 décibels, 6.0206 pour doubler le volume, etc.
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10.0f);

            // Lire le son
            clip.start();
            
        } catch (URISyntaxException | UnsupportedAudioFileException | IOException | LineUnavailableException  e) {
            e.printStackTrace();
        }
    }
}

