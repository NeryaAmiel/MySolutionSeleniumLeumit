SeleniumExercise_Leumit
This project uses Java, Selenium, TestNG, and Extent Reports to automate tests for certain functionalities.

Table of Contents:
Frameworks Used
Package Structure
Task Details
Setup and Execution
Viewing Test Results
Frameworks Used
Java: Programming language for test automation logic.
Selenium: Web automation framework to interact with web browsers.
TestNG: Testing framework for organizing and executing test cases.
Extent Reports: Reporting framework for generating detailed test reports.
Package Structure
The project is structured as follows:

com.leumit.pages: Contains page object classes.
com.leumit.utils: Contains utility classes.
com.leumit.tests: Contains test classes categorized into positive and negative flows.
Task Details
Task A: TableUtils Class
The TableUtils class in com.leumit.utils.W3Schools handles operations related to HTML tables on the W3Schools website. Key methods include:

getTableCellText: Retrieves text from a specified cell in a table. Returns null if the cell is empty or if an exception occurs.
verifyTableCellText: Verifies if the text in a specified cell matches the expected text.
getTableCellTextByXpath: Retrieves text from a table cell using XPath. Returns null if the cell is empty or if an exception occurs.
Assumptions:

A search result of an empty value in the table is considered a success.
If there is an exception, null is expected to be returned.
Task B: MenuUtils Class
The MenuUtils class handles operations related to navigating menus. Specific conditions include:

getTableCellText: Retrieves text from a table cell based on the provided search criteria.
verifyTableCellText: Verifies if the text retrieved from getTableCellText matches the expected text.
getTableCellTextByXpath: Retrieves text from a table cell using XPath.
Assumptions:

A search item cannot include the sign ;, used to separate items.
A string can contain up to one ;.
Setup and Execution
To execute the tests:

Clone the Repository: Clone the repository to your local machine.

bash
Copy code
git clone <repository-url>
cd <project-directory>
Set Up Dependencies:

Ensure Java is installed.
Set up Selenium WebDriver and ChromeDriver according to your operating system.
Ensure TestNG is configured in your development environment.
Run Tests:

Use your preferred IDE (like IntelliJ IDEA or Eclipse) to open the project.
Navigate to the testng.xml file located in the root directory or the appropriate module.
Right-click on the testng.xml file and select "Run" to execute the test suite.
Viewing Test Results
Test results are generated using Extent Reports and are available in HTML format:

After running the tests, navigate to the test-output directory.
Open LeumitTestsReport.html in a web browser to view the detailed test results, including passed, failed, and skipped tests.
The report categorizes tests by type based on their class names:
Guru99 Tests:

Guru99 - Positive Flows: Tests where operations on Guru99 Bank applications are expected to succeed without errors.
Guru99 - Negative Flows: Tests focusing on error handling and failure scenarios in Guru99 Bank applications.
W3Schools Tests:

W3Schools - Positive Flows: Tests validating expected behaviors of HTML tables on the W3Schools website.
W3Schools - Negative Flows: Tests exploring unexpected behaviors and error conditions in HTML tables on the W3Schools website.
