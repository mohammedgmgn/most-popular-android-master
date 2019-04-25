fastlane documentation
================
# Installation

## Windows Users
Install [rubyinstaller](https://rubyinstaller.org/) version =>2.0 and <2.6 

after installing ruby installer basics 

Open a CMD session and run the following:

`gem install unf_ext -v 0.0.7.5 -NV`

After successfully installing, run the following:

`gem install fastlane -NV`


## Mac Users

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
### lint
```
fastlane lint
```

### tests
```
fastlane tests
```

### build_for_appium
```
fastlane build_for_appium
```

### beta
```
fastlane beta
```


----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
