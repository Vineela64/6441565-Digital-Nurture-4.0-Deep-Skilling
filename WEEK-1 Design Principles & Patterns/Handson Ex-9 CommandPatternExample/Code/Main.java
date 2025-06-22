public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();

        System.out.println("== Pressing ON Button ==");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\n== Pressing OFF Button ==");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

