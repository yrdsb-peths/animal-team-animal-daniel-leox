import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    int speed=1;
    public void act()
    {
        setImage("images/apple.png");
        int x =getX();
        int y = getY()+speed;
        setLocation(x,y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
        
    }
     public void setSpeed(int speed){
        this.speed+=speed;
    }
}
