public class Student {
    int id;
    String name;
    int grade;
    int age;
    String gender;


    public Student(int id, String name, int grade, int age, String gender ){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.gender = gender;
    }
    public Student( String name, int grade, int age, String gender ){

        this.name = name;
        this.grade = grade;
        this.age = age;
        this.gender = gender;
    }
    public int getId(){
        return id;
    };
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() { return this.gender; }
    public void setGender(String gender) { this.gender = gender; }
    public int getGrade(){
        return this.grade;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Age: " + grade + ", Name: " + name + ", Grade: " + age + ", Gender: " + gender;
    }
}
