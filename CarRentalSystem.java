import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarRentalSystem {

    // ADD CAR
    public void addcar(String name){
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO cars(name, available) VALUES(?, true)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("Car added to database");

        }catch(Exception e){
            System.out.println("Error adding car");
        }
    }

    // VIEW CARS
    public void viewcar(){
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM cars WHERE available = true";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("Available cars:");
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }

        }catch(Exception e){
            System.out.println("Error fetching cars");
        }
    }

    // RENT CAR
    public void rentcar(String name){
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE cars SET available=false WHERE name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Car rented successfully");
            }else{
                System.out.println("Car not available");
            }

        }catch(Exception e){
            System.out.println("Error renting car");
        }
    }

    // RETURN CAR
    public void returncar(String name){
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE cars SET available=true WHERE name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();

            System.out.println("Car returned");

        }catch(Exception e){
            System.out.println("Error returning car");
        }
    }
}
