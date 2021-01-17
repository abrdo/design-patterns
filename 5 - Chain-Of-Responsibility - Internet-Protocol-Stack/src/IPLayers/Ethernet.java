package IPLayers;

public class Ethernet extends Layer {
    @Override
    void pack(String message) {
        message = "Eth///" + message;
        System.out.println("messageETH -- FULLY PACKED: " + message);
        System.out.println("----------- Now let's unpack it! ------------");

        this.unpack(message);

    }

    @Override
    void unpack(String message) {
        String message2 = "";
        for(int i = 6; i<message.length(); i++)
            message2 += message.charAt(i);

        System.out.println("messageETH: " + message2);
        prevLayer.unpack(message2);

    }
}
