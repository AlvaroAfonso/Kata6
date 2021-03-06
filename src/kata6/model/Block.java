package kata6.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author alvaroafonsolopez
 */
public class Block {
    public static final int MAX = 7;
    private int x = 3;
    private int y = 3;
    private Timer timer;
    private List<Observer> observers;
    
    public Block(){
        this.observers = new ArrayList<>();
        this.timer = new Timer();
        this.timer.schedule(task(), 100, 100);
    }
    
    public int x(){
        return x;
    }
    
    public int y(){
        return y;
    }
    
    public void left(){
        if (x==1) return;
        x--;
        changed();
    }
    
    public void right(){
        if (x == MAX) return;
        x++;
        changed();
    }
    
     public void down(){
        if (y == MAX) return;
        y++;
        changed();
    }
    
    public void up(){
        if (y == 1) return;
        y--;
        changed();
    }
    
    private TimerTask task(){
        return new TimerTask(){
            @Override
            public void run(){
                double r = Math.random();
                if (r > 0.2) return;
                if (r > 0.15) up();
                else if (r > 0.10) down();
                else if (r > 0.05) left();
                else right();
            }
        };
    }
    
    public void register(Observer observer){
        this.observers.add(observer);
    }

    private void changed() {
        for (Observer observer : observers) {
            observer.changed();
        }
    }
    
    public interface Observer{
        void changed();
    }
    
}