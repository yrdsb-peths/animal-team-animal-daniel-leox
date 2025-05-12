import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle = new GreenfootImage[8];
    public Elephant()
    {
        for(int i = 0; i < idle.length;i++)
        {
            idle[i] = new GreenfootImage("images/idle" + i + ".png");
            idle[i].scale(100,100);
        }
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
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
        animateElephant();
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