package IPLayers;

public class IPLayesDemo {

    public static void main(String[] args) {
	    Layer App = new Application();
	    Layer Enc = new Encryption();
	    Layer Tcp = new TCP();
	    Layer Eth = new Ethernet();

	    App.setNextLayer(Enc);
	    Enc.setNextLayer(Tcp);
	    Tcp.setNextLayer(Eth);

		Enc.setPrevLayer(App);
		Tcp.setPrevLayer(Enc);
	    Eth.setPrevLayer(Tcp);

	    App.pack("That's what I wanted to say.");




    }
}
