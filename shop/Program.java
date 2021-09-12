package com.company;

import java.util.Scanner;

public class Program
{
    Negozio negozio;
    User user;
    Scanner scan;
    public Program()
    {
        negozio = new Negozio();
         user = new User("David",1000);
         scan = new Scanner(System.in);
    }
    public void play()
    {
        System.out.println("Salve cliente, benvenuto nel nostro negozio di videogame ");
        AppFlow();
    }
    public void addToCart()
    {
        String name = scan.next();
        for(Videogame v : negozio.getCatalogue())
        {
            if(v.getTitle().equals(name))
            {
                user.GetCart().GetCarrello().add(v);
            }
        }
    }
    public void AppFlow()
    {
        String input;
        do {
            System.out.println("digita ac per inserire un gioco all'interno del catalogo,");
            System.out.println("premi a per aggiungere un gioco al tuo carrello, ");
            System.out.println("premi c per mostrare il conto,premi s per mostrare il tuo saldo,premi e per uscire,premi b per comprare");
            negozio.ShowCatalogue();
             input = scan.next();
            switch (input) {
                case "ac":
                    negozio.addGame();
                    break;
                case "a":
                    addToCart();
                    break;
                case "c":
                    System.out.printf("totale carrello: %.2f$\n", user.GetCart().GetAmount());
                    break;
                case "s":
                    System.out.printf("saldo disponibile: %.2f$\n", user.getCredit());
                    break;
                case "e":
                    System.out.println("uscita in corso");
                    break;
                case "b":
                    negozio.Buy(user);
                    break;
                default:
                    System.out.println("opzione non esistente");
                    break;
            }
        }while(input!="e");
    }
}
