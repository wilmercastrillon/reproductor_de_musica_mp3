package reproductor_de_musica;

public class lista {

    nodo first;
    nodo last;
    int tam;

    public lista() {
        first = last = null;
        tam = 0;
    }

    public boolean IsEmpety() {
        return first == null;
    }

    public void clear() {
        while (!IsEmpety()) {
            borrar(first);
        }
    }

    public void insertar(String nom, String dir) {
        nodo nuevo = new nodo(nom, dir);
        if (IsEmpety()) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.anterior = last;
            last.siguiente = nuevo;
            last = nuevo;
        }
        tam++;
    }

    public int index(nodo b) {
        nodo aux = first;
        int con = 0;

        while (aux != null) {
            if (aux == b) {
                return con;
            }
            aux = aux.siguiente;
            con++;
        }
        return -1;
    }
    
    public nodo get_cancion(int index){
        if (index < 0 || index >= tam) {
            return null;
        }
        
        int n = 0;
        nodo aux = first;
        while (n != index) {            
            aux = aux.siguiente;
            n++;
        }
        
        return aux;
    }

    public void borrar(nodo b) {
        if (b == first) {
            if (tam == 1) {
                first = null;
                tam--;
                return;
            }
            first.siguiente.anterior = null;
            first = first.siguiente;
            tam--;
            return;
        }
        tam--;
        if (b == last) {
            last.anterior.siguiente = null;
            last = last.anterior;
            return;
        }
        b.siguiente.anterior = b.anterior;
        b.siguiente.anterior.siguiente = b.siguiente;
    }
    
    public boolean buscar(String nombre, String ruta){
        nodo aux = first;

        while (aux != null) {
            if (aux.nombre.equals(nombre) && aux.direccion.equals(ruta)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }
}
