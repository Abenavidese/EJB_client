package ups.edu.ejb.service;


import java.rmi.Remote;
import java.rmi.RemoteException;

import ups.edu.ejb.model.Producto;

public interface ProductoRegistrationRemote extends Remote {
    void register(Producto producto) throws RemoteException;
}
