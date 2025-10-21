package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
        private static ExtentReports extent;

        public static ExtentReports getInstance() {
            if (extent == null) {

                LocalDateTime date = LocalDateTime.now();
                String formatted = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                formatted = formatted.replaceAll(":","_").toString();
                System.out.println(formatted);;


                System.out.println(formatted);;
                ExtentSparkReporter spark = new ExtentSparkReporter("test-output/reports/html/extent-report_"+formatted+".html");
                extent = new ExtentReports();
                extent.attachReporter(spark);
            }
            return extent;
        }
    }


