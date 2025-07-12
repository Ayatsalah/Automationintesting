#  Test Plan – Automation in Testing

##  Scope of Testing
This test plan covers automated UI testing of critical user journeys on [automationintesting.online](https://automationintesting.online). The focus is on:
- Functional correctness of booking workflows
- Field validations
- Form submission reliability
- Admin login authentication


##  Critical User Flows
- **Room Booking Flow**: From check-in date selection to booking confirmation
- **Contact Form Submission**: Valid input handling and message submission
- **Admin Login**: Valid and invalid login attempts

## Rationale for Test Case Selection
These user journeys were chosen based on their business-critical nature and direct impact on user experience. They represent:
- High-traffic areas of the application
- Revenue-generating or support-critical functionality
- Potential areas for frequent change (e.g., booking logic)

## Tool Choice Justification
- **Selenium 4**: Allows robust and flexible UI automation for real-world web apps.
- **Java 21**: Modern Java ensures long-term maintainability, performance, and cleaner code.
- **Cucumber BDD**: Encourages clear, business-readable test cases; great for collaboration with non-technical stakeholders.
- **JUnit**: Reliable and widely adopted test runner for Java projects.
- **POM (Page Object Model)**: Simplifies test maintenance by separating UI interactions into logical classes.
- **Singleton WebDriver**: Prevents multiple conflicting browser sessions and improves performance.
- **Maven**: Handles dependencies and provides a consistent build system.

---


