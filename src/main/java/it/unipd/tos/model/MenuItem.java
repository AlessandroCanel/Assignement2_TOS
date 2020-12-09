////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum items {
        gelato, bevanda, budino
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
    public MenuItem(String name, items itemType, double price) {
        
        if (name.contains(" ")) {
            throw new IllegalArgumentException("Nome non valido");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Prezzo non valido");
        }   
        if (itemType == null) {
            throw new IllegalArgumentException("Tipo non valido");
        }  
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Nome vuoto");
        }
        
        this.itemType = itemType;
        this.name = name;
        this.price = price;
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
