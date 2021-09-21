package com.company;

public class Videogame
{
    private String title;
    private double price;
    private double quantity;
    private static int previousid = -1;
    private int id;


    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Videogame(String title, double price, double quantity) {
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

    public double getQuantity(){ return quantity; }

    public double getPrice()

    {
        return price;
    }
    public int getId(){return id;}
}
