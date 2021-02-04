import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
public static int StudentInsertion(RegisterBean rb) throws SQLException, ClassNotFoundException {
	Connection conn = DBUtil.DBConnection();
	PreparedStatement ps = conn.prepareStatement("insert into registration values(?,?,?,?,?,?)");
	ps.setInt(1, rb.getRegno());
    ps.setString(2, rb.getName());
    ps.setString(3, rb.getEmail());
    ps.setString(4, rb.getPassword());
    ps.setInt(5, rb.getYear());
    ps.setString(6, rb.getSec());
    if(rb.getPassword().length() < 8) {
      return 0;
    }
    int i = ps.executeUpdate();
    return i;
}
public static String StudentLogin(RegisterBean rb) throws SQLException, ClassNotFoundException {
	Connection conn = DBUtil.DBConnection();
	PreparedStatement ps = conn.prepareStatement("select email, password from registration where email=? and password=?");
	ps.setString(1, rb.getEmail());
	ps.setString(2, rb.getPassword());
	ResultSet i = ps.executeQuery();
	String email="", password="";
	while(i.next()) {
		email = i.getString(1);
		password = i.getString(2);
	}
	return email;
}
public static int StudentFeedback(RegisterBean rb) throws SQLException, ClassNotFoundException{
	Connection conn = DBUtil.DBConnection();
	PreparedStatement ps = conn.prepareStatement("insert into fback values(?,?)");
	ps.setString(1,rb.getEmail());
    ps.setString(2,rb.getFeedback());
    int i = ps.executeUpdate();
    return i;
}
}
