package db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private String dbname = "carsdb";

    public void createDataBase(){
        try {
            Connection connection = ConnectionManager.getConnection();
            String query = "create database carsdb;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        }
        catch(Exception e) { System.out.println("Exception : " + e.getMessage()); }
    }

    public void deleteDataBase(){
        try {
            Connection connection = ConnectionManager.getConnection();
            String query = "drop database if exists carsdb;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        }
        catch(Exception e) { System.out.println("Exception : " + e.getMessage()); }
    }

    public void createTable(){
        try {
            Connection connection = ConnectionManager.getConnection("/" + dbname);
            String query =
                      "create table car ("
                    + "id bigint not null primary key auto_increment,"
                    + "company varchar(64) not null,"
                    + "model varchar(64) not null,"
                    + "price integer not null);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        }
        catch(Exception e) { System.out.println("Exception: " + e.getMessage()); }
    }

    public List<Car> selectAll(){
        List<Car> resultList = new ArrayList<Car>();
        try {
            Connection connection = ConnectionManager.getConnection("/" + dbname);
            String query = "select * from car;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                long id  = rs.getLong("id");
                String company = rs.getString("company");
                String model = rs.getString("model");
                int price = rs.getInt("price");
                resultList.add(new Car(id, company, model, price));
            }
            rs.close();
        }
        catch(Exception e) { System.out.println("Exception : " + e.getMessage()); }
        return resultList;
    }

    public List<Car> selectCarsByField(String field, String value){
        List<Car> resultList = new ArrayList<Car>();
        try {
            Connection connection = ConnectionManager.getConnection("/" + dbname);
            String query = String.format("select * from car where %s = \"%s\";", field, value);
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                long id  = rs.getLong("id");
                String company = rs.getString("company");
                String model = rs.getString("model");
                int price = rs.getInt("price");
                resultList.add(new Car(id, company, model, price));
            }
            rs.close();
        }
        catch(Exception e) { System.out.println("Exception : " + e.getMessage()); }
        return resultList;
    }

    public void createCar(Car car){
        String query = "insert into car (id, company, model, price) values (?, ?, ?, ?);";
        try {
            Connection connection = ConnectionManager.getConnection("/" + dbname);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, car.getId());
            statement.setString(2, car.getCompany());
            statement.setString(3, car.getModel());
            statement.setInt(4, car.getPrice());
            statement.executeUpdate();
        }
        catch(Exception e) { System.out.println("Exception : " + e.getMessage()); }
    }

    public void updateCar(Car car){
        String query = "update car set company = ?, model = ?, price = ? where id = ?;";
        try {
            Connection connection = ConnectionManager.getConnection("/" + dbname);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, car.getCompany());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getPrice());
            statement.setLong(4, car.getId());
            statement.executeUpdate();
        }
        catch(Exception e) { System.out.println("Exception : " + e.getMessage()); }
    }

    public void deleteCar(Car car){
        String query = "delete from car where id = ? and company = ? and model = ? and price = ?;";
        try {
            Connection connection = ConnectionManager.getConnection("/" + dbname);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, car.getId());
            statement.setString(2, car.getCompany());
            statement.setString(3, car.getModel());
            statement.setInt(4, car.getPrice());
            statement.executeUpdate();
        }
        catch(Exception e) { System.out.println("Exception : " + e.getMessage()); }
    }
}