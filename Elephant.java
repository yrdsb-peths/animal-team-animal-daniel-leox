import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage idle = new GreenfootImage("images/idle0.png");
    public Elephant()
    {
        setImage(idle);
    }
    public void image()
    {
        setImage("images/elephant.png");
    }
    public void act()
    {
        image();
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(5);
        }
        eat();
    }
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.creatApple();
            world.increaseScore();
            elephantSound.play();
        }
        
    }
}