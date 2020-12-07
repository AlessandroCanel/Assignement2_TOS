////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

public class MenuItem {
    public enum items {
        Gelato, Bavanda, Budino
    }

    // enumerazione che rappresenta i tipi di elementi presenti nel menu
    // (Gelati,Budini e Bevande
    public String name;
    // nome del elemento (p.es. Pinguino, Coppa Nafta, Cola etc.)
    private double price;
    // price: prezzo unitario dell’elemento
    private items itemType;
    // itemType sceglie tr i tre

    // classe per mettere i dati assieme
    public MenuItem(String n, items t, double p) {
        this.itemType = t;
        this.name = n;
        this.price = p;
    }

    // ora i get per tornare tutto
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public items getType() {
        return itemType;
    }

}
