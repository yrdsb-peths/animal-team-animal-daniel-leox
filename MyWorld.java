 import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 0;
    int check=-1;
    public MyWorld() {
       
        super(600, 400, 1, false);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300,350);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        setBackground("images/background.jpg");
        creatApple();
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over" , 100);
        addObject(gameOverLabel, 300, 200);
    }
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if (score%5==0){
            level +=0.5;
        }
    }
    public void creatApple()
    {
        check++;
        if (check >= score/5){
            for(int i=score/5;i>=0;i--){
                Apple apple = new Apple();
                int x = Greenfoot.getRandomNumber(600) ;
                int y = 0;
                addObject(apple, x, y);
                apple.setSpeed(level);     
            }
            check=0;
        }
    }
}
