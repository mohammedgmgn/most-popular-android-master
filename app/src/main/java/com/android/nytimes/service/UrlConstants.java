package com.android.nytimes.service;

/**
 * Created by Nibedita on 11/02/2018.
 */

public class UrlConstants {

   private UrlConstants() {
   }

   public static final String BASE_URL = "https://api.nytimes.com";
   public static final String API_KEY = "P93jw7uKbEEN7LrrG9AHFrN3A3XVt36G";
   public static final String MOST_VIEWED_URL = "/svc/mostpopular/v2/viewed/{period}.json?api-key=" + API_KEY;
}
