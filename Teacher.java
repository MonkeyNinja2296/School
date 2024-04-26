public class Teacher {
    int id;
    String name;
    String subject;
    int yearsOfExperience;
    String department;

    public Teacher(String name, String subject, int yearsOfExperience, String department ){
        this.name = name;
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
    }
    public Teacher(int id, String name, String subject, int yearsOfExperience, String department ){
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public int getYearsOfExperience() { return this.yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
    public String getDepartment(){
        return this.department;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Subject: " + subject + ", Years Of Experience: " + yearsOfExperience + ", Department: " + department;
    }
}
