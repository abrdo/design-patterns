package library;

public class LegacyBook{
    private String _data;
    LegacyBook(String author, String title, int location){
        _data = author + '|' + title + '|' + String.valueOf(location);
    }

    public String getData() {
        return _data;
    }
}
