
package arbolBinario3;

/**
 *
 * @param <T>
 */
public class NodoAB<T extends Comparable<?>> {
    private T contenido;
    private NodoAB<T> izq, der;
    
    public NodoAB(T contenido) {
        this.contenido = contenido;
        this.izq = null;
        this.der = null;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public NodoAB<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoAB<T> izq) {
        this.izq = izq;
    }

    public NodoAB<T> getDer() {
        return der;
    }

    public void setDer(NodoAB<T> der) {
        this.der = der;
    }
    
    
}