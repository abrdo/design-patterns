package ProxyServer;

public class ProxyAccess implements InternetAccess {
    @Override
    public void request(String url, Rules rules){
        InternetAccess wwwaccess = WWWAccess.getInstance();
        if(rules.contains(url))
            System.out.println("acces to "+url+" blocked by proxy");
        else
            wwwaccess.request(url, rules);

    }
}
