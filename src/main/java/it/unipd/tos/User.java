////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

public class User {
    String name;
    // dati nome
    String sname;
    // dati cognome
    int age;
    // dati età
    String id;
    // codice fiscale alfanumerico

    // classe per mettere tutto assieme
    public User(String n, String s, int a, String i) {
        this.name = n;
        this.sname = s;
        this.age = a;
        this.id = i;
    }

    // e ora tutti i get per i controlli
    public String getName() {
        return name;
    }

    public String getSurname() {
        return sname;
    }

    public int getAge() {
        return age;
    }

    public boolean getChild() {
        return age < 18;
    }

    public String getId() {
        return id;
    }
}
