package vehicle;
	public class Main {
	    public static void main(String[] args) {
	        // Create Manufacture objects
	    	// Manufacture.java
	    	public class Manufacture {
	    	    private String name;
	    	    private String country;

	    	    public Manufacture(String name, String country) {
	    	        this.name = name;
	    	        this.country = country;
	    	    }

	    	    public String getName() {
	    	        return name;
	    	    }

	    	    public void setName(String name) {
	    	        this.name = name;
	    	    }

	    	    public String getCountry() {
	    	        return country;
	    	    }

	    	    public void setCountry(String country) {
	    	        this.country = country;
	    	    }

	    	    @Override
	    	    public String toString() {
	    	        return "Manufacture: " + name + " (" + country + ")";
	    	    }
	    	}

	        Manufacture toyota = new Manufacture("Toyota", "Japan");
	        Manufacture tesla = new Manufacture("Tesla", "USA");
	        Manufacture honda = new Manufacture("Honda", "Japan");

	        // Create Engine objects
	     // Engine.java (Superclass)
	        public abstract class Engine {
	            public abstract String getType();
	        }

	        // CombustionEngine.java (Subclass)
	        public class CombustionEngine extends Engine {
	            @Override
	            public String getType() {
	                return "Combustion Engine";
	            }
	        }

	        // ElectricEngine.java (Subclass)
	        public class ElectricEngine extends Engine {
	            @Override
	            public String getType() {
	                return "Electric Engine";
	            }
	        }

	        // HybridEngine.java (Subclass)
	        public class HybridEngine extends Engine {
	            @Override
	            public String getType() {
	                return "Hybrid Engine";
	            }
	        }

	        CombustionEngine combustionEngine = new CombustionEngine();
	        ElectricEngine electricEngine = new ElectricEngine();
	        HybridEngine hybridEngine = new HybridEngine();

	        // Create Vehicle objects
	     // Vehicle.java
	        public abstract class Vehicle {
	            protected Manufacture manufacture;
	            protected Engine engine;

	            public Vehicle(Manufacture manufacture, Engine engine) {
	                this.manufacture = manufacture;
	                this.engine = engine;
	            }

	            public abstract void ShowCharacteristics();
	        }

	        // ICEV.java (Subclass of Vehicle)
	        public class ICEV extends Vehicle {
	            public ICEV(Manufacture manufacture, CombustionEngine engine) {
	                super(manufacture, engine);
	            }

	            @Override
	            public void ShowCharacteristics() {
	                System.out.println("Vehicle Type: Internal Combustion Engine Vehicle (ICEV)");
	                System.out.println(manufacture);
	                System.out.println("Engine Type: " + engine.getType());
	            }
	        }

	        // BEV.java (Subclass of Vehicle)
	        public class BEV extends Vehicle {
	            public BEV(Manufacture manufacture, ElectricEngine engine) {
	                super(manufacture, engine);
	            }

	            @Override
	            public void ShowCharacteristics() {
	                System.out.println("Vehicle Type: Battery Electric Vehicle (BEV)");
	                System.out.println(manufacture);
	                System.out.println("Engine Type: " + engine.getType());
	            }
	        }

	        // HybridV.java (Subclass of Vehicle)
	        public class HybridV extends Vehicle {
	            public HybridV(Manufacture manufacture, HybridEngine engine) {
	                super(manufacture, engine);
	            }

	            @Override
	            public void ShowCharacteristics() {
	                System.out.println("Vehicle Type: Hybrid Vehicle");
	                System.out.println(manufacture);
	                System.out.println("Engine Type: " + engine.getType());
	            }
	        }

	        Vehicle icev = new ICEV(toyota, combustionEngine);
	        Vehicle bev = new BEV(tesla, electricEngine);
	        Vehicle hybridv = new HybridV(honda, hybridEngine);

	        // Create array of Vehicle objects
	        Vehicle[] vehicles = {icev, bev, hybridv};

	        // Display characteristics of each vehicle
	        for (Vehicle vehicle : vehicles) {
	            vehicle.ShowCharacteristics();
	            System.out.println("----------------------------");
	        }
	    }
	}

}
