package BUS;

import java.util.List;

import DAO.Providers_DAO;
import Entitys.Providers;

public class Providers_BUS {
	Providers_DAO provider_DAO = new Providers_DAO();
	Providers provider = new Providers();
	
    public void addProvider(String name,String phone,String address){
        	
        	provider.setName(name);
        	provider.setPhone(phone);
        	provider.setAddress(address);
            provider_DAO.addProvider(provider);
    }
    
    public void updateProvider(String name,String phone,String address){
    	
    	provider.setName(name);
    	provider.setPhone(phone);
    	provider.setAddress(address);
        provider_DAO.updateProvider(provider);
    }
    
    public List<Providers> showProviders() {
    	return provider_DAO.getAllProvider();
    }

}
