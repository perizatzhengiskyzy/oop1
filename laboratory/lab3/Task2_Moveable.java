// Task 2: Moveable Interface

interface Moveable {
    void move();
    void stop();
    double getSpeed();
}

interface FlyMoveable extends Moveable {
    void takeOff();
    void land();
    void changeAltitude(int altitude);
}

class Eagle implements FlyMoveable {
    private double speed;
    private int altitude;
    private boolean isFlying;
    
    @Override
    public void move() {
        if (!isFlying) takeOff();
        System.out.println("Eagle soaring through the sky at " + speed + " km/h");
    }
    
    @Override
    public void stop() {
        land();
    }
    
    @Override
    public double getSpeed() {
        return speed;
    }
    
    @Override
    public void takeOff() {
        isFlying = true;
        speed = 50;
        System.out.println("Eagle takes off!");
    }
    
    @Override
    public void land() {
        isFlying = false;
        speed = 0;
        altitude = 0;
        System.out.println("Eagle lands");
    }
    
    @Override
    public void changeAltitude(int altitude) {
        this.altitude = altitude;
        System.out.println("Eagle flying at " + altitude + " meters");
    }
}

class Drone implements FlyMoveable {
    private double speed;
    private int altitude;
    private boolean isFlying;
    
    @Override
    public void move() {
        if (!isFlying) takeOff();
        System.out.println("Drone flying at " + speed + " km/h");
    }
    
    @Override
    public void stop() {
        land();
    }
    
    @Override
    public double getSpeed() {
        return speed;
    }
    
    @Override
    public void takeOff() {
        isFlying = true;
        speed = 30;
        System.out.println("Drone rotors spinning... taking off!");
    }
    
    @Override
    public void land() {
        isFlying = false;
        speed = 0;
        System.out.println("Drone landing");
    }
    
    @Override
    public void changeAltitude(int altitude) {
        System.out.println("Drone climbing to " + altitude + " meters");
    }
}