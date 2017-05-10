# jTwitterAPI example

This is a simple example of a main class consuming Twitter API thanks to the project jTwitterAPI: [https://github.com/thepocagency/com.tpa.opensource.twitterapi](https://github.com/thepocagency/com.tpa.opensource.twitterapi).

If you follow the next compilation process, you will obtain a standalone JAR file.

This project contains couple of generic classes to create new Twitter calls quickly and easily. There is also an example of how to use Twitter streaming calls.

## How to use it / Example

1. Go to your workspace directory

2. Clone the jTwitterAPI from this URL: [https://github.com/thepocagency/com.tpa.opensource.twitterapi](https://github.com/thepocagency/com.tpa.opensource.twitterapi)

    2.a. Change configuration properties in the file config.properties, 
    you specially have to set the ```twitter.consumerKey``` and ```twitter.consumerSecret``` properties

    2.b. Compile this project with Maven: ```mvn clean install```

3. Clone this second project from: [https://github.com/thepocagency/com.tpa.opensource.twitterapi.examples](https://github.com/thepocagency/com.tpa.opensource.twitterapi.examples)

    3.b. Compile this second project with Maven: ```mvn clean compile assembly:single```

    3.c. Run the project ```java -jar target/com.tpa.opensource.twitterapi.examples-1.0-SNAPSHOT-jar-with-dependencies.jar```

4. Results will be printed in the console and in a the log file: log/twitter.log

NB: if you want to have results in different log files, you can change the ```java.util.logging.everyLogInSameFile``` property in the config.properties

## Credits

We'd like to thank you [Picnic](https://www.picnic.nl/) for this nice assignment :)

Developped by Alexandre Veremme @ [The POC Agency](https://www.the-poc-agency.com)

## Licence

Licensed under the Apache License, Version 2.0 (the "License")

You may not use this file except in compliance with the License

You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied

See the License for the specific language governing permissions and limitations under the License