import sacco.*;
import sacco.gui.*;
public class BoundingBox
{
    private double x;
    private double y;
    private double width;
    private double height;

    public BoundingBox(double tmpX, double tmpY, double tmpWidth, double tmpHeight)
    {
        x = tmpX;
        y = tmpY;
        width = tmpWidth;
        height = tmpHeight;

    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }       

    double getWidth()
    {
        return width;
    }

    double getHeight()
    {
        return height;
    }

    public void setX(double tmpX) 
    {
        x = tmpX;
    }

    public void setY(double tmpY)
    {
        y = tmpY;
    }

    public void setWidth(double tmpWidth)
    {
        width = tmpWidth;
    }

    public void setHeight(double tmpHeight)
    {
        height = tmpHeight;
    }

    public boolean overlaps(BoundingBox other)
    {

        if(other.getX() >= this.getX()+width)
        {
            return false;
        }

        if(other.getX()+other.getWidth() <= this.getX())
        {
            return false;
        }

        if(other.getY()+other.getHeight() <= this.getY())
        {
            return false;
        }

        if(other.getY() >= this.getY()+height)
        {
            return false;
        }

        return true;
    }
}