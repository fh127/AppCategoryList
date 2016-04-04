# AppCategoryList
This Demo App is the construction of the views of a category catalog, it consists in a applications list, is expected to show all of its respective apps with icon and name and to show the app details when an item is selected.

## API REST SERVICE
```sh
https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json
```

## Support
App support from Android SDK 4+ to Smartphone and Tablet devices


## Documentation

this app is developed in Android Studio.
the Android project used Retrolambda gradle plugin to support lambda functions.
In the ```gradle.properties``` to configure your java sdk path
```sh
JAVA7_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_75.jdk/Contents/Home
JAVA8_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home
```
## Use principal Android Libraries
```sh
Android support Design 23.2.1
Retrolambda - https://github.com/evant/gradle-retrolambda -to support lambda functions
Retrofit - http://square.github.io/retrofit/ - Api Http client
Realm - https://realm.io/docs/java/latest/ - mobile database
Rx java/Rx Android - https://github.com/ReactiveX/RxJava - asynchronous process and event-based logic
ButterKnife - http://jakewharton.github.io/butterknife/ - method binding for Android views
Picasso -http://square.github.io/picasso/- to manage images process
Recycler Views Animations -https://github.com/wasabeef/recyclerview-animators
```
