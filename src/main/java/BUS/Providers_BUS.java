package BUS;

import java.util.List;

import DAO.Providers_DAO;
import Entitys.Providers;

public class Providers_BUS {
	Providers provider = new Providers();
	Providers_DAO provider_DAO = new Providers_DAO();
	
    public void addProvider(String name,String phone,String address){
        	
        	provider.setName(name);
        	provider.setPhone(phone);
        	provider.setAddress(address);
            provider_DAO.addProvider(provider);
    }
    
    public void updateProvider(int idProvider, String name,String phone,String address){
    	provider.setIdProvider(idProvider);
    	provider.setName(name);
    	provider.setPhone(phone);
    	provider.setAddress(address);
        provider_DAO.updateProvider(provider);
    }
    
    public void deleteProviderById(int id) {
    	provider_DAO.deleteProviderById(id);
    }
    
    public List<Providers> listProviders() {
    	return provider_DAO.getAllProvider();
    }
    public Providers searchProvidersById(int id) {
    	return provider_DAO.getProviderById(id);
    }

}
