# Automated functional tests for News Reader
## Requirements

* Install [Appium](https://github.com/appium/appium-desktop/releases). Ensure Appium server is running when running the tests
* Ensure you have **Java 8** and ANDROID_HOME environment variable set
* Enusure you have an Emulator created that matches the emulator mentioned in the 'capabilities' section of the `most-popular-android/appium/utils.py` file

* [Python 3](http://docs.python-guide.org/en/latest/starting/install3/osx/)
```bash
sudo mkdir /usr/local/Frameworks
sudo chown $(whoami):admin /usr/local/Frameworks
brew install python3
sudo ln -s /usr/local/bin/pip3 /usr/local/bin/pip
```

### For Windows
* Remove this line `'automationName': 'UiAutomator2'` from the capabilities block the `most-popular-android/appium/utils.py` file.

* For Windows OS if you run Hyper-V for Docker and you want to use the Android Emulator you've the following two choices. 

1- **Use a device** Ensure you have a device connected with API 25 or above. Update the device name in the `most-popular-android/appium/utils.py` file. 
2- **Use Windows Hypervisor Platform** Follow the instruction on the following link [https://montemagno.com/android-emulators-on-hyper-v-are-pretty-awesome/](https://montemagno.com/android-emulators-on-hyper-v-are-pretty-awesome/). If it doesn't work, then try [this solution](https://medium.com/@randombites/running-android-emulator-and-docker-simultaneously-on-windows-df570cfe3fd1)


# How to run
Run this command in the terminal

1. Build a debug apk

`./gradlew assembleDebug`

2. Setup the required simulator device. Either create a simulator to match the details in [utils.py](utils.py) or update it with your simulator details in the capabilities section:

```python
    capabilities = {
        'platformName': 'android',
        'avd': 'Nexus_5X_API_26',
        'deviceName': 'Nexus_5X_API_26',
       ...
    }
```

3. Setup a virtual python environment

```bash
cd appium/
pip install virtualenv
virtualenv venv
. ./venv/bin/activate
pip install -r requirements.txt
brew install carthage
```

4. Run tests immediately after setup

`behave`

5. Run tests after opening terminal for the first time. 

This means you already have a virtual environment.

```
. ./venv/bin/activate
behave
```

### Running only @wip features
@wip features are.feature files annotated with @wip. It shows that you are currently working on it.

```bash
behave -w
```

## Special considerations

- The appium server must be started and running
- You require python3 to run Behave. If you have a virtual environment setup in python 2, please delete it and recreate the environment. Not recreating the virtual environment will result in errors.

To learn more about BDD: [Check Here](https://www.toptal.com/freelance/your-boss-won-t-appreciate-tdd-try-bdd)

To learn more about Behave: [Check here](http://behave.readthedocs.io/en/stable/behave.html)

# Generate test code

Appium provides Inspector tool to turn actions into test code. First, you need to start an Appium Desktop server and click on the magnifying glass on the top right. Under Desired Capabilities --> JSON Representation, put your emulator information and .apk or .app path (if relative path does not work, put the absolute path). The input has to be in JSON recognizable. 



For Android with emulator Nexus_5X_API_25, for example, the JSON would be 
```
{
"platformName": "android",
"avd": "Nexus_5X_API_25",
"deviceName": "MyCustomDeviceName",
"app": "/Users/myusername/Desktop/most-popular-android/app/build/outputs/apk/debug/app-debug.apk"
}
```
Click save, the Desired Capabilities should be automatically populated. Then click Start Session. Wait for the emulator to start and the inspector window to show up. You should be able to see the app running in the emulator and a screenshot will be generated for the inspector. If the screenshot in the inspector does not load correctly, click the refresh button on the top.

Start recording by clicking on Start Recording button on the top of the window. You will see a recorder tab shows up with "Perform some actions to see code show up here". Perform your action on the app and code will be generated in the recorder.

For example, to tap into one article, you would first select the corresponding element and click tap button in the right column. It might take a while to load. If it fails, click refresh. 

You will be able to select action code language. Select Python in this case.

# TODO
* Add Appium Java Support