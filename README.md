# Insurance-managment-system-application
The objective of this project is to design and develop an online portal for a XYZ Health Insurance Inc. to streamline the company’s work process. 
This portal will be a single platform serving multiple user groups (Policy holders, XYZ Company Admin and Hospital).
A company XYZ is an online health insurance provider with various health insurance plans which can be purchased online. 
XYZ company needs a one-stop account management portal for policy holders, doctors and the company itself. 
Through, this portal a new customer can explore and purchase the various insurance policies provided by the company.

In this company, the current system is a manual system which tracks the details of the customer’s insurance policies. 
This manual system is time consuming and prone to errors. In addition to it, the usage of paper in the payment process leads to less efficiency and redundancy of data. 

The proposed application is a streamlined and an automated system that manages the XYZ Company’s client information and reduces its manual work.

MAIN MENU FOR HEALTH INSURANCE POLICY SYSTEM

POLICY HOLDER 

•	Creates an account and login to add new policies.
•	Can modify personal information 
•	Make necessary payments
•	View his claim status
•	Print Insurance Card

INSURER/ADMIN

•	Login through admin portal
•	Access the report on the sales amount and numbers and total number of claims.
•	Generate reports on the number of policies purchased yearly
•	Generate claim reports
•	Add and remove policies
•	Add and remove plans
•	Approves and rejects the claims initiated by the hospital.

HOSPITAL
•	Login into the hospital portal
•	Fills out claims form for the treatment of the policy holder
•	View the status of the claims.
•	Update the status of the claims



CLASS DESCRIPTION
•	The Users.java acts a super class which has three sub classes PolicyHolder, Insurer and Hospital

•	Insurerclaims and hospitalclaims acts as interface which are implemented by Insurer and hospital class respectively.


•	There is a logical relationship between the policy holder, Insurer and the hospital

•	Insurer who acts as the admin has the privileges to add and remove plans, add and remove policies of the policyholder and approve/reject the claims initiated by the hospital


•	Policy Holder has the privileges to purchase/add a new policy, pay EMI and premium due,view his claim status and print insurance card when needed.

•	Hospital has the privileges to initiate a claim for the policy holder and update the status of the claims

