import sacco.*;
import sacco.gui.*;
public class Spaceship
{
    private double speed;
    private double direction;
    private int width;
    private int height;
    private int ran;
    private double x;
    private double y;
    private Picture myShip;
    private Picture asteroid;
    private boolean paintHitBox = true;

    public Spaceship()
    {
        x = (int)(Math.random()*500);
        y = (int)(Math.random()*500);
        speed = 3;
        direction = (int)(Math.random()*360);
        width = 50;
        height = width;
        ran = (int)(Math.random()*5);

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

    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }       
    
    
    public void setDirection(double tmpDirection)
    {
        direction = tmpDirection;
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
    
        public void setWidth(int tmpWidth)
    {
        width = tmpWidth;
    }
    
        public void setHeight(int tmpHeight)
    {
        height = tmpHeight;
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
        speed = speed+1;

    
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
        brush.drawPicture(myShip, (int)x, (int)y, width, height);
        brush.resetRotation();

                if (paintHitBox == false)
        {
            
            BoundingBox box = this.getHitBox();
            brush.drawRectangle((int)box.getX(), (int)box.getY(), (int)box.getWidth()-40, (int)box.getHeight()-40);

        }
    }
}

        