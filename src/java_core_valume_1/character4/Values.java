package java_core_valume_1.character4;

public class Values {
    private int x;
    private int y;
    private int mul;
    private  int add;

    public Values(int x,int y){
        this.x=x;
        this.y=y;
        mul=this.x*this.y;
        add=this.x+this.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMul() {
        return mul;
    }

    public void setMul(int mul) {
        this.mul = mul;
    }

    public int getAdd() {
        return add;
    }

    public void setAdd(int add) {
        this.add = add;
    }
}
