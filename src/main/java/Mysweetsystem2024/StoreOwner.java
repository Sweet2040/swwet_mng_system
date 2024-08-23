package Mysweetsystem2024;


public class StoreOwner extends User {
    private String storeName;
    private String storeAddress;
    private String phoneNumber;

    public StoreOwner(String username, String password, String email, String country, String storeName, String storeAddress, String phoneNumber) {
        super(username, password, country, email);
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.phoneNumber = phoneNumber;
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
