class ParkingSystem {

    
    private int big;
    private int medium;
    private int small;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        
        boolean canPark = false;
        // big car
        if (carType == 1) {
            if (big > 0) {
                big--;
                canPark = true;
            }
        } else if (carType == 2) {
            // medium car.
            if (medium > 0) {
                medium--;
                canPark = true;
            }
        } else if (carType == 3) {
            // small car
            if (small > 0) {
                small--;
                canPark = true;
            }
        }
        
        return canPark;
    }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */