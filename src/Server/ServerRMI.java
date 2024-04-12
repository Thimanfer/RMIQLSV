package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Service.KhoahocRMIServiceImpl;
import Service.LophocRMIServiceImpl;
import Service.SinhvienRMIServiceImpl;
import Service.ThongkeRMIServiceImpl;

public class ServerRMI {
	public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("SinhvienRMIService", new SinhvienRMIServiceImpl());
            registry.rebind("KhoahocRMIService", new KhoahocRMIServiceImpl());
            registry.rebind("LophocRMIService", new LophocRMIServiceImpl());
            registry.rebind("ThongkeRMIService", new ThongkeRMIServiceImpl());
            registry.rebind("", registry);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
