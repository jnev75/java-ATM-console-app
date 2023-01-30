# Java ATM Console Application

**Version 1.0**

This is a sample readme file for my GitHub repo. I'm using Markdown documentation

* I'm developing an ATM Console Application
* Using Java version 18.0.2

Authorship documentation for the newly created project

## Any known bugs

---

## Update log

---

## Contributors

- James L Neville

---

## License & copyright

© James L Neville, Java ATM Console Application

---

## Terms of use

By using this web application, you acknowledge that the content developed is subject to copyright 
enforcement. This intellectual property right grants that the application may be used solely for personal use, as a 
reference, or for intended research purposes.

This policy also implies that the application cannot be modified, duplicated, re-distributed to a third party, or 
exploited for commercial use.

Any illegitimate use of the application will be considered a breach of the terms of use agreement. This may further 
violate copyright and trademark laws which are bound by the Copyright, Designs and Patents Act 1988

---

## Operations

The ATM console application features a range of on-screen menu options, for performing real world bank transactions. 
The user, representing the customer, must firstly log in before they can begin a transaction.

Both valid and existing Customer Number and PIN credentials need to be specified, for authorised access to the Bank
Express ATM service. In the event the user enters an unknown Customer Number or PIN, it will flag up as incorrect, and 
they will be prompted to please try again. If one of the two data entries is correct by the time 3 attempts have 
been made, the system will disable access to this customer record and their account will be locked. Attempting to
re-access this account from the log in menu will not work, as the record no longer exists on the system. The 
validation used here, ensures that the data input is digits only. Customer Numbers must be 6 digits long, while PINs 
used should be 4. If the data input does not take the form of an integer, it will flag up as invalid. The user will then 
be expected to re-enter these details for authorised access to the system.

Once the user successfully logs in, they will be prompted to specify which account they wish to access, if
any. The first set of menu options defined here, represent Current Account, Savings Account and Exit. Choice one
redirects the user to their Current Account. Choice two redirects the user to their Savings Account. While choice three 
can be used to exit the transaction process and return to the log in menu. Both current and savings account menu
sections, allow the user to view their current balance, withdraw funds, deposit funds, return and exit. All three menu 
sections leverage data validation, to ensure that the data entered is valid and matches one of the 
numbers (within square brackets) denoting each menu option. Once again, the user will be notified if the data they
entered requires any changes that need to be made. The first 3 menu options defined under both account types will also
feature an anything else prompt. This prompt will appear once the user has viewed their current balance, withdrawn or 
deposited funds. This additional prompt gives the user the option of accessing additional services within the same 
account. Here, they can simply type y or n, as their first character in a string. The input is case-insensitive, so a 
single character, uppercase or lowercase y or n is sufficed.

Once the user is satisfied with their transaction process within this account, they can also return to the account type 
menu section for further services, or exit the system (log out).