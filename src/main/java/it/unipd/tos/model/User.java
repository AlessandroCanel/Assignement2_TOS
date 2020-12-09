////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class User {
    String name;
    // dati nome
    String sname;
    // dati cognome
    int age;
    // dati età

    // classe pubblica per mettere tutto assieme
    public User(String name, String sname, int age) {
        
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Nome vuoto");
        }
        if(sname.isEmpty()) {
            throw new IllegalArgumentException("Cognome vuoto");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Età non corretta");
        }
        
        this.name = name;
        this.sname = sname;
        this.age = age;
    }

    // e ora tutti i get per i controlli
    public String getName() {
        return name;
    }

    public String getSname() {
        return sname;
    }

    public int getAge() {
        return age;
    }

}
