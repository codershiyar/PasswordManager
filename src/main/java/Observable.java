public interface Observable {
    void setChanged();
    void addObserver(IObserver observer);
    void notifyObservers();
}
