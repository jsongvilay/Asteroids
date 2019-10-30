import sacco.*;
import sacco.gui.*;
public class Asteroids
{
    private double speed;
    private double direction;
    private double rotation;
    private int width;
    private int height;
    private double size;
    private int ran;
    private int ran2;
    private double x;
    private double y;
    private Color myColor;
    private Picture asteroid;
    private boolean paintHitBox = true;

    public Asteroids()
    {
        x = (int)(Math.random()*500);
        y = (int)(Math.random()*500);

        int r= (int)(Math.random()*2);
        if(r==0)
        {
            x=0;
        }

        if(r==1)
        {
            y=0;
        }

        speed = 1;
        direction = (int)(Math.random()*360);
        rotation = (int)(Math.random()*360);
        width = 30;
        height = width;
        size = height;
        ran = (int)(Math.random()*5);
        ran2 = (int)(Math.random()*3);

        asteroid = BulletCanvas.loader.asteroidImage;

        if(ran == 1)
        {
            asteroid = BulletCanvas.loader.asteroidImage;
        }

        if(ran == 2)
        {
            asteroid = BulletCanvas.loader.asteroid2Image;
        }

        if(ran == 3)
        {
            asteroid = BulletCanvas.loader.asteroid3Image;
        }

        if(ran == 4)
        {
            asteroid = BulletCanvas.loader.asteroid4Image;
        }

        if(ran == 5)
        {
            asteroid = BulletCanvas.loader.asteroid5Image;
        }

        if(ran2 == 1)
        {
            width = 30;
        }

        if(ran2 == 2)
        {
            width = 50;
        }

        if(ran2 == 3)
        {
            width = 70;
        }

        height = width;

        myColor = new Color ((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }

    public Asteroids(double tmpX, double tmpY, int tmpSize, Picture tmpPic)
    {
        x = tmpX;
        y = tmpY;
        width = tmpSize;
        height = tmpSize;
        size = tmpSize;
        asteroid = tmpPic;
        speed = (int)(Math.random()*12)+1;
        direction = (int)(Math.random()*360);
        rotation = (int)(Math.random()*360);
    }

    public void update()
    {
        x += speed*Math.cos(Math.toRadians(direction));
        y -= speed*Math.sin(Math.toRadians(direction));

        rotation = rotation+5;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public int getSize()
    {
        return width;
    }

    public Picture getPic()
    {
        return asteroid;
    }

    public void setX(double tmpX) 
    {
        x = tmpX;
    }

    public void setY(double tmpY)
    {
        y = tmpY;
    }

    public void setSize(double tmpSize)
    {
        size = tmpSize;
    }

    public BoundingBox getHitBox()
    {
        return new BoundingBox((int)x, (int)y, width, height);
    }

    public void paintSelf(PaintBrush brush)
    {

        brush.rotateAroundPoint(rotation, (int)x+width/2, (int)y+height/2); 
        brush.drawPicture(asteroid, (int)x, (int)y, width, height);
        brush.resetRotation();

        if (paintHitBox == false)
        {

            BoundingBox box = this.getHitBox();
            brush.drawRectangle((int)box.getX(), (int)box.getY(), (int)box.getWidth(), (int)box.getHeight());

        }

    }
}

    