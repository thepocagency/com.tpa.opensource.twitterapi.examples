/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tpa.opensource.twitterapi.examples.StreamingExample;

import com.tpa.twitterapi.tools.singleton.logger.LoggerSingleton;
import com.tpa.twitterapi.tools.singleton.property.PropertySingleton;
import com.tpa.twitterapi.tools.singleton.scanner.ScannerSingleton;
import com.tpa.twitterapi.api.authentificator.TwitterAuthenticator;
import com.tpa.twitterapi.api.call.StreamingSearch;
import com.tpa.twitterapi.api.generic.bean.TwitterStatus;
import com.tpa.twitterapi.api.generic.bean.TwitterStatuses;
import com.tpa.twitterapi.exception.TwitterAuthenticationException;
import com.tpa.twitterapi.exception.TwitterRequestException;
import com.tpa.twitterapi.exception.WrongConversionException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is just a small example to show you how to use our Twitter API
 *
 * 1. User has to log in the Twitter API
 *
 * 2.a. to set the delay of waiting time 2.b. the max number of retrieved posts
 * 2.c. the search you want
 *
 * 3. It calls the Twitter-API-streaming-search StreamingSearch.java
 *
 * 4. + 5. Order the messages grouped by user (users sorted chronologically,
 * ascending) - The messages per user are also sorted chronologically, ascending
 * - Print this information to the command line + in a log file (cf.
 * /log/twitter.log)
 *
 * @author Alexandre Veremme @ The POC Agency | alex [at] the-poc-agency.com
 */
public class StreamingExample {

    protected static final PropertySingleton PROPERTY_SINGLETON = PropertySingleton.getInstance();
    protected static final Logger LOGGER = LoggerSingleton.getInstance().getLogger(StreamingExample.class);

    public static void main(String[] args) {
        LOGGER.info("Starting application...");

        try {

            // 1. Authentification
            TwitterAuthenticator twitterAuthenticator = new TwitterAuthenticator();

            // 2. Let's ask for parameters...
            Integer delayInSeconds;
            try {

                delayInSeconds = ScannerSingleton.getInstance().scanValue(Integer.class,
                        PROPERTY_SINGLETON.getInteger("twitter.default.delayInSeconds"),
                        "Please specify the number of waiting seconds: ");

            } catch (WrongConversionException ex) {
                throw new com.tpa.twitterapi.exception.TwitterAuthenticationException("Unable to convert the delayInSeconds");
            }

            Integer sizeLimit;
            try {

                sizeLimit = ScannerSingleton.getInstance().scanValue(Integer.class,
                        PROPERTY_SINGLETON.getInteger("twitter.default.sizeLimit"),
                        "Please specify the max number of elements: ");

            } catch (WrongConversionException ex) {
                throw new com.tpa.twitterapi.exception.TwitterAuthenticationException("Unable to convert the sizeLimit");
            }

            String textSearch;
            try {
                textSearch = ScannerSingleton.getInstance().scanValue(String.class,
                        PROPERTY_SINGLETON.getProperty("twitter.default.searchText"),
                        "Please specify the search: ");
            } catch (WrongConversionException ex) {
                throw new com.tpa.twitterapi.exception.TwitterAuthenticationException("Unable to convert the sizeLimit");
            }

            // 3. Call the streaming Twitter API
            List<TwitterStatus> statuses = new StreamingSearch(twitterAuthenticator, delayInSeconds, sizeLimit)
                    .addParameter("track", textSearch) // Optionnal (if missing: uses default text search)
                    .executeListRequest(); // Executes the request

            // 4. Order everything
            List<TwitterStatus> orderedStatuses = new TwitterStatuses(statuses).getOrderedStatuses();

            // 5. Group by author and print the result
            new PrintOutput(orderedStatuses);

        } catch (TwitterAuthenticationException | TwitterRequestException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        LOGGER.info("Application stopped.");
    }
}
