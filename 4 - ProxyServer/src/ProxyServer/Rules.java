package ProxyServer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rules {
    private Set<String> banned_urls = new HashSet<>();

    public Rules(String[] urlsP) {
        //banned_urls = new HashSet<>();
        banned_urls.addAll(Arrays.asList(urlsP));
    }
    public Rules(Rules r) {
        //banned_urls = new HashSet<>(r.banned_urls);
        banned_urls.addAll(r.banned_urls);
    }

    public boolean add(String urlP){
        return banned_urls.add(urlP);
    }
    public boolean remove(String urlP){
        return banned_urls.remove(urlP);
    }
    public boolean contains(String url){
        return banned_urls.contains(url);
    }


    public Rules clone(){
        //Rules RulesClone = new Rules(this);
        return new Rules(this);
    }

    public void print(){
        System.out.println("BANNED_URLS:");
        for(String url : banned_urls){
            System.out.println(url);
        }
    }
}
