package db;

public class Car{
    private long id;
    private String company;
    private String model;
    private int price;

    public Car(long id, String company, String model, int price) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof Car) {
            Car car = (Car)object;
            return this.id == car.getId()
                    && this.company.equals(car.getCompany())
                    && this.model.equals(car.getModel())
                    && this.price == car.getPrice();
        }
        return false;
    }
}
