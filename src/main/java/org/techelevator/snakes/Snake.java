package org.techelevator.snakes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;

public class Snake {
    /**
     * Up direction
     */
    public final static int DIRECTION_UP = 0;
    /**
     * Down direction
     */
    public final static int DIRECTION_DOWN = 1;
    /**
     * Right direction
     */
    public final static int DIRECTION_RIGHT = 2;
    /**
     * ULeft direction
     */
    public final static int DIRECTION_LEFT = 3;
    /**
     * The segments of the snake
     */
    private List<Point> segments = new ArrayList<>();

    /**
     * The direction the snake is currently moving in.
     */
    private int direction =DIRECTION_DOWN;



    /**
     * Create a new snake of length 2 at 0,1 and 0,0
     */
    public Snake(){
        segments.add(new Point(0,2));
        segments.add(new Point(0,1));
        segments.add(new Point(0,0));
    }
    /**
     * Get the head of the snake (first segment)
     *
     * @return The head of the snake
     */
    public Point getHead(){
        return segments.get(0);
    }

    /**
     * Get the current direction of the snake
     * @return The current direction
     */
    public int getDirection(){
        return direction;
    }
/*

    */
/**
     * Set the direct of the snake
     *
     * @param direction
     *//*

    public void setDirection(int direction){
        if(direction == DIRECTION_UP && this.direction != DIRECTION_DOWN){
            this.direction = direction;
        } else if(direction == DIRECTION_DOWN && this.direction != DIRECTION_UP){
            this.direction = direction;
        } else if(direction == DIRECTION_LEFT && this.direction != DIRECTION_RIGHT){
            this.direction = direction;
        } else if(direction == DIRECTION_RIGHT && this.direction != DIRECTION_LEFT){
            this.direction = direction;
        }
    }
*/

    /**
     * Change the direction of the snake to up
     */
    public void setDirectionUp(){
        if(this.direction != DIRECTION_DOWN){
            this.direction = DIRECTION_UP;
        }
    }
    /**
     * Change the direction of the snake to down
     */
    public void setDirectionDown(){
        if(this.direction != DIRECTION_UP){
            this.direction = DIRECTION_DOWN;
        }
    }
    /**
     * Change the direction of the snake to left
     */
    public void setDirectionLeft(){
        if(this.direction != DIRECTION_RIGHT){
            this.direction = DIRECTION_LEFT;
        }
    }
    /**
     * Change the direction of the snake to right
     */
    public void setDirectionRight(){
        if(this.direction != DIRECTION_LEFT){
            this.direction = DIRECTION_RIGHT;
        }
    }

    /**
     * Move the snake
     *
     * Move all the segments to the position of the segment in front of it
     * Move the head in the current direction
     *
     */
    public void move(boolean shouldGrow){
        Point tail = segments.get(segments.size() -1);
        Point newSegment = new Point(tail);


        for (int i = segments.size()-1; i > 0 ; i--) {
            segments.get(i).copyCoordinates(segments.get(i-1));
        }
        if(direction == DIRECTION_UP && getHead().getY() >0){
            getHead().move(0, -1);
        } else if (direction == DIRECTION_DOWN && getHead().getY() < 31) {
            getHead().move(0,1);
        } else if (direction == DIRECTION_LEFT && getHead().getX() >0) {
            getHead().move(-1,0);
        } else if (direction == DIRECTION_RIGHT && getHead().getX() < 31) {
            getHead().move(1, 0);
        }

        if(shouldGrow){
            segments.add(newSegment);
        }
    }

    /**
     * Draw the snake to a grpahics context
     * @param ctx Graphic context to draw to
     * @param currentFrame The current frame number
     */
    public void draw(GraphicsContext ctx, long currentFrame){
        ctx.setFill(Color.GREEN);
        for(Point segment : segments){
            segment.draw(ctx, currentFrame);
        }
        ctx.setFill(Color.DARKGREEN);
        getHead().draw(ctx, currentFrame);
    }



}
