package com.company;

public class Videogame
{
    private String title;
    private double price;
    private int quantity;
    private static int previousid = -1;
    private int id;


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Videogame(String title, double price, int quantity) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        id = previousid +1;
        previousid += 1;
    }
    public String getTitle()
    {
        return title;
    }

    public int getQuantity(){ return quantity; }

    public double getPrice()

    {
        return price;
    }
    public int getId(){return id;}
}
