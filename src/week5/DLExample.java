package week5;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class DLExample {
    
    @Test
    public void testDeadlokcing() {
        
        System.out.println(">> starting to test");
        
        int NUM_THREADS = 100;
        
        Dispatcher dispatcher = new Dispatcher();
        Taxi taxi = new Taxi(dispatcher);
        dispatcher.notifyAvailable(taxi);

        Runnable deadlockingTaxi = new Runnable() {
            @Override
            public void run() {
                taxi.setLocation(new Point());
            }
        };

        Runnable deadlockingDispatcher = new Runnable() {
            @Override
            public void run() {
                dispatcher.getImage();
            }
        };
        
        Thread[] threads = new Thread[NUM_THREADS];
        
        for (int i = 0; i < NUM_THREADS/2; i++) {
            
            System.out.println(">> running threads " + (i*2) + " and " + (i*2+1));
            
            threads[i*2] = new Thread(deadlockingTaxi);
            threads[i*2+1] = new Thread(deadlockingDispatcher);
            threads[i*2].start();
            threads[i*2+1].start();
            
        }

        for (int i = 0; i < NUM_THREADS/2; i++) {
            
            try {
                threads[i*2].join();
                System.out.println(">> joined thread " + (i*2));
                threads[i*2+1].join();
                System.out.println(">> joined thread " + (i*2+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
        System.out.println(">> the end!");

    }

}

class Taxi {
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

	public synchronized Point getLocation() {
        return location;
    }

    public synchronized void setLocation(Point location) {
        this.location = location;
        if (location.equals(destination))
            dispatcher.notifyAvailable(this);
    }

    public synchronized Point getDestination() {
        return destination;
    }
}

class Dispatcher {
    private final Set<Taxi> taxis;
    private final Set<Taxi> availableTaxis;

    public Dispatcher() {
        taxis = new HashSet<Taxi>();
        availableTaxis = new HashSet<Taxi>();
    }

    public synchronized void notifyAvailable(Taxi taxi) {
        availableTaxis.add(taxi);
    }

    public synchronized Image getImage() {
        Image image = new Image();
        for (Taxi t : taxis)
            image.drawMarker(t.getLocation());
        return image;
    }
}

class Image {
    public void drawMarker(Point p) {
    }
}

class Point {
	
}

