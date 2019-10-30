import sacco.*;
import sacco.gui.*;
public class Bullet
{
    private double speed;
    private int width;
    private int height;
    private int ran;
    private double x;
    private double y;
    private double direction;
    private int count;
    private int max;

    private Picture myShip;
    private Picture asteroid;
    private Picture bullet;
    private boolean paintHitBox = true;

    public Bullet(double tmpX, double tmpY, double tmpDirection)
    {
        x = tmpX-5;
        y = tmpY-5;
        max = 30;
        direction = tmpDirection;
        speed = 12;
        ran = (int)(Math.random()*5);

        width = 10;
        height = width;

        bullet = BulletCanvas.loader.bulletImage;
        asteroid = BulletCanvas.loader.asteroidImage;
        myShip = BulletCanvas.loader.shipImage;

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

    }

    public void update()
    {
        x += speed*Math.cos(Math.toRadians(direction));
        y -= speed*Math.sin(Math.toRadians(direction));
        count = count+1;

    }

    public boolean isTooOld()
    {
        if(count > max)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }       

    public double getDirection()
    {
        return direction;
    }

    public void setX(double tmpX) 
    {
        x = tmpX;
    }

    public void setY(double tmpY)
    {
        y = tmpY;
    }

    public void setDirection(double tmpDirection)
    {
        direction = tmpDirection;
    }

    int getWidth()
    {
        return width;
    }

    int getHeight()
    {
        return height;
    }

    public void turnLeft()
    {
        direction = direction+20;
    }

    public void turnRight()
    {
        direction = direction-20;
    }

    public void speedUp()
    {
        speed = speed+3;

        if (speed > 3)
        {
            speed = 0;
        }

    }

    public void slowDown()
    {
        speed = speed-1;

        if (speed < 0)
        {
            speed = speed+1;
        }

    }

    public BoundingBox getHitBox()
    {
        return new BoundingBox((int)x, (int)y, width, height);
    }

    public void paintSelf(PaintBrush brush)
    {

        brush.rotateAroundPoint(direction, (int)x+width/2, (int)y+height/2); 

        brush.drawPicture(bullet, (int)x, (int)y, 10, 10);
        brush.resetRotation();
        if (paintHitBox == false)
        {

            BoundingBox box = this.getHitBox();
            brush.drawRectangle((int)box.getX(), (int)box.getY(), (int)box.getWidth(), (int)box.getHeight());

        }
    }
}
