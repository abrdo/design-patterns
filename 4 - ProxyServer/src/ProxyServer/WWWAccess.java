package ProxyServer;

public class WWWAccess implements InternetAccess { // World Wide Web access, singleton

    public static WWWAccess _instance = null;

    private WWWAccess(){}

    public static WWWAccess getInstance(){
        if(_instance == null)
            _instance = new WWWAccess();
        return _instance;
    }


    @Override
    public void request(String url, Rules rules){
        System.out.println(url + " loaded");
    }
}
