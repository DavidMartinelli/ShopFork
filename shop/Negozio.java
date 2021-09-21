package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Negozio
{
    private ArrayList<Videogame> catalogue = new ArrayList<>();
    private Scanner scan =new Scanner(System.in);

    public ArrayList<Videogame> getCatalogue() {
        return catalogue;
    }
    private double ScanNum(String num)
    {
        double numToRet = 0;
        if(isNumCorrect(num))
        {
            numToRet = Double.parseDouble(num);
        }
        else
        {
            System.out.println("inserire un numero corretto ");
            ScanNum(scan.next());
        }
        return numToRet;
    }
    private boolean isNumCorrect(String num)
    {
        boolean ret = true;
        double input = -1;
        try
        {
             input = Double.parseDouble(num);
        }
        catch(NumberFormatException e)
        {

            ret = false;
        }
        finally
        {
            if(input<0)ret = false;
        }
        return ret;
    }
    public void addGame()
    {

        System.out.println("inserisci nome : ");
        String inputName = scan.next();
        System.out.println("inserisci prezzo :");
        double inputPrice = ScanNum(scan.next());
        System.out.print("inserisci quante copie vuoi inserire: ");
        double inputQuantity = ScanNum(scan.next());
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
