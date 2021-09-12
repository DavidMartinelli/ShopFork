package com.company;
import java.util.ArrayList;

public class Cart
{
    private ArrayList<Videogame> carrello = new ArrayList<>();
    private double amount;
    public  ArrayList<Videogame>  GetCarrello()
    {
        return carrello;
    }

    public void addGame(Videogame...games)
    {
        for(Videogame v : games)
        {
            carrello.add(v);
        }
    }

    public double GetAmount()
    {
         amount = 0;
        for (Videogame v: carrello)
        {
            amount += v.getPrice();
        }
        return amount;
    }

    public void ShowCart()
    {
        for(Videogame v: carrello)
        {
            System.out.println(v.getTitle()+" "+v.getPrice());
        }
    }

}
