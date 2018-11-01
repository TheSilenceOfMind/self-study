package interfaces;

public interface Base {
    void base();
}

interface Der1 extends Base {
    void der();
}

interface Der2 extends Base {
    void der();
}

interface DerDer extends Der1, Der2 {
    
}
