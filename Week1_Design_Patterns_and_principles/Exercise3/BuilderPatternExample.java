class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String motherboard;
    private String powerSupply;
    private String coolingSystem;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.motherboard = builder.motherboard;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String motherboard;
        private String powerSupply;
        private String coolingSystem;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer Configuration: \n" +
                "CPU: " + CPU + "\n" +
                "RAM: " + RAM + "\n" +
                "Storage: " + storage + "\n" +
                "GPU: " + GPU + "\n" +
                "Motherboard: " + motherboard + "\n" +
                "Power Supply: " + powerSupply + "\n" +
                "Cooling System: " + coolingSystem;
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder()
               .setCPU("AMD Ryzen 9")
               .setRAM("64GB")
               .setStorage("2TB NVMe SSD")
               .setGPU("NVIDIA GeForce RTX 4090")
               .setMotherboard("MSI MPG X570 Gaming Pro Carbon")
               .setPowerSupply("1000W")
               .setCoolingSystem("Air Cooling")
               .build();

        System.out.println(gamingComputer);

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setMotherboard("ASUS Prime B460M-A")
                .setPowerSupply("500W")
                .build();

        System.out.println(officeComputer);
    }
}

// OUTPUT

// Computer Configuration: 
// CPU: AMD Ryzen 9
// RAM: 64GB
// Storage: 2TB NVMe SSD
// GPU: NVIDIA GeForce RTX 4090
// Motherboard: MSI MPG X570 Gaming Pro Carbon
// Power Supply: 1000W
// Cooling System: Air Cooling
// Computer Configuration: 
// CPU: Intel Core i5
// RAM: 16GB
// Storage: 512GB SSD
// GPU: null
// Motherboard: ASUS Prime B460M-A
// Power Supply: 500W
// Cooling System: null