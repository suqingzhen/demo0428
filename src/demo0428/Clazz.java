package demo0428;

public class Clazz {
    private int cid;
    private String name;

    public Clazz() {
    }

    public Clazz(int cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }
}
