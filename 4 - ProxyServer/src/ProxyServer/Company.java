package ProxyServer;

public class Company {

    public static void main(String[] args) {

        // Rules test ////////////////////////////////////////////////////
        Rules r = new Rules(new String[] {"kes","villa","ollo"});
        /*
        r.print();
        r.add("kanal");
        r.add("kiskanal");
        r.print();
        r.add("kiskanal");
        r.remove("ollo");
        r.remove("ollo");
        r.print();
        */
        /*
        Rules r2 = r.clone();
        r2.print();
        String s = "villa";
        System.out.println( s +": "+ r2.contains(s));
        s = "sdfadsfasdf";
        System.out.println( s +": "+ r2.contains(s));
        */

        // Person test ////////////////////////////////////////////////////
        // Rule Prototypes:
        Rules Employee = new Rules(new String[] {"facebook.com", "youtube.com"});
        Rules Manager = new Rules(new String[] {"facebook.com"});
        Rules Boss = new Rules(new String[] {});

        Person emp1 = new Person("Employee_to_Manager___plus_Google_ban", Employee);
        emp1.print();
        emp1.add("google.com");
        emp1.add("google.com");
        emp1.remove("youtube.com");
        emp1.remove("youtube.com");
        emp1.print();
        System.out.println("");

        Person man1 = new Person("Manager_to_Boss", Manager);
        man1.remove("facebook.com");

        Person boss1 = new Person("Boss", Boss);



        // InternetAcess test ////////////////////////////////////////////////////
        InternetAccess ProxyServer = new ProxyAccess();
        System.out.println("\nWeb access attemps: =======================");

        System.out.println("\n" + emp1.getName());
        emp1.send_request("messenger.com", ProxyServer);
        emp1.send_request("youtube.com", ProxyServer);
        emp1.send_request("google.com", ProxyServer);

        System.out.println("\n" + man1.getName());
        man1.send_request("facebook.com", ProxyServer);

        System.out.println("\n" + boss1.getName());
        boss1.send_request("facebook.com", ProxyServer);
    }
}
