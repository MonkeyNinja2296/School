import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UpdateData {
    public static int updateStudent(int id, String name, int age, int grade) {
        var sql = "UPDATE students SET stu_name = ?, age = ?, grade_level = ? WHERE stu_id = ?";
        int affectedRows = 0;
        try (var conn = DB.connect();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, grade);
            pstmt.setInt(4, id);

            affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }
    public static int updateTeacher(int id, String name, String subject, int yearsOfExperience, String department) {
        var sql = "UPDATE teachers SET teacher_name = ?, subject_taught = ?, years_of_experience = ?, department = ? WHERE teacher_id = ?";
        int affectedRows = 0;
        try (var conn = DB.connect();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, subject);
            pstmt.setInt(3, yearsOfExperience);
            pstmt.setString(4, department);
            pstmt.setInt(5, id);


            affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }
// ...
}