package org.techelevator.snakes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A class to represent a 2D point
 */
public class Point {
    private int x;
    private int y;


    /**
     * Create a new point at the specified coordinates
     *
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new point at the specified coordinates
     *
     * @param other The point to copy the coordinates from
     */
    public Point(Point other){
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Set the x coordinate of the point
     *
     * @return The x coordinate
     */
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set the y coordinate of the point
     *
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public boolean equals(Point other){
        return this.x == other.x && this.y == other.y;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }


    public void copyCoordinates(Point other){
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Draw the point to the specified graphis context
     *
     * @param ctx The graphics context to draw to
     */
    public void draw(GraphicsContext ctx, long currentFrame){
        ctx.fillRect(x *25, y *25, 25, 25);
    }
}
