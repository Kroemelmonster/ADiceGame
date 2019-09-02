package com.mygdx.game.desktop;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;


public class LagTest {
    private static HashMap<Integer, Report> hourReports = new HashMap<>();

    public static void main(String[] arg) throws IOException, InterruptedException {
        InetAddress geek = InetAddress.getByName("www.google.de");
        Report overAllReport = new Report();
        while (System.in.available() == 0) {
            Date date = new Date();
            Report hourReport = hourReports.get(date.getHours());
            if (hourReport == null) hourReport = new Report();

            hourReport.count++;
            overAllReport.count++;
            if (!geek.isReachable(500)) {
                hourReport.timeouts++;
                overAllReport.timeouts++;

                System.out.println(date.toString() + " : " + hourReport.toString());
            }

            hourReports.put(date.getHours(), hourReport);
            Thread.sleep(1000);
        }
        System.out.println("Overall : " + overAllReport.toString());
        hourReports.forEach((integer, report) -> {
            System.out.println("In Stunde " + integer + " : " + report.toString());
        });
    }

    private static class Report {
        private int count = 0;
        private int timeouts = 0;

        public String toString() {
            return timeouts + " / " + count + " ( " + (100F * timeouts / count) + "% )";
        }
    }
}
