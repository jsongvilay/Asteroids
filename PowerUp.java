import sacco.*;
import sacco.gui.*;
public class PowerUp
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
    private Picture powerup;
    private boolean paintHitBox = true;

    public PowerUp()
    {
        x = (int)(Math.random()*2);
        y = (int)(Math.random()*2);
        speed = 1;
        direction = (int)(Math.random()*360);
        rotation = (int)(Math.random()*360);
        width = 30;
        height = width;
        size = height;
        ran = (int)(Math.random()*5);
        ran2 = (int)(Math.random()*3);

        powerup = BulletCanvas.loader.powerupImage;

    }
    
    public PowerUp(double tmpX, double tmpY, int tmpSize, Picture tmpPic)
    {
        x = tmpX;
        y = tmpY;
        width = tmpSize;
        height = tmpSize;
        size = tmpSize;
        powerup = tmpPic;
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
        return powerup;
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
        brush.drawPicture(powerup, (int)x, (int)y, width, height);
        brush.resetRotation();

        if (paintHitBox == false)
        {

            BoundingBox box = this.getHitBox();
            brush.drawRectangle((int)box.getX(), (int)box.getY(), (int)box.getWidth(), (int)box.getHeight());

        }

    }
}

    