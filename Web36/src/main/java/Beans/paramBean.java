package Beans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ApplicationScoped;
import jakarta.inject.Inject;
import Server.Dot;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.System.nanoTime;
@ManagedBean
@ApplicationScoped
public class paramBean {
    private double x = 0;
    private double y = 0;
    private int r = 3;
    private boolean isValid(double x, double y, int r){
        if(!(-3 < x && x < 3)){
            return false;
        }
        if(!(y > -5 && y < 5)){
            return false;
        }
        if(!(1 <= r && r <= 5)){
            return false;
        }
        return true;
    }
    private void addDot(double x, double y, int r){
        if(!isValid(x, y, r)){
            return;
        }
        String result;
        long startTime = nanoTime();
        if((x<=0 && y>=0 && y<=2*x+r) || (x>=0 && y>=0 && x*x+y*y<=r*r) || (x>=0 && y<=0 && x<=r && y>=-r/2.0)){
            result = "hit";
        } else{
            result = "miss";
        }

    }
    public void addDotMouse(double x, double y, int r){
        setR(r);
        addDot(x, y, r);
    }
    public void addDotButton(){
        addDot(getX(), getY(), getR());
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getR() {
        return this.r;
    }
    public void setR(int r) {
        this.r = r;
    }

}
