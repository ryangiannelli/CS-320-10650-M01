Ryan Giannelli
CS 320
Professor Tanisha Jacks
26 April 2026

How can I ensure that my code, program, or software is functional and secure?

I can ensure my code is functional by writing thorough unit tests that cover both valid and invalid inputs for every requirement. In this course, I used JUnit to test every field constraint, every service method, and every edge case across the contact, task, and appointment services. Every test had a clear expected outcome so the result was objective rather than subjective. Input validation is critical to ensure security. I validated every input in both the constructors and setters so that null values, values exceeding character limits, and improperly formatted data are rejected before they can enter the system. Testing should also cover both functional and non-functional requirements to make sure the software works correctly under real-world conditions.

How do I interpret user needs and incorporate them into a program?

I interpret user needs by carefully reading through the requirements and identifying every condition that needs to be met before writing any code. In our projects, the customer provided specific requirements for each service, and I went through them line by line to make sure nothing was missed. Each requirement translated directly into validation logic in the code and at least one corresponding test case. If a requirement was unclear, I treated it as something that needed to be addressed rather than ignored. This approach makes sure that the final product matches what the customer asked for rather than what I assumed they wanted.

How do I approach designing software?

I approach designing software by starting with the requirements and working outward. I identify what the program needs to do first, then figure out how to structure the code to meet those needs. For the projects, I built the object classes first with all the validation logic, then built the service classes on top of them. I tested the object classes before the service classes because the service layer depends on the objects working correctly. I keep things simple and avoid adding complexity that is not required by the requirements. I also build testing into the process from the start rather than treating it as something to do at the end.
