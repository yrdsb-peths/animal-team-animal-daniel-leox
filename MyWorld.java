 import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 0;
    int check=-1;
    int apple=1;
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
        if (score%6==0 && score!=0){
            apple++;
            for(int i=0;i<apple;i++){
                Apple apple = new Apple();
                int x = Greenfoot.getRandomNumber(600) ;
                int y = 0;
                addObject(apple, x, y);
                apple.setSpeed(level);     
            }
            check=0;
        }
        if (check >=apple|| score==0){
            for(int i=0;i<apple;i++){
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
