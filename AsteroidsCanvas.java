import sacco.*;
import sacco.gui.*;
import java.util.*;
public class AsteroidsCanvas extends SCanvas 
{

    private CanvasTimer timer;
    private Asteroids myAsteroids;
    private Color myColor;
    private ArrayList<Asteroids> asteroidsList;
    private Picture pic;
    public AsteroidsCanvas()
    {
        timer = new CanvasTimer(this,40);
        timer.start();
        asteroidsList = new ArrayList<Asteroids>();
        pic = Picture.loadFromJar("space/bluespace.png");

        for (int i = 0; i<20; i++)
        {
            asteroidsList.add(new Asteroids());

        }
    }

    @Override
    public void paintCanvas(PaintBrush brush)
    {
        brush.drawPicture(pic, 0, 0);

        for (Asteroids myAsteroids : asteroidsList)
        {
            myAsteroids.paintSelf(brush);

        }
    }

    @Override
    public void onTimerTick()
    {
        for (Asteroids myAsteroids : asteroidsList)
        {
            myAsteroids.update();

            if( myAsteroids.getX() < 0-50)
            {
                myAsteroids.setX(500);

            }
            if(myAsteroids.getX() > 500+50 )
            {
                myAsteroids.setX(20);
            }

            if( myAsteroids.getY() < 0-50 )
            {
                myAsteroids.setY(500);

            }

            if(myAsteroids.getY() > 500+50 )
            {
                myAsteroids.setY(20);
            }

        }
    }



   

    public static void main()
    {
        SFrame frame = new SFrame();
        frame.add(new AsteroidsCanvas());
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
