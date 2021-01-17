package IPLayers;

public class Application extends Layer {

    @Override
    void pack(String message) {
        System.out.println("messageAPP: " + message);
        nextLayer.pack(message);

    }

    @Override
    void unpack(String message) {
        System.out.println("messageAPP -- FULLY UNPACKED: " + message);

    }
}
