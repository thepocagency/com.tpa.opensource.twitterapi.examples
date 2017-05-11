# jTwitterAPI example

This is a simple example of a main class consuming Twitter API thanks to the project jTwitterAPI: [https://github.com/thepocagency/com.tpa.opensource.twitterapi](https://github.com/thepocagency/com.tpa.opensource.twitterapi).

Check the main class ofr more information:
Step 1. User has to log in the Twitter API
Step 2. It calls the Twitter streaming API (using class StreamingSearch.java)
Steps 3. + 4. 
 - It orders the messages grouped by user (users sorted chronologically, ascending) 
 - The messages per user are also sorted chronologically, ascending
 - Print this information to the command line + in a log file (cf. /log/twitter.log)


If you follow the next compilation process, you will obtain a standalone JAR file.

This project contains couple of generic classes to create new Twitter calls quickly and easily. There is also an example of how to use Twitter streaming calls.

## How to use it / Example

1. Go to your workspace directory

2. Clone the jTwitterAPI from this URL: [https://github.com/thepocagency/com.tpa.opensource.twitterapi](https://github.com/thepocagency/com.tpa.opensource.twitterapi)

    2.a. Change configuration properties in the file config.properties, 
    you specially have to set the ```twitter.consumerKey``` and ```twitter.consumerSecret``` properties

NB: if you want to have results in different log files, you can change the ```java.util.logging.everyLogInSameFile``` property in the config.properties

NB: you can also see that we specially develop a light formatter to read Twitter messages more easily in the log file(s)


    2.b. Compile this project with Maven: ```mvn clean install```

3. Clone this second project from: [https://github.com/thepocagency/com.tpa.opensource.twitterapi.examples](https://github.com/thepocagency/com.tpa.opensource.twitterapi.examples)

    3.b. Compile this second project with Maven: ```mvn clean compile assembly:single```

    3.c. Run the project ```java -jar target/com.tpa.opensource.twitterapi.examples-1.0-SNAPSHOT-jar-with-dependencies.jar```

4. Results will be printed in the console and in a the log file: log/twitter.log


## Visible results

We've created a very simple Formatter to print lighted log messages, so in log/twitter.log, you can find result:

Example of result: 

```
    Result retrieved and list created with 33 elements


    New author added: Author name: Hallie;Brisbane♥¹³(creating date: Tue Jul 13 09:23:28 +0000 2010)


		New tweet: [at Thu May 11 08:27:32 +0000 2017, by Author name: Hallie;Brisbane♥¹³(creating date: Tue Jul 13 09:23:28 +0000 2010)]: RT @JBCrewdotcom: Indian Justin Bieber #PurposeWorldTour 2017 in Mumbai. There are no words... https://t.co/ADMqJJYAAy


    New author added: Author name: Nil Turump(creating date: Sat Mar 26 12:19:20 +0000 2011)


		New tweet: [at Thu May 11 08:27:44 +0000 2017, by Author name: Nil Turump(creating date: Sat Mar 26 12:19:20 +0000 2011)]: RT @CapaMagMagazin: Bahar Candan'dan Murat Boz açıklaması:"Ben Justin Bieber’a aşığım. Türk erkeğinin elini bile tutmam. Biz ablamla do… 


    New author added: Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)


		New tweet: [at Thu May 11 08:27:21 +0000 2017, by Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)]: 📹 bieber-news: May 10: Another video of Justin performing ‘Purpose’ in Mumbai, India. https://t.co/hGF67ywWYP
		New tweet: [at Thu May 11 08:27:26 +0000 2017, by Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)]: 📹 bieber-news: May 10: Another video of Justin performing ‘As Long As You Love Me’ in Mumbai, India. https://t.co/19gs0fhjwY
		New tweet: [at Thu May 11 08:27:30 +0000 2017, by Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)]: 📹 bieber-news: May 10: Fan taken video of Justin performing ‘Baby’ in Mumbai, India. https://t.co/Yn9JiVSaCn
		New tweet: [at Thu May 11 08:27:34 +0000 2017, by Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)]: 📹 bieber-news: May 10: Fan taken video of Justin performing ‘As Long As You Love Me’ in Mumbai, India. https://t.co/jdncmbHbUY
		New tweet: [at Thu May 11 08:27:39 +0000 2017, by Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)]: 📹 bieber-news: May 10: Fan taken video of Justin performing ‘Been You’ in Mumbai, India. https://t.co/FebcmF8iq0
		New tweet: [at Thu May 11 08:27:43 +0000 2017, by Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)]: 📹 bieber-news: May 10: Fan taken video of Justin performing ‘Love Yourself’ in Mumbai, India. https://t.co/7y8wQ0afLV
		New tweet: [at Thu May 11 08:27:47 +0000 2017, by Author name: Alice(creating date: Mon Jul 11 10:23:00 +0000 2011)]: 📹 bieber-news: May 10: Fan taken video of Justin performing ‘Cold Water’ in Mumbai, India. https://t.co/RKgqsFIhHh


    New author added: Author name: RahmaWatyBiebers(creating date: Thu Dec 01 08:17:04 +0000 2011)
                
                (...)
```



## Credits

We'd like to thank you [Picnic](https://www.picnic.nl/) for this nice assignment :)

Developped by Alexandre Veremme @ [The POC Agency](https://www.the-poc-agency.com)

## Licence

Licensed under the Apache License, Version 2.0 (the "License")

You may not use this file except in compliance with the License

You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied

See the License for the specific language governing permissions and limitations under the License