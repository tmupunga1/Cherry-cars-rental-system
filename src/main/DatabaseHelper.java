package main;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/vehicledb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

   
    public static ArrayList<Vehicle> fetchVehicles() {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicle";

        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                int id = rs.getInt("vehicleid");
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                String reg = rs.getString("reg_num");
                String type = rs.getString("type");

                if (type.equals("Car")) {

                    vehicles.add(
                        fetchCar(conn, id, make, model, year, reg)
                    );

                } else if (type.equals("Motorbike")) {

                    vehicles.add(
                        fetchMotorBike(conn, id, make, model, year, reg)
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return vehicles;
    }

  
    private static Car fetchCar(
        Connection conn,
        int id,
        String make,
        String model,
        int year,
        String reg
    ) throws SQLException {

        String sql =
            "SELECT num_doors, battery_range, fuel_type, category " +
            "FROM car WHERE vehicleid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    int doors = rs.getInt("num_doors");

                    String category = rs.getString("category");

                    if (category.equals("Electric")) {

                        int range = rs.getInt("battery_range");

                        System.out.println("Creating Electric Car...");

                        return new ElectricCar(
                            make,
                            model,
                            year,
                            reg,
                            doors,
                            range
                        );

                    } else {

                        String fuel = rs.getString("fuel_type");

                        return new NonElectricCar(
                            make,
                            model,
                            year,
                            reg,
                            doors,
                            fuel
                        );
                    }
                }
            }
        }

        return null;
    }

    
    private static MotorBike fetchMotorBike(
        Connection conn,
        int id,
        String make,
        String model,
        int year,
        String reg
    ) throws SQLException {

        String sql =
            "SELECT has_sidecar FROM motorbike WHERE vehicleid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    boolean sidecar = rs.getBoolean("has_sidecar");

                    return new MotorBike(
                        make,
                        model,
                        year,
                        reg,
                        sidecar
                    );
                }
            }
        }

        return null;
    }
}