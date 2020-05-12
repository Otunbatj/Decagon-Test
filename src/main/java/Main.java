import com.google.gson.Gson;
import http_request.Request;
import models.Datum;
import models.Response;
import models.UserDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        // write your code here
        Response response = Request.getInstance("https://jsonmock.hackerrank.com/api/article_users/search?page=", 1).get();
        if ("00".equalsIgnoreCase(response.getRespCode())) {
            UserDetails userDetails = gson.fromJson(String.valueOf(response.getRespBody()), UserDetails.class);
            System.out.println(userDetails.toString());
            System.out.println(getUsernames(userDetails.getData(), 50));
            System.out.println(getUsernameWithHighestCommentCount(userDetails.getData()));
            System.out.println(getUsernamesSortedByRecordDate(userDetails.getData(), 1312041112));
        } else {
            System.out.println("Error: " + response.getRespDesc());
        }
    }

    public static List<String> getUsernames(List<Datum> data, int threshold) {
        List<String> filteredNames = new ArrayList<>();
        for (Datum datum : data) {
            if (datum.getCommentCount() >= threshold) {
                filteredNames.add(datum.getUsername());
            }
        }
        return filteredNames;
    }

    public static String getUsernameWithHighestCommentCount(List<Datum> data) {
        Datum highestCommentCount = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getCommentCount() > highestCommentCount.getCommentCount()) {
                highestCommentCount = data.get(i);
            }
        }
        return highestCommentCount.getUsername();
    }

    public static List<String> getUsernamesSortedByRecordDate(List<Datum> data, int threshold) {
        List<Datum> filteredData = new ArrayList<>();
        for (Datum datum : data) {
            if (datum.getCreatedAt() >= threshold) {
                filteredData.add(datum);
            }
        }

        Collections.sort(filteredData, Comparator.comparingLong(Datum::getCreatedAt).reversed());
        System.out.println(filteredData.toString());

        return filteredData.stream().map(Datum::getUsername).collect(Collectors.toList());
    }
}
