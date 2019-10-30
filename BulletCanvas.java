import sacco.*;
import sacco.gui.*;
import java.util.*;
public class BulletCanvas extends SCanvas implements KeyListener, MouseListener
{
    private CanvasTimer timer;
    private Asteroids myAsteroids;
    private Spaceship myShip;
    private int level;
    private Color myColor;
    private ArrayList<Asteroids> asteroidsList;
    private ArrayList<Bullet> bulletList;
    private ArrayList<PowerUp> powerupList;
    public static final ImageLoader loader = new ImageLoader();
    private Picture pic;
    private Explosion myExplosion;
    private boolean isActive = true;

    private boolean rt = false, a = false, b = false, c = false, d = true;
    public BulletCanvas()
    {
        timer = new CanvasTimer(this,50);
        level = 1;
        asteroidsList = new ArrayList<Asteroids>();
        bulletList = new ArrayList<Bullet>();
        powerupList = new ArrayList<PowerUp>();

        pic = Picture.loadFromJar("space/bluespace.png");
        myShip = new Spaceship();

        for (int i = 0; i<4; i++)
        {
            asteroidsList.add(new Asteroids());

        }

        for (int i = 0; i<1; i++)
        {
            powerupList.add(new PowerUp());

        }

        timer.start();
    }

    @Override
    public void paintCanvas(PaintBrush brush)
    {
        brush.drawPicture(pic, 0, 0);

        brush.setColor( Color.RED );
        brush.drawString("Level: "+ level, 230,100);

        
        myShip.paintSelf(brush);


        if(!timer.isRunning())
        {
            brush.setColor( Color.RED );
            brush.drawString("Game Over", 200,250);
        }

        if( myExplosion != null )
        {
            myExplosion.paintSelf(brush);
        }

        for (Asteroids myAsteroids : asteroidsList)
        {
            myAsteroids.paintSelf(brush);
        }

        for (Bullet myBullet : bulletList)
        {
            myBullet.paintSelf(brush);

        }

        for (PowerUp myPowerup : powerupList)
        {
            myPowerup.paintSelf(brush);
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
if (isActive == true)
{
        for (PowerUp myPowerup : powerupList)
        {
            myPowerup.update();

            if( myPowerup.getX() < 0-50)
            {
                myPowerup.setX(500);

            }

            if(myPowerup.getX() > 500+50 )
            {
                myPowerup.setX(20);
            }

            if( myPowerup.getY() < 0-50 )
            {
                myPowerup.setY(500);

            }

            if(myPowerup.getY() > 500+50 )
            {
                myPowerup.setY(20);
            }

        }

        for (Bullet myBullet : bulletList)
        { 
            myBullet.update();

            if( myBullet.getX() < 0-50)
            {
                myBullet.setX(500);

            }
            if(myBullet.getX() > 500+50 )
            {
                myBullet.setX(20);
            }

            if( myBullet.getY() < 0-50 )
            {
                myBullet.setY(500);

            }

            if(myBullet.getY() > 500+50 )
            {
                myBullet.setY(20);
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

        for (int i = 0; i<bulletList.size(); i++)
        {

            Bullet myBullet = bulletList.get(i);

            if(myBullet.isTooOld())
            {
                bulletList.remove(i);

            }

        }

        for( int i = 0; i < bulletList.size(); i++)
        {
            Bullet tmpBul = bulletList.get(i);
            BoundingBox bulBox = tmpBul.getHitBox();

            for( int j = 0; j < asteroidsList.size(); j++)
            {
                Asteroids tmpAst = asteroidsList.get( j );
                BoundingBox astBox = tmpAst.getHitBox();

                if( bulBox.overlaps( astBox ) )
                {
                    bulletList.remove(i);
                    asteroidsList.remove(j);

                    if(tmpAst.getSize() == 50)
                    {
                        asteroidsList.add(new Asteroids(tmpAst.getX(),tmpAst.getY(),tmpAst.getSize()-20, tmpAst.getPic()));
                        asteroidsList.add(new Asteroids(tmpAst.getX(),tmpAst.getY(),tmpAst.getSize()-20, tmpAst.getPic()));
                        break;
                    }

                    if(tmpAst.getSize() == 70)
                    {
                        asteroidsList.add(new Asteroids(tmpAst.getX(),tmpAst.getY(),tmpAst.getSize()-20, tmpAst.getPic()));
                        asteroidsList.add(new Asteroids(tmpAst.getX(),tmpAst.getY(),tmpAst.getSize()-20, tmpAst.getPic()));
                        break;
                    }

                }
            }
        }

        
        {
            for( int j = 0; j < asteroidsList.size(); j++)
            {

                Asteroids tmpAst = asteroidsList.get( j );
                BoundingBox astBox = tmpAst.getHitBox();
                BoundingBox shipBox = myShip.getHitBox();

                if( astBox.overlaps( shipBox ) )
                {
                    isActive = false;
                    myShip.setWidth(0);
                    myShip.setHeight(0);
                    myExplosion = new Explosion(myShip.getX(), myShip.getY());
                }
            }
        }


        if (asteroidsList.size() == 0)
        {
            level = level+1;

            for (int i = 0; i<2*level+3; i++)
            {
                asteroidsList.add(new Asteroids());
            }

        }

        for( int j = 0; j < powerupList.size(); j++)
        {

            PowerUp tmpPwr = powerupList.get( j );

            BoundingBox powerupBox = tmpPwr.getHitBox();
            BoundingBox shipBox = myShip.getHitBox();

            if( powerupBox.overlaps( shipBox ) )
            {
                powerupList.remove(j);

                for (int r = 0; r<360; r+=10)
                {
                    bulletList.add(new Bullet(myShip.getX()+myShip.getWidth(), myShip.getY()+myShip.getHeight(),r));
                }

            }

        }

        if (powerupList.size() == 0)
        {
            for (int i = 0; i<1; i++)
            {
                powerupList.add(new PowerUp());
            }

        }
    }
        if( myExplosion != null )
        {
            myExplosion.update();
        }
        
    }

    public void onKeyPress(int keyCode)
    {
        if (isActive == true)
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

            if (keyCode == 32)
            {
                bulletList.add(new Bullet(myShip.getX()+myShip.getWidth()/2, myShip.getY()+myShip.getHeight()/2, myShip.getDirection()));
            }
        }

        if(keyCode == 82)
        {
            reset();
        }

    }
    @Override
    public void onKeyRelease(int keyCode)
    {
        if (isActive == true)
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

        if(keyCode == 32)
        {
            d= false;
        }

    }
}
    // public void onMousePress(MouseEvent m)
    //  {

    //   int   x = m.getX();
    //  int   y = m.getY();
    //  myExplosion = new Explosion(x,y);
    // }

    public void reset()
    {
        asteroidsList = new ArrayList<Asteroids>();

        for (int i = 0; i<4; i++)
        {
            asteroidsList.add(new Asteroids());
            level = 1;
        }

        timer.start();
    }

    public void setActive(boolean isActive)
    {
        isActive = false;
    }

    public boolean getActive()
    {
        return isActive;
    }

    public static void main()
    {
        SFrame frame = new SFrame();
        frame.add(new BulletCanvas());
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.exitOnClose();
    }
}

    