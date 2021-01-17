package IPLayers;

public class Encryption extends Layer {
    String key = "as98sdf7de";
    @Override
    void pack(String s) {

        //////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            sb.append((char)(s.charAt(i) ^ key.charAt(i % key.length())));
        String result = sb.toString();
        //////////////////////////////////////////////

        System.out.println("messageENC: " + result);
        nextLayer.pack(result);

    }

    @Override
    void unpack(String s) {

        //////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            sb.append((char)(s.charAt(i) ^ key.charAt(i % key.length())));
        String result = sb.toString();
        //////////////////////////////////////////////

        System.out.println("messageENC: " + result);
        prevLayer.unpack(result);

    }
}
