public class Eagle extends Bird implements Fly{

    private boolean flying;
    private int altitude;

    static int MAX_EAGLE_ALTITUDE = 3800;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    @Override
    public void takeOff() {
        if(!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    /**
     * fly upward
     * @param meters altitude increase (maximum 3800m for eagle)
     * @return altitude
     */
    @Override
    public int ascend(int meters) {
        if (this.isFlying() && this.getAltitude() < MAX_EAGLE_ALTITUDE) {
            this.setAltitude(Math.min(this.getAltitude() + meters, MAX_EAGLE_ALTITUDE));
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.getAltitude());
        } else if(this.getAltitude() >= MAX_EAGLE_ALTITUDE) {
            System.out.printf("%s can't fly higher, altitude : %d%n", this.getName(), this.getAltitude());
        }
        return this.getAltitude();
    }

    /**
     * fly downward
     * @param meters altitude decrease
     * @return altitude
     */
    @Override
    public int descend(int meters) {
        if (this.isFlying()) {
            this.setAltitude(Math.max(this.getAltitude() - meters, 0));
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.getAltitude());
        }
        return this.getAltitude();
    }

    @Override
    public void land() {
        if (this.isFlying() && this.getAltitude() == 1) {
            this.setFlying(false);
            System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
            System.out.printf("%s is too high, he can't lands !%n", this.getName());
        }
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int meters) {
        this.altitude = meters;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }
}
