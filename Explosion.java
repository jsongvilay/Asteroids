import sacco.*;
import sacco.gui.*;
import java.util.*;
public class Explosion 
{
    private double x;
    private double y;
    private int width;
    private int height;
    private int index;
    Picture[] pic;

    public Explosion(double tmpX, double tmpY)
    {
        pic = BulletCanvas.loader.explosionImage;
        x = tmpX;
        y = tmpY;
        width = 50;
        height = width;

    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }       

    public void setX(double tmpX) 
    {
        x = tmpX;
    }

    public void setY(double tmpY)
    {
        y = tmpY;
    }

    int getWidth()
    {
        return width;
    }

    int getHeight()
    {
        return height;
    }

    public void update()
    {
        index = index + 1;
    }

    public void paintSelf(PaintBrush brush)
    {
        if (index <= 32)
        {
            brush.drawPicture(pic[index],(int)x,(int)y, width, height);
        }
    }
}