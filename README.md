# JavaAppium

This project is a Java-based test automation framework using Appium for testing Android applications. It leverages Maven for build automation and GitHub Actions for continuous integration.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Android SDK
- Node.js
- Appium
- Maven

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/marcoshioka/JavaAppium.git
   cd JavaAppium
   ```

2. **Set up the environment variables:**

   Add the following lines to your `~/.bash_profile` or `~/.zshrc` file:

   ```bash
   export ANDROID_HOME=/path/to/your/android/sdk
   export PATH=$PATH:$ANDROID_HOME/tools
   export PATH=$PATH:$ANDROID_HOME/platform-tools
   ```

   Replace `/path/to/your/android/sdk` with the actual path to your Android SDK.

3. **Install dependencies:**

   ```bash
   npm install -g appium
   npm install --no-save mjpeg-consumer
   ```

4. **Build the project:**

   ```bash
   mvn clean install
   ```

## Running Tests

1. **Start the Appium server:**

   ```bash
   appium
   ```

2. **Run the tests:**

   ```bash
   mvn test
   ```

## Continuous Integration

This project uses GitHub Actions for continuous integration. The workflow is defined in the `maven.yml` file. It runs the tests on different Android API levels using a matrix strategy.

### GitHub Actions Workflow

The GitHub Actions workflow is triggered on push and pull request events to the `main` and `develop` branches. It sets up the environment, installs dependencies, creates an Android Virtual Device (AVD), starts the emulator, and runs the tests.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## **Contact**
For questions or feedback, please contact:
- **Email**: marcosribeirohioka@gmail.com
- **GitHub**: marcoshioka