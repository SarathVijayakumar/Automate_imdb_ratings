package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateImdbRatings {
    WebDriver driver;

    public AutomateImdbRatings() {
         System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void testCase01() {
        try {
            driver.get("https://www.imdb.com/chart/top");

            // Find the dropdown for sorting by IMDb Rating
            WebElement sortByDropdown = driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[text()='IMDb rating']"));
            sortByDropdown.click();
            
            
            Thread.sleep(3000);

            // Find the highest rated movie
            WebElement highestRatedMovieElement = driver.findElement(By.className("ipc-metadata-list-summary-item"));

            System.out.println("Highest Rated Movie: " + highestRatedMovieElement.getText());

            // Find the number of movies in the table
                   List<WebElement> movieElements = driver.findElements(By.cssSelector(".ipc-metadata-list-summary-item"));
             int numberOfMovies = movieElements.size();
            System.out.println("Number of movies in the table: " + numberOfMovies);

            

            // Find the oldest movie on the list
             WebElement oldsortByDropdown = driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[text()='Release date']"));
            oldsortByDropdown.click();
           Thread.sleep(3000);

            WebElement elementToClick = driver.findElement(By.cssSelector("svg.ipc-icon--swap-vert"));
             elementToClick.click();
             Thread.sleep(3000);

               
            WebElement oldestMovieElement = driver.findElement(By.className("ipc-metadata-list-summary-item"));

            System.out.println("Oldest movie  " + oldestMovieElement.getText());

             elementToClick.click();
             Thread.sleep(3000);

           WebElement newMovieElement = driver.findElement(By.className("ipc-metadata-list-summary-item"));
             System.out.println("Recent  movie  " + newMovieElement.getText());


        
  // Find the movie with the most user ratingsNumber of ratings
          WebElement mostusersdropdown = driver.findElement(By.xpath("//select[@id='sort-by-selector']/option[text()='Number of ratings']"));
            mostusersdropdown.click();
           Thread.sleep(3000);
            WebElement reviewsmost = driver.findElement(By.className("ipc-metadata-list-summary-item"));
             System.out.println("Movies with most reviews  " + reviewsmost.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endTest() {
        driver.quit();
    }

    public static void main(String[] args) {
        AutomateImdbRatings imdbRatings = new AutomateImdbRatings();
        imdbRatings.testCase01();
        imdbRatings.endTest();
    }
}
