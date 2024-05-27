package org.techelevator.snakes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * A class to represent an Apple
 */
public class Apple extends Point{

    public Apple() {
        super(0, 0);
        moveToRandomLocation();
    }

    /**
     * Move the apple to a random location
     */
    public void moveToRandomLocation(){
        Random random = new Random();
        setX(random.nextInt(32));
        setY(random.nextInt(32));
    }
    @Override
    public void draw(GraphicsContext ctx, long currentFrame){
    ctx.setFill(Color.RED);
    ctx.fillOval(getX() * 25 , getY() * 25 , 25, 25);
    }
}
