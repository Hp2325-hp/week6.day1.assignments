package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionn {

	public ChromeDriver driver;String firstIdLink;

	//--------------------------------------------Create Lead
	
	@Given("open the Chrome Browser")
	public void open_the_chrome_browser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// login page
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Given("Enter the username {string}")
	public void enter_Username(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);

	}

	@Given("Enter the password {string}")
	public void enter_Password(String password) {

		driver.findElement(By.id("password")).sendKeys(password);

	}

	@Given("Click the Login Button")
	public void login_Click() {

		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@When("Click the CRM\\/SFA Link")
	public void click_the_crm_sfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("Click the Leads")
	public void click_the_leads() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@When("Click the create leads")
	public void click_the_create_leads() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter the company name {string}")
	public void enter_the_company_name(String companyname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
	}

	@Given("Enter the first name and last name {string} {string}")
	public void enter_the_first_name_and_last_name(String fname, String lname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		// provide last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}

	@Given("Enter the fnamelocal, department, desc and mail_id {string} {string} {string} {string}")
	public void enter_the_fnamelocal_depart_desc_mail(String fnamelocal, String depart, String desc, String mail) {
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fnamelocal);
		// provide local last name
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(depart);
		// description
		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
		// mail id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(mail);

	}

	@Given("Select the country {string}")
	public void state_selection(String country) {
		WebElement we = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select s = new Select(we);
		s.selectByVisibleText(country);

	}

	@When("Click Submit button")
	public void click_submit() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("submitButton")).click();
	}
	//------------------------------------------------------ Edit Lead
	@When("Click the find leads")
	public void click_the_find_leads() throws InterruptedException {
		driver.findElement(By.xpath("//div//a[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@Given("Enter the first name {string}")
	public void enter_the_first_name(String fname) {
		driver.findElement(By.xpath("//div[contains(@class,'x-tab-item')]//input[@name='firstName']")).sendKeys(fname);

	}

	@When("Click the find leads button")
	public void click_the_find_leads_button() throws InterruptedException {
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@When("Click the first result")
	public void click_the_first_result() throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]")).click();
		Thread.sleep(2000);
	}

	@When("Click on the edit button")
	public void click_on_the_edit_button() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		Thread.sleep(2000);
	}

	@Given("Change the company name {string}")
	public void change_the_company_name(String newcompanyname) {
		driver.findElement(By.xpath("//td/input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//td/input[@id='updateLeadForm_companyName']")).sendKeys(newcompanyname);
	}

	@When("Click the submit button")
	public void click_the_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@When("Confirm the change is done {string}")
	public void confirm_the_change_is_done(String newcompanyname) {
		String company_name = driver.findElement(By.xpath("//td/span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(company_name);

		int length = newcompanyname.length();
		String temp = company_name.substring(0, length);
		company_name = temp;
		//verify the company is same or not
		if (company_name.equals(newcompanyname))
			System.out.println("Same company name");
		else
			System.out.println("Not same");
	}
	
	//------------------------------------------- Duplicate lead
	
	@Given("Enter the mail id {string}")
	public void enter_the_mail_id(String mail) throws InterruptedException {
		driver.findElement(By.xpath("//em[@class='x-tab-left']//span[text()='Email']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='emailAddress']"))
				.sendKeys(mail);
	}

	@When("Click the duplicate button")
	public void click_the_duplicate_button() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Duplicate Lead']")).click();
		Thread.sleep(2000);
	}

	@When("Click create Lead button")
	public void click_create_lead_button() throws InterruptedException {
		driver.findElement(By.xpath("//td/input[@value='Create Lead']")).click();
		Thread.sleep(2000);
	}

	//------------------------------------------- Create contact
	
	@When("Click the contacts")
	public void click_the_contacts() {
		driver.findElement(By.xpath("//div/a[text()='Contacts']")).click();
	}

	@When("Click create contact")
	public void click_create_contact() {
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
	}

	@Given("Enter the contact firstname and lastname {string} {string}")
	public void enter_the_contact_firstname_and_lastname(String fname, String lname) {
		driver.findElement(By.id("firstNameField")).sendKeys(fname);
		//providing last name
		driver.findElement(By.id("lastNameField")).sendKeys(lname);
	}

	@Given("Enter the contact local firstname and lastname {string} {string}")
	public void enter_the_contact_local_firstname_and_lastname(String localfname, String locallname) {
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(localfname);
		//providing last local name
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(locallname);
	}

	@Given("Enter the contact depart,desc,mail and country {string} {string} {string} {string}")
	public void enter_the_contact_depart_desc_mail_and_country(String depart, String desc, String mail, String country) {
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(depart);
		//Description
		driver.findElement(By.id("createContactForm_description")).sendKeys(desc);
		//mail id 
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(mail);
		//state selection
		WebElement we=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		Select s=new Select(we);
		
		s.selectByVisibleText(country);
	}

	@When("Click contact submit button")
	public void click_contact_submit_button() {
		driver.findElement(By.xpath("//td/input[@name='submitButton']")).click();
	}

	@When("Click edit and update the desc {string}")
	public void click_edit_and_update_the_desc(String newdesc) {
		driver.findElement(By.xpath("//div/a[text()='Edit']")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys(newdesc);
		
		driver.findElement(By.xpath("//tr//input[@name='submitButton']")).click();
	}

	//-------------------------------------------------------------Delete lead
	
	@Given("Enter the phone number {string} and Click find leads")
	public void enter_the_phone_number_and_click_find_leads(String phoneno) throws InterruptedException {
		driver.findElement(By.xpath("//span/span[text()='Phone']")).click();
		driver.findElement(By.xpath("//div/input[@name='phoneNumber']")).sendKeys(phoneno);
		// click find leads
		driver.findElement(By.xpath("//td//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}
	@When("Click the first contact data")
	public void click_the_first_contact_data() throws InterruptedException {
		firstIdLink = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]"))
		.getText();
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]")).click();
		Thread.sleep(2000);
	}
	@When("Click the delete")
	public void click_the_delete() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Delete']")).click();
		Thread.sleep(2000);
	}
	
	@When("Check the data is deleted")
	public void check_data_deleted() throws InterruptedException
	{
		driver.findElement(By.xpath("//div//a[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//searching the lead
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys(firstIdLink);
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		String result = driver
				.findElement(By.xpath("//div[contains(@class,'x-small-editor')]//div[@class='x-paging-info']"))
				.getText();
		Thread.sleep(2000);

		System.out.println(result);
		//record deleted confirmation
		if (result.equals("No records to display"))
			System.out.println(firstIdLink + " Id is deleted");
		else
			System.out.println("Id is not deleted");
	}
	
}
