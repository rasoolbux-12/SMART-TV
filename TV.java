package ProjectOOP;
import java.util.Scanner;

// Composition
class Screen {
    private String resolution;
    private double screenSize;

    public Screen(String resolution, double screenSize) {
        this.resolution = resolution;
        this.screenSize = screenSize;
    }

    public void display() {
        System.out.println("Displaying in " + resolution + " resolution on a " + screenSize + " inch screen.");
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}

// Aggregation
class RemoteControl {
    private int currentChannel = 1;
    private int volume = 10;
    private boolean isMuted = false;

    public void turnOn() {
        System.out.println("TV turned ON using remote.");
    }

    public void turnOff() {
        System.out.println("TV turned OFF using remote.");
    }

    public void changeChannel(int channel) {
        try {
            if (channel <= 0) {
                throw new IllegalArgumentException("Channel number must be positive.");
            }
            this.currentChannel = channel;
            System.out.println("Switched to Channel " + channel);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void increaseVolume() {
        if (!isMuted) {
            volume++;
            System.out.println("Volume increased to " + volume);
        } else {
            System.out.println("Unmute the TV first to change volume.");
        }
    }

    public void decreaseVolume() {
        if (!isMuted && volume > 0) {
            volume--;
            System.out.println("Volume decreased to " + volume);
        } else if (isMuted) {
            System.out.println("Unmute the TV first to change volume.");
        } else {
            System.out.println("Volume is already at minimum.");
        }
    }

    public void toggleMute() {
        isMuted = !isMuted;
        System.out.println("TV is now " + (isMuted ? "muted." : "unmuted."));
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public void setMuted(boolean muted) {
        isMuted = muted;
    }
}

// Parent Class
class ElectronicAppliance {
    private String brand;

    public ElectronicAppliance(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

// Child Class
class Television extends ElectronicAppliance {
    protected Screen screen;
    protected RemoteControl remote;

    public Television(String brand, Screen screen, RemoteControl remote) {
            super(brand);
        this.screen = screen;
        this.remote = remote;
    }

    public void powerOn() {
        remote.turnOn();
        screen.display();
    }

    public void powerOff() {
        remote.turnOff();
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public RemoteControl getRemote() {
        return remote;
    }

    public void setRemote(RemoteControl remote) {
        this.remote = remote;
    }
}

// Threading
class SoftwareUpdate implements Runnable {
    @Override
    public synchronized void run() {
        System.out.println("Checking for updates...");
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            System.out.println("Update interrupted!");
        }
        System.out.println("Your Software is on Latest version!");
    }
}

// Child Class
class SmartTV extends Television {
    private boolean internetConnected;
    private SoftwareUpdate softwareUpdate; 

    public SmartTV(String brand, Screen screen, RemoteControl remote) {
        super(brand, screen, remote);
        this.internetConnected = false;
        this.softwareUpdate = new SoftwareUpdate(); 
    }

    public void connectToInternet() {
        internetConnected = true;
        System.out.println("SmartTV connected to the internet.");
    }

    public void browseApp(String appName) {
        if (internetConnected) {
            System.out.println("Opening " + appName + " app...");
        } else {
            System.out.println("Cannot open " + appName + ". Please connect to the internet first.");
        }
    }

    public void checkForSoftwareUpdate() {
        Thread updateThread = new Thread(softwareUpdate);
        updateThread.start();
    }

    public boolean isInternetConnected() {
        return internetConnected;
    }

    public void setInternetConnected(boolean internetConnected) {
        this.internetConnected = internetConnected;
    }
}

// Main Class
public class TV {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Screen screen = new Screen("4K", 55.0);
        SmartTV myTV = new SmartTV("Samsung", screen, remote);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to SmartTV Controller!");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Turn On TV");
            System.out.println("2. Turn Off TV");
            System.out.println("3. Connect to WiFi");
            System.out.println("4. Browse App");
            System.out.println("5. Change Channel");
            System.out.println("6. Volume Up");
            System.out.println("7. Volume Down");
            System.out.println("8. Mute/Unmute");
            System.out.println("9. Check for Software Update");
            System.out.println("0. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    myTV.powerOn();
                    break;
                case 2:
                    myTV.powerOff();
                    break;
                case 3:
                    myTV.connectToInternet();
                    break;
                case 4:
                    System.out.print("Enter app name to browse: ");
                    String appName = scanner.nextLine();
                    myTV.browseApp(appName);
                    break;
                case 5:
                    System.out.print("Enter channel number: ");
                    int channel = scanner.nextInt();
                    remote.changeChannel(channel);
                    break;
                case 6:
                    remote.increaseVolume();
                    break;
                case 7:
                    remote.decreaseVolume();
                    break;
                case 8:
                    remote.toggleMute();
                    break;
                case 9:
                    myTV.checkForSoftwareUpdate(); 
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

