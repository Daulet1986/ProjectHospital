public class Patient extends Person{
    private String UIN;
    private String adress;
    private int insurance_amount;
    public Patient(){
        super();
    }

    public Patient(String name, String surname, int age, String UIN, String phone_num, String adress, int insurance_amount){
        setName(name);
        setSurname(surname);
        setAge(age);
        setUIN(UIN);
        setAdress(adress);
        setInsurance(insurance_amount);
    }

    ///Getters
    public String getUIN(){
        return UIN;
    }
    public String getAdress(){
        return adress;
    }
    public int getInsurance(){
        return insurance_amount;
    }
    ///Setters
    public void setUIN(String UIN){
        this.UIN = UIN;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    public void setInsurance(int insurance_amount){
        this.insurance_amount = insurance_amount;
    }

}