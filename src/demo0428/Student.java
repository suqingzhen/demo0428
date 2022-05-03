package demo0428;

public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String birthday;
    private  int classid;
  private String cname;

    public Student() {
    }

    public Student(int id, String name, String sex, int age, String birthday, int classid, String cname) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.classid = classid;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", classid=" + classid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
