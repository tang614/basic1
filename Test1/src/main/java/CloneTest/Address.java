package CloneTest;

public class Address implements Cloneable{
    private String province;
    private int num;

    public Address() {
    }

    public Address(String province, int num) {
        this.province = province;
        this.num = num;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
