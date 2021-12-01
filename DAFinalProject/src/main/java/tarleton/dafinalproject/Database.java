package tarleton.dafinalproject;
import org.mariadb.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Joe Meier
 */
public class Database {
    private static final String endpoint = "iss.cpstbqrsbadl.us-west-1.rds.amazonaws.com";
    private static final String port = "3306";
    private static final String database = "iss";
    private static final String user = "admin";
    private static final String pass = "is!12345";
    private static final String access = "jdbc:mariadb://" + endpoint + ":" + port + "/" + database;
    
    public static Account login(String username){   
        String query = "SELECT * FROM iss.account WHERE username = ?";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try (            
            Connection conn = DriverManager.getConnection(access, user, pass);
            PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Account acc = new Account(
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("fname"),
                rs.getString("lname"),
                rs.getString("email"),
                rs.getString("tier"));
            return acc;
        } catch (SQLException ex) {
            System.out.println(ex);
        }  catch (Exception ex) {  
            System.out.println(ex);
        }
        return null;
    }
    
    public static void insert(Account acc){   
        String query = "INSERT INTO iss.account (username,password,fname,lname,email,tier) "
                + "VALUES (?,?,?,?,?,?);";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try (            
            Connection conn = DriverManager.getConnection(access, user, pass);
            PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getFname());
            ps.setString(4, acc.getLname());
            ps.setString(5, acc.getEmail());
            ps.setString(6, acc.getTier());
            ResultSet rs = ps.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        }  catch (Exception ex) {  
            System.out.println(ex);
        }
    }
    
    public static boolean validUser(String username){
        String query = "SELECT * FROM iss.account WHERE username = ?;";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }      
        try (            
            Connection conn = DriverManager.getConnection(access, user, pass);
            PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return(rs.next());
        } catch (SQLException ex) {
            System.out.println(ex);
        }  catch (Exception ex) {  
            System.out.println(ex);
        }
        return false;
    }
    
    public static void update(String username, Account acc){   
        String query = "UPDATE iss.account SET password = ?, fname = ?,"
                + "lname = ?, email = ?, tier = ? WHERE username = ?";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try (            
            Connection conn = DriverManager.getConnection(access, user, pass);
            PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(6, username);
            ps.setString(1, acc.getPassword());
            ps.setString(2, acc.getFname());
            ps.setString(3, acc.getLname());
            ps.setString(4, acc.getEmail());
            ps.setString(5, acc.getTier());
            ResultSet rs = ps.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        }  catch (Exception ex) {  
            System.out.println(ex);
        }
    }
    
    public static Data[] readData(String username){
        String query = "SELECT * FROM iss.data WHERE username = ? ORDER BY DateTime DESC LIMIT 10";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try (            
            Connection conn = DriverManager.getConnection(access, user, pass);
            PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.last();
            Data[] dataSet = new Data[rs.getRow()];
            rs.first(); 
            for(int i = 0; i < dataSet.length; i++){
                    dataSet[i] = new Data(
                        rs.getString("Id"),
                        rs.getString("Humidity"),
                        rs.getString("Temperature"),
                        rs.getString("HeatIndex"),
                        rs.getString("SensorOne"),
                        rs.getString("SensorTwo"),
                        rs.getString("DateTime"));
                    rs.next();            
            }            
            return dataSet;
        } catch (SQLException ex) {
            System.out.println(ex);
        }  catch (Exception ex) {  
            System.out.println(ex);
        }
        return null;
    }
}
