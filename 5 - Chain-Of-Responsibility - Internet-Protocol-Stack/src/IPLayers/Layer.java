package IPLayers;

abstract class Layer {
    protected Layer nextLayer;
    protected Layer prevLayer;

    public void setNextLayer(Layer layer){
        nextLayer = layer;
    }
    public void setPrevLayer(Layer layer){
        prevLayer = layer;
    }
    abstract void pack(String message);
    abstract void unpack(String message);
}
