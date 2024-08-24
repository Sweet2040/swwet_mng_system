package Mysweetsystem2024;


public class StoreOwner extends User {
    private String storeName;
    private String storeAddress;
    
    public StoreOwner(String username, String password, String email, String country, String storeName, String storeAddress) {
        super(username, password, country, email);
        this.storeName = storeName;
        this.storeAddress = storeAddress;
       
    }

    
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    

   
}
