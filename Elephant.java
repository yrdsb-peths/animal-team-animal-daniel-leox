import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
    {
        
        for(int i = 0; i < idleRight.length;i++)
        {
            idleRight[i] = new GreenfootImage("images/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        animationTimer.mark(); 
        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }        
    }
    public void image()
    {
        setImage("images/elephant.png");
    }
    public void act()
    {
        //image();
        if(getX()-5>0){
            if(Greenfoot.isKeyDown("left"))
            {
              move(-5);  
            }
        }
        if(getX()+5<600){
            if(Greenfoot.isKeyDown("Right"))
            {
              move(5);  
            } 
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