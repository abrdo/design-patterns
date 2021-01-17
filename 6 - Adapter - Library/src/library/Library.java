package library;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Library {
    private static Set<LegacyBook> _LegacyDatabase;
    private static Set<ModernBook> _ModernDatabase;
    private static Set<Book> _UnitedDatabase;

    private static void initDatabases(){
        _ModernDatabase = new HashSet<>(Arrays.asList(
                new ModernBook("Arany","Toldi", 1),
                new ModernBook("Arany","Toldi", 2),
                new ModernBook("Wass Albert", "Tizenharom almafa", 4)
        ));
        _LegacyDatabase = new HashSet<>(Arrays.asList(
                new LegacyBook("Arany","Toldi", 101),
                new LegacyBook("Arany","Balladak", 103),
                new LegacyBook("Madach", "Ember tragediaja", 105)
        ));

        // United Database
        _UnitedDatabase = new HashSet<>();
        _UnitedDatabase.addAll(_ModernDatabase);

        for(LegacyBook legacyBook : _LegacyDatabase){
            Book adapter = new LegacyBookAdapter(legacyBook);
            _UnitedDatabase.add(adapter);
        }

    }

    private static void printUnitedDatabase(){
        System.out.println("\n--- United Database: ---");
        for (Book b : _UnitedDatabase) {
            b.print();
        }
        System.out.println("\n");
    }

    private static void printLocations(String searchedAuthor, String searchedTitle) {
        System.out.println("\n-- Searching ["+searchedAuthor+", "+searchedTitle+"] ---");
        boolean found = false;
        for(Book book : _UnitedDatabase){
            if(book.isIt(searchedAuthor, searchedTitle)){
                System.out.println("Location: " + book.getLocation());
                found = true;
            }
        }
        if(!found) System.out.println("not found.");
    }


    public static void main(String[] args){
        initDatabases();
        printUnitedDatabase();

        printLocations("Arany", "Toldi");
        printLocations("Wass Albert", "Tizenharom almafa");
        printLocations("Madach", "Ember tragediaja");

    }
}
