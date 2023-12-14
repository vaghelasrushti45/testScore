## Prerequisites

Make sure you have the following installed on your machine:

- Java 11
- Maven
- Appium 1.22.3
- An emulator or physical device for testing

## Project Structure

Download TheScore app APK and place it in the src/test/resources/app/ directory.

Execute the following commands to run the tests:
mvn clean test

Device Setup (if using a physical device)
Enable Developer Mode on your Android device.

Connect your device to the computer via USB.

Run the following command to check if the device is detected:
adb devices
