package IPLayers;

public class TCP extends Layer {
    @Override
    void pack(String message) {
        message = "TCP///" + message;
        System.out.println("messageTCP: " + message);
        nextLayer.pack(message);

    }

    @Override
    void unpack(String message) {
        String message2 = "";
        for(int i = 6; i<message.length(); i++)
            message2 += message.charAt(i);
        System.out.println("messageTCP: " + message2);
        prevLayer.unpack(message2);

    }
}
