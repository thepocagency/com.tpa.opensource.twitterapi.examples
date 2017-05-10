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
import com.tpa.twitterapi.api.generic.bean.TwitterAuthor;
import com.tpa.twitterapi.api.generic.bean.TwitterStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is just used to order a list of statuses by author
 * 
 * @author Alexandre Veremme @ The POC Agency | alex [at] the-poc-agency.com
 */
public class PrintOutput {

    public static final Logger LOGGER = LoggerSingleton.getInstance().getLogger(PrintOutput.class);
    
    private List<TwitterAuthor> authors;

    public PrintOutput(List<TwitterStatus> orderedStatuses) {
        orderedStatuses.forEach((currentStatus) -> {
            addStatus(currentStatus);
        });
    }

    /**
     * Group statuses by author
     * 
     * @param twitterStatus
     * @return true if added | false if status was already in the list
     */
    public boolean addStatus(TwitterStatus twitterStatus) {
        if (authors == null) {
            authors = new ArrayList<>();
        }
        
        TwitterAuthor currentTwitterAuthor;
        
        if (!authors.contains(twitterStatus.getAuthor())) {
            LOGGER.log(Level.INFO, "\n\nNew author added: {0}\n\n", twitterStatus.getAuthor().toString());
            authors.add(twitterStatus.getAuthor());
        }
        
        currentTwitterAuthor = authors.get(authors.indexOf(twitterStatus.getAuthor()));
        
        return currentTwitterAuthor.getStatuses().addStatus(twitterStatus);
    }
}
