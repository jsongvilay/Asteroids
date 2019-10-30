import sacco.*;
import sacco.gui.*;
import java.util.*;
public class SpaceshipCanvas extends SCanvas implements KeyListener
{

    private CanvasTimer timer;
    private Asteroids myAsteroids;
    private Spaceship myShip;
    private Color myColor;
    private ArrayList<Asteroids> asteroidsList;
    private Picture pic;

    private boolean rt = false, a = false, b = false, c = false;

    public SpaceshipCanvas()
    {
        timer = new CanvasTimer(this,50);

        asteroidsList = new ArrayList<Asteroids>();
        pic = Picture.loadFromJar("space/bluespace.png");
        myShip = new Spaceship();

        for (int i = 0; i<20; i++)
        {
            asteroidsList.add(new Asteroids());
        }

        timer.start();

    }

    @Override
    public void paintCanvas(PaintBrush brush)
    {
        brush.drawPicture(pic, 0, 0);

        myShip.paintSelf(brush);

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

        myShip.update();
        if (rt == true)
        {
            myShip.speedUp();
        }

        if (a == true)
        {
            myShip.turnLeft();
        }

        if (b == true)
        {
            myShip.turnRight();
        }

        if (c == true)
        {
            myShip.slowDown();
        }

        if( myShip.getX() < 0-50)
        {
            myShip.setX(500);

        }
        if(myShip.getX() > 500+50 )
        {
            myShip.setX(20);
        }

        if( myShip.getY() < 0-50 )
        {
            myShip.setY(500);

        }

        if(myShip.getY() > 500+50 )
        {
            myShip.setY(20);
        }
    }

    public void onKeyPress(int keyCode)
    {

        if (keyCode == 38)
        {
            rt = true;
        }

        if(keyCode == 37)
        {
            a = true;
        }

        if (keyCode == 39)
        {
            b = true;
        }

        if (keyCode == 40)
        {
            c = true;

        }

    }

    @Override
    public void onKeyRelease(int keyCode)
    {
        if (keyCode == 38)
        {
            rt = false;
        }

        if(keyCode == 37)
        {
            a = false;
        }

        if(keyCode == 39)
        {
            b = false;
        }

        if (keyCode == 40)
        {
            c = false;

        }

    }

    public static void main()
    {
        SFrame frame = new SFrame();
        frame.add(new SpaceshipCanvas());
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.exitOnClose();
    }
}
