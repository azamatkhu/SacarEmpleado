import java.sql.*;

public class MainSacarEmpleado {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "RIBERA",
                    "ribera"
            );

            System.out.println("Conectado!");

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM EMPLEADO WHERE MOD(ID, 2) != 0";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nombre") + " " + resultSet.getDouble("salario"));
            }

            System.out.println("Conectado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}