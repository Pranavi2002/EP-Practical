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
public static int StudentFeedback(FeedbackBean fb) throws SQLException, ClassNotFoundException{
	Connection conn = DBUtil.DBConnection();
	PreparedStatement ps = conn.prepareStatement("insert into fback values(?,?,?,?,?,?,?)");
	ps.setString(1,fb.getEmail());
	ps.setString(2,fb.getQ1());
	ps.setString(3,fb.getQ2());
	ps.setString(4,fb.getQ3());
	ps.setString(5,fb.getQ4());
	ps.setString(6,fb.getQ5());
	ps.setString(7,fb.getRemark());
    int i = ps.executeUpdate();
    return i;
}
}
