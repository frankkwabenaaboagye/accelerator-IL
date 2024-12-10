package frank.oop_deep_dive.labtwo;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Rocket {

    private String name;
    private double weight;

    @Override
    public String toString(){
        return "Rocket[name= " + this.name + " weight= " + this.weight + " kg]";
    }

    public void displayRocketDetails(){
        System.out.println("Rocket Name: " + this.name);
        System.out.println("Rocket Weight: " + this.weight + " kg");
    }

    @Data
    @AllArgsConstructor
    public class Engine{
        private String type;
        private double thrust;

        public double calculateThrustToWeightRatio() {
            return thrust / (weight * 9.8);
        }

        public void displayEngineDetails() {
            System.out.println("Engine Type: " + type);
            System.out.println("Thrust: " + thrust + " N");
            System.out.println("Thrust-to-Weight Ratio: " + calculateThrustToWeightRatio());
        }
    }



}
