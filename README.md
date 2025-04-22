# Smart TV Simulation 📺

A Java-based console application that simulates a Smart TV system using core Object-Oriented Programming concepts such as **inheritance**, **composition**, **aggregation**, and **multithreading**.

## Features
- Simulates a Smart TV with a screen, remote control, and software update functionality.
- Implements OOP principles:
  - **Inheritance:** SmartTV extends Television which extends ElectronicAppliance.
  - **Composition:** SmartTV has a Screen and SoftwareUpdate as part of its internal components.
  - **Aggregation:** RemoteControl exists independently and is used by the TV.
  - **Threading:** Background software updates run using a separate thread.
- Interactive console-based menu for user input.

## How It Works
1. The user is greeted with a menu of Smart TV options.
2. Options include turning the TV on/off, changing channels, adjusting volume, browsing apps, and checking for software updates.
3. The remote control manages channel and volume functions.
4. The software update feature simulates checking for updates using multithreading.

## Technologies Used
- **Programming Language:** Java
- **IDE:** IntelliJ IDEA / Eclipse / VS Code
- **Concepts:** OOP (Inheritance, Composition, Aggregation), Java Threads, Scanner for user input

## Example Output
Welcome to SmartTV Controller!  
Select an option:  
1. Turn On TV  
2. Turn Off TV  
3. Connect to WiFi  
4. Browse App  
5. Change Channel  
6. Volume Up  
7. Volume Down  
8. Mute/Unmute  
9. Check for Software Update  
0. Exit  

Your choice: 1  
TV turned ON using remote.  
Displaying in 4K resolution on a 55.0 inch screen.

## Author
**Rasool Bux**  
A passionate software engineering student with a strong interest in OOP, web development, and building creative, interactive applications.
