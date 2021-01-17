package ProxyServer;

public class Person {
    private String name; // not necessary. Just for fancy prints.
    private Rules rules;

    public String getName() {return name;}
    //public Rules getRules() {return rules;}


    public void add(String url){
        if(rules.add(url))
            System.out.println(name + " added '"+url+"' to their rules to the banned_urls list");
        else
            System.out.println(name + " already had got '"+url+"' in the banned_urls list, so no addition happend");
    }
    public void remove(String url){
        if(rules.remove(url))
            System.out.println(name + " removed '"+url+"' from their rules from the banned_urls list");
        else
            System.out.println(name + " had not got '"+url+"' in the banned_urls list, so no removment happend");
    }
    //public boolean contains(String url){return rules.contains(url);}


    public Person(String nameP, Rules RulesPrototype){
        name = nameP;
        rules = RulesPrototype.clone();
    }

    public void send_request(String url, InternetAccess intacc){
        intacc.request(url, rules);
    }

    public void print(){
        System.out.println(name + ":  -----------");
        rules.print();
    }


}
