package com.company;

import java.util.ArrayList;

public class User
{
    private String name;
    private double credit;

    private Cart cart = new Cart();

    public Cart GetCart()
    {
        return cart;
    }
    public User(String name, double credit)
    {
        this.name = name;
        this.credit = credit;

    }
    public String getName()
    {
        return name;
    }

    public double getCredit()
    {
        return credit;
    }

    public void SetCredit(double credit)
    {
        this.credit = credit;
    }
}
