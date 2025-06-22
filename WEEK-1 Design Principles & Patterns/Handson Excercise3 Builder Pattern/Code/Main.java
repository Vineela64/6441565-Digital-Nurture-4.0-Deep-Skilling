public class Main {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();

        // High-end gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setOperatingSystem("Windows 11")
            .build();

        Computer officeComputer = new Computer.Builder("Intel i7", "16GB")
            .setStorage("512GB SSD")
            .setOperatingSystem("Windows 10 Pro")
            .build();

        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}

