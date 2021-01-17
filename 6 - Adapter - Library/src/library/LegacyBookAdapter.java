package library;


public class LegacyBookAdapter implements Book  {
    private LegacyBook _legacyBook;

    public LegacyBookAdapter(LegacyBook legacyBook) {
        _legacyBook = legacyBook;
    }

    @Override
    public boolean isIt(String author, String title) {
        String legacyData = _legacyBook.getData();
        String myauthor = "";
        String mytitle = "";
        int dataID = 1; // 1 - Author,  2 - Title,  3 - Location

        for(int i = 0; i<legacyData.length(); i++){
            if(legacyData.charAt(i) == '|'){
                dataID++;
                continue;
            }
            if(dataID == 1)
                myauthor += legacyData.charAt(i);
            if(dataID == 2)
                mytitle += legacyData.charAt(i);
        }
        return myauthor.equals(author) && mytitle.equals(title);
    }

    @Override
    public int getLocation() {
        String legacyData = _legacyBook.getData();
        String myLocation_string = "";
        int separatorCounter = 0;
        for(int i = 0; i<legacyData.length(); i++){
            if(separatorCounter==2)
                myLocation_string += legacyData.charAt(i);
            if(legacyData.charAt(i) == '|')
                separatorCounter++;
        }
        int myLocation_int = Integer.valueOf(myLocation_string);
        return myLocation_int;
    }

    @Override
    public void print() {
        System.out.println(_legacyBook.getData());
    }
}
