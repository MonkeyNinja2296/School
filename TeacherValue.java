import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class TeacherValue {

    public static int add(List<Teacher> teachers) {
        var sql = "INSERT INTO teachers (name, subject_taught, years_of_experience, department) values (?,?,?,?)";
        try (var conn = DB.connect();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
// bind the values
            for(var i: teachers) {
                pstmt.setString(1, i.getName());
                pstmt.setString(2, i.getSubject());
                pstmt.setInt(3, i.getYearsOfExperience());
                pstmt.setString(4, i.getDepartment());

// execute the INSERT statement and get the inserted id
                int insertedRow = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
