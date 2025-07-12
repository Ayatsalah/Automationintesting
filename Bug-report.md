#  Bug Report

##  Bug 01: User unable to book a reservation outside of the current month

**Description:**  
With a test user, I verified that users cannot book reservations that span outside of the current month.

##  Environment:
- URL: https://automationintesting.online

###  Steps to Reproduce:
1. Enter different months for check-in and check-out dates.
2. Click on the **Check Availability** button.
3. Select a room and click on the **Book Now** button.

###  Expected Result:
The system should display and process the selected month (e.g., August).

###  Actual Result:
It only shows the current month (July), and the booking does not reflect dates outside of it.

**Severity:** High

---

##  Bug 02: Users can book reservations for past dates within the current month

**Description:**  
Users are able to select and book reservations for past dates in the current month, which should not be allowed.

##  Environment
- URL: https://automationintesting.online

###  Steps to Reproduce:
1. Enter past dates for check-in and check-out.
2. Click on the **Check Availability** button.

###  Expected Result:
An error message should appear indicating that past dates are not valid for reservations.

###  Actual Result:
The system displays available rooms and allows the reservation to proceed.

**Severity:** High

---

## 🐞 Bug 03: Admin can add duplicate room numbers

**Description:**  
An admin can add a room with the same room number multiple times, leading to data duplication.

### ✅ Steps to Reproduce:
1. Log in as an admin.
2. Add a room with a room number and price.
3. Click **Create**.
4. Repeat steps 2 and 3 with the same room number.

### ✅ Expected Result:
An error message should be shown indicating that the room number already exists.

### ❌ Actual Result:
The system allows adding the same room number multiple times.

**Severity:** High

## 📍 Environment
- URL: https://automationintesting.online

---

##  Bug 04: Reservation form allows invalid characters in name and phone fields

**Description:**  
The first name and last name fields accept numbers and special characters. The phone field accepts letters and special characters.

##  Environment
- URL: https://automationintesting.online

###  Steps to Reproduce:
1. Enter valid check-in and check-out dates across different months.
2. Click on the **Check Availability** button.
3. Select a room and click on the **Book Now** button.
4. Click on the **Reservation** button.
5. Enter numbers and special characters in the name fields.
6. Enter letters and special characters in the phone field.
7. Click on the **Reserve Now** button.

###  Expected Result:
Validation errors should appear, indicating that names must contain only letters and the phone field should only accept valid digits.

###  Actual Result:
The form submits and allows reservations with invalid data.

**Severity:** Medium

---

##  Bug 05: Contact form allows names shorter than 3 letters

**Description:**  
The contact form allows users to submit names with fewer than 3 letters.

##  Environment
- URL: https://automationintesting.online

###  Steps to Reproduce:
1. Click on the **Contact** link.
2. Enter a name with fewer than 3 letters.
3. Fill in the other fields.
4. Click the **Submit** button.

###  Expected Result:
An error message should indicate that the name must be at least 3 letters long.

###  Actual Result:
The form submits successfully.

**Severity:** Medium

---

##  Bug 06: Users can book reservations with a check-in date later than the check-out date

**Description:**  
With a test user, I verified that the system allows users to make a reservation where the check-in date is after the check-out date, which should not be allowed.

##  Environment
- URL: https://automationintesting.online

###  Steps to Reproduce:
1. Enter a check-in date that is later than the check-out date.
2. Click on the **Check Availability** button.

###  Expected Result:
An error message should appear indicating that the check-in date cannot be after the check-out date.

###  Actual Result:
The system shows available rooms and allows the booking to proceed.

**Severity:** High

