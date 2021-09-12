package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Negozio
{
    private ArrayList<Videogame> catalogue = new ArrayList<>();

    public ArrayList<Videogame> getCatalogue() {
        return catalogue;
    }

    public void addGame()
    {
        Scanner scan =new Scanner(System.in);
        System.out.println("inserisci nome : ");
        String inputName = scan.next();
        System.out.println("inserisci prezzo :");
        double inputPrice = scan.nextDouble();
        System.out.print("inserisci quante copie vuoi inserire: ");
        int inputQuantity = scan.nextInt();
        catalogue.add(new Videogame(inputName,inputPrice,inputQuantity));
    }
    public void Buy(User u)
    {
        ArrayList<Videogame> toRemove = new ArrayList<>();
        for(Videogame v : u.GetCart().GetCarrello())
        {
            for(Videogame vg : catalogue)
            {
                if(v.equals(vg)&&u.getCredit()>u.GetCart().GetAmount())
                {
                    vg.setQuantity(vg.getQuantity()-1);
                    toRemove.add(vg);
                    u.SetCredit(u.getCredit()-u.GetCart().GetAmount());
                }
            }
        }
        for(Videogame v:toRemove)
        {
            if(v.getQuantity()<=0)
            {
                catalogue.remove(v);
            }
        }

    }
    public void ShowCatalogue()
    {
        for(Videogame v:catalogue)
        {
            System.out.println("titolo: "+v.getTitle()+" prezzo: "+v.getPrice()+" quantità in negozio: "+v.getQuantity());
        }
    }


}
