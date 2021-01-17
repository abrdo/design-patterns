package library;

public class ModernBook implements Book{
    private String _author;
    private String _title;
    private int _location;

    ModernBook(String author, String title, int location){
        _author = author;
        _title = title;
        _location = location;
    }

    @Override
    public boolean isIt(String author, String title) {
        return _author.equals(author) && _title.equals(title);
    }

    @Override
    public int getLocation() {
        return _location;
    }

    @Override
    public void print() {
        System.out.println("author: '"+_author+"', title: '"+_title+"', Location: "+_location+"");
    }
}
