import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestPlan{

    private static final String baseUrl="https://www.biletix.com/anasayfa/TURKIYE/tr";
    private static final String driverPath = "/home/ygenc/SeleniumProjects/ChromeDriver/geckodriver";
    private static WebDriver driver;



    @BeforeTest
    public void launchBrowser(){
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }


    @Test(priority = 1)
    public void confirmRules() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.id("_evidon-accept-button")).click();}
        catch (NoSuchElementException e){
            System.out.println("Web Element Is Not Found");
        }

    }


    @Test(priority = 2)
    public void popUp() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.xpath("//*[@id=\"adddialog2\"]/*")).click();}
        catch (NoSuchElementException e){
            System.out.println("Web Element Is Not Found");
        }

    }




    @Test(priority = 3)
    public void categories() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.id("category_sb")).click();}
        catch (NoSuchElementException e){
            System.out.println("Can not Reach Category Button");
        }

    }

    @Test(priority = 4)
    public void music() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.xpath("//*[@id=\"category_sb\"]/*[contains (@value, 'MUSIC')]")).click();}
        catch (NoSuchElementException e){
            System.out.println("Can not Reach Music Selection");
        }

    }

    @Test(priority = 5)
    public void date() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.id("date_sb")).click();}
        catch (NoSuchElementException e){
            System.out.println("Can not Reach Date Button");
        }

    }

    @Test(priority = 6)
    public void thirtyDays() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.xpath("//*[@id=\"date_sb\"]/*[contains (@value, 'next30days')]")).click();}
        catch (NoSuchElementException e){
            System.out.println("Can not Reach thirtyDays Selectipn");
        }

    }

    @Test(priority = 7)
    public void location() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.id("city_sb")).click();}
        catch (NoSuchElementException e){
            System.out.println("Can not Reach Location Button");
        }
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void selectAll() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.xpath("//*[@id=\"city_sb\"]/*[contains (@selected, 'selected')]")).click();}
        catch (NoSuchElementException e){
            System.out.println("Can not Reach Select All Selection");
        }

    }

    @Test(priority = 9)
    public void search() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.xpath("//*[@id=\"searchbox_form\"]/*[contains (@class, 'discoverbar__button')]")).click();}
        catch (NoSuchElementException e){
            System.out.println("Can not Reach Search Button");
        }

    }

    @Test(priority = 10)
    public void verifyPage() throws InterruptedException {
        Thread.sleep(2000);
        try { driver.findElement(By.id("combo_result_header")).isDisplayed();}
        catch (NoSuchElementException e){
            System.out.println("Can Not Find The Page");
        }
    }

    @Test(priority = 11)
    public void eventInfo() {

        FileInfo write = new FileInfo();

            String[] eventName = new String[10];
            String[] eventDate = new String[10];
            String[] eventStatus = new String[10];
            try {
                //Variables
                WebElement ename;
                WebElement edate;
                WebElement estatus;
                for(int i=1; i<=10; i++){
                    ename = driver.findElement(By.xpath("//*[@id=\"all_result\"]/*[contains (@class, 'result_render')]/div["+i+"]/div/div[3]/div[2]/a"));
                    String tempName = ename.getText();
                    eventName[i-1]=tempName;
                    estatus= driver.findElement(By.xpath("//*[@id=\"all_result\"]/*[contains (@class, 'result_render')]/div["+i+"]/div/div[3]/div[2]/span"));
                    String tempStatus= estatus.getText();
                    eventStatus[i-1]=tempStatus;
                    edate= driver.findElement(By.xpath("//*[@id=\"all_result\"]/*[contains (@class, 'result_render')]/div["+i+"]/div/*[contains (@class, 'grid_3 alpha fld3 col-xs-12 searchResultInfo3 hiddenOnMobile')]/div/span"));
                    String tempDate= edate.getText();
                    eventDate[i-1]=tempDate;
                }
            }
            catch (Exception e){
                System.out.println("İnitialization Failure");
            }
            write.writer(eventName, eventStatus, eventDate);


        }
    @Test(priority = 12)
    public void nextPage() {
        for (int i=3; i<=4; i++) {
            driver.findElement(By.xpath("//*[@id=\"search_results\"]/*[contains(@class, 'paginator')]/ul/li["+i+"]")).click();
            eventInfo();
        }
    }


    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
