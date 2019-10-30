import sacco.*;
import sacco.gui.*;

public class ImageLoader
{
    public Picture asteroidImage;
    public Picture asteroid2Image;
    public Picture asteroid3Image;
    public Picture asteroid4Image;
    public Picture asteroid5Image;
    public Picture asteroid6Image;
    public Picture shipImage;
    public Picture bulletImage;
    public Picture powerupImage;
    public Picture[] explosionImage;

    public ImageLoader()
    {

        asteroidImage = Picture.loadFromJar("space/asteroid1.png");
        asteroid2Image = Picture.loadFromJar("space/asteroid2.png");
        asteroid3Image = Picture.loadFromJar("space/asteroid3.png");
        asteroid4Image = Picture.loadFromJar("space/asteroid4.png");
        asteroid5Image =  Picture.loadFromJar("space/asteroid5.png");
        shipImage = Picture.loadFromJar("space/spaceship.png");
        bulletImage = Picture.loadFromJar("space/bullet.png");
        powerupImage = Picture.loadFromFile("sacco.png");
        explosionImage = SpriteLoader.getExplosionPics();
    }
}

