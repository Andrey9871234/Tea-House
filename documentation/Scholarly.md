# IEEE-Tempate
IEEE System Requirements Specification Template

# Software Requirements Specification
## For  <project name>
Version 1.0 approved
Prepared by Andrei
<organization>
<date created>

Table of Contents
=================
  * [Revision History](#revision-history)
  * [Introduction](#1-introduction)
    * 1.1 [Purpose](#11-purpose)
    * 1.2 [Document Conventions](#12-document-conventions)
    * 1.3 [Intended Audience and Reading Suggestions](#13-intended-audience-and-reading-suggestions)
    * 1.4 [Product Scope](#14-product-scope)
    * 1.5 [References](#15-references)
  * [Overall Description](#overall-description)
    * 2.1 [Product Perspective](#21-product-perspective)
    * 2.2 [Product Functions](#22-product-functions)
    * 2.3 [User Classes and Characteristics](#23-user-classes-and-characteristics)
    * 2.4 [Operating Environment](#24-operating-environment)
    * 2.5 [Design and Implementation Constraints](#25-design-and-implementation-constraints)
    * 2.6 [User Documentation](#26-user-documentation)
    * 2.7 [Assumptions and Dependencies](#27-assumptions-and-dependencies)
  * [External Interface Requirements](#external-interface-requirements)
    * 3.1 [User Interfaces](#31-user-interfaces)
    * 3.2 [Hardware Interfaces](#32-hardware-interfaces)
    * 3.3 [Software Interfaces](#33-software-interfaces)
    * 3.4 [Communications Interfaces](#34-communications-interfaces)
  * [System Features](#system-features)
    * 4.1 [System Feature 1](#41-system-feature-1)
    * 4.2 [System Feature 2 (and so on)](#42-system-feature-2-and-so-on)
  * [Other Nonfunctional Requirements](#other-nonfunctional-requirements)
    * 5.1 [Performance Requirements](#51-performance-requirements)
    * 5.2 [Safety Requirements](#52-safety-requirements)
    * 5.3 [Security Requirements](#53-security-requirements)
    * 5.4 [Software Quality Attributes](#54-software-quality-attributes)
    * 5.5 [Business Rules](#55-business-rules)
  * [Other Requirements](#other-requirements)
* [Appendix A: Glossary](#appendix-a-glossary)
* [Appendix B: Analysis Models](#appendix-b-analysis-models)
* [Appendix C: To Be Determined List](#appendix-c-to-be-determined-list)




## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|      |         |                     |           |
|      |         |                     |           |
|      |         |                     |           |

## 1. Introduction
### 1.1 Purpose 
The purpose of the Your Tea website is to provide customers with a user-friendly platform to browse and order different types of tea products. The website aims to offer an enjoyable and hassle-free shopping experience to customers who are interested in purchasing high-quality tea products.
### 1.2 Document Conventions
The document follows the IEEE System Requirements Specification Template for consistency and clarity in presenting the requirements of the Your Tea website. The conventions used in this document include the use of section headings, numbering, and formatting styles. 
### 1.3 Intended Audience and Reading Suggestions
The intended audience of the IEEE System Requirements Specification for the Your Tea website includes professors, software developers and anyone involved in the development, maintenance, or evaluation of the website. Reading suggestions include understanding of software development and website design principles, knowledge of the requirements gathering process, and familiarity with the specific needs and goals of the Your Tea website.
### 1.4 Product Scope
The product scope of the Your Tea website is to provide an online platform for customers to browse and order tea products from the comfort of their homes. The website will offer a variety of tea products with detailed descriptions, prices, and quantities available. Customers will be able to create an account, add items to their cart, and securely checkout with various payment options. Additionally, the website will provide information about the company and its history, as well as a contact form for customer inquiries.



## Overall Description
### 2.1 Product Perspective
The Your Tea website is an online platform that enables customers to order and purchase various types of tea products and accessories. It is a standalone system that operates independently of other systems, although it may integrate with external payment gateways to process customer transactions securely. The website is designed to be user-friendly and accessible to customers worldwide, with features such as a menu of available products, an order form, and a contact page.
The web design for Yourtea's website incorporates HTML5, Java with servlet, AJAX, and JSON. This integration ensures optimal user experience, dynamic content generation, seamless data retrieval, and efficient data transmission. By utilizing these technologies, Yourtea's web design achieves an engaging and user-friendly online experience.
### 2.2 Product Functions
The Your Tea website has several functions that include providing a menu of tea products, allowing customers to place orders, displaying information about the company, providing contact information, and offering a platform for customers to leave feedback. The website also allows customers to view their order history.
### 2.3 User Classes and Characteristics
Customers: They are the end-users of the website and have different characteristics such as their preferences for different types of tea, payment methods, and delivery options. They may also have different levels of computer skills and familiarity with online shopping.

The application we developed incorporates a comprehensive set of technologies to ensure robust functionality and an intuitive user experience. In the backend, we utilized vanilla Java and JDBC for seamless integration with a MySQL database, which was emulated within a Docker environment. The core aspect of data management was facilitated through the implementation of DAO (Data Access Object) functionalities, enabling streamlined connectivity with the database and efficient execution of essential queries. Servlets were employed as intermediaries between the frontend, such as Postman during the testing stage, and the backend, effectively handling incoming requests and orchestrating interactions with the relevant DAO functions to ensure prompt and accurate responses.

On the frontend, AJAX played a vital role in facilitating asynchronous communication with the backend, allowing for dynamic retrieval of data and seamless population of web pages with content sourced from the database. The Java programming language served as the foundation for creating a cohesive and organized collection of classes to support the application's operations. Notably, the Tea class served as a representation of individual tea products, encapsulating key attributes such as id, name, description, and price. The TeaDAO class acted as a vital component by providing essential methods for managing tea products, encompassing functionalities such as retrieving all teas, fetching a specific tea based on its unique identifier, adding new teas, updating existing ones, and removing teas from the inventory.

Additionally, the User class was instrumental in modeling users of the tea shop website, capturing essential details including id, name, email, and password. The Order class served as a pivotal entity for representing orders placed by users, encompassing a comprehensive list of teas and other pertinent information. To ensure efficient management of orders, the OrderDAO class was developed, offering crucial data access methods for handling various operations such as retrieving all orders, retrieving specific orders by their corresponding IDs, adding new orders, updating existing orders, deleting orders, and retrieving user information associated with specific orders.

The integration of these technologies and the implementation of the aforementioned classes in Java collectively contribute to a sophisticated and reliable application, enabling efficient data management, seamless communication between the frontend and backend, and ultimately providing a user-friendly experience for customers of the tea shop.

Administrators: They are the website managers who have access to the backend of the website to manage inventory, orders, and customer data. They should have technical skills to manage the website effectively.
### 2.4 Operating Environment
The Your Tea website is designed to operate in a standard web environment with modern web browsers, such as Google Chrome, Mozilla Firefox, Apple Safari, and Microsoft Edge, on desktop and mobile devices. The website requires an internet connection to access and use all of its features. It is designed to be responsive, ensuring that it adapts to different screen sizes and resolutions. The website does not require any additional software or hardware beyond a standard web browser and internet connection.
### 2.5 Design and Implementation Constraints
Compatibility: The website must be compatible with a variety of web browsers, operating systems, and devices.

Accessibility: The website must be designed to be accessible to users with disabilities, including those who use assistive technologies such as screen readers.

Security: The website must be designed with security in mind, to protect users' personal information and prevent unauthorized access.

Performance: The website must be designed to perform well, with fast load times and minimal downtime.
### 2.6 User Documentation
The user documentation for the Your Tea website will consist of a comprehensive guide that explains how to navigate the website, how to search for teas, how to select and order teas, how to create an account, and how to view order history. The documentation will also include FAQs and troubleshooting tips for common issues that users may encounter while using the website. The documentation will be available online and can be accessed through the website. It will be written in clear and concise language that is easy for users to understand. Additionally, the website will have a help section that will provide users with further information and assistance.
### 2.7 Assumptions and Dependencies
Assumptions:

Users have access to a computer or mobile device with internet connectivity.
Users have basic knowledge of how to use a computer and navigate web pages.
The website will be accessible in all major web browsers.
Dependencies:

The website will depend on reliable internet connectivity.
## External Interface Requirements
### 3.1 User Interfaces
The user interface of the Your tea website includes a homepage with a header containing the website logo, navigation menu, and a search bar. The homepage also displays featured teas and promotions. Users can browse teas by categories or search for a specific tea using the search bar. Each tea has a dedicated page with details such as price, description, and customer reviews. Users can add teas to their cart and proceed to checkout. The checkout process includes a form for the user to enter their shipping and payment information. Finally, after the order is submitted, the user is redirected to a confirmation page with details about their order and an estimated delivery date.
### 3.2 Hardware Interfaces
As the Your tea website is a web-based application, it does not have any hardware interfaces requirements. The website can be accessed through any device with a web browser and an internet connection.
### 3.3 Software Interfaces
The Your Tea website will be designed to work on all major web browsers, including but not limited to Chrome, Firefox, Safari, and Edge. The website will be built using HTML, CSS, and JavaScript, and will utilize a backend database to store user information and order history. 
### 3.4 Communications Interfaces
As a web-based application, Your Tea website will communicate with its users through standard web communication protocols such as HTTP and HTTPS. The website will also interact with external payment gateways such as PayPal and Stripe, and will utilize their respective APIs to handle transactions securely. Additionally, the website will interact with external email servers to send order confirmations and other email notifications to users.
## System Features
This template illustrates organizing the functional requirements for the product by system features, the major services provided by the product. You may prefer to organize this section by use case, mode of operation, user class, object class, functional hierarchy, or combinations of these, whatever makes the most logical sense for your product.
### 4.1 System Feature 1
Feature Name: Search and Choose Tea from Menu.

Description: This feature allows users to search and choose from a wide range of tea options available on the website. The user can search for a particular type of tea and other snacks through the menu categories. Once the user has selected a tea, they can view its description and add it to their cart. This feature ensures a smooth and easy selection process for the user. After the choosing the user can go to the Order page and confirm the products and the quantities of the each product.
4.1.1   Description and Priority
 Feature Name: Search and Choose from Menu

Description: This feature will allow users to search for tea items and choose from a menu of available options. Users will be able to search by tea type, ingredients, and other parameters.

Priority: High

Benefit: This feature will greatly enhance the user experience by providing an easy and intuitive way for users to find and select their desired tea items.

Penalty: Not having this feature could result in frustration and confusion for users, leading to decreased satisfaction and potentially lost sales.

Cost: The cost of implementing this feature is relatively low, as it primarily involves designing and integrating a user-friendly search and menu interface.

Risk: The risk of implementing this feature is relatively low, as it has become a standard expectation for e-commerce websites to have search and menu functionality. However, there may be some minor technical challenges in integrating the search and menu with the existing website architecture.
4.1.2   Stimulus/Response Sequences
 For the "Search and Choose from Menu" feature, the stimulus/response sequences would be:

User clicks on the search bar and enters a query for the desired item.
System displays a list of menu items that match the search query.
User selects an item from the list.
System displays the selected item's details, including name, description, price, and any customization options.
User selects the desired customization options, if any.
System adds the item to the user's order.
User continues to browse the menu or proceeds to checkout
4.1.3   Functional Requirements
Feature Name: Search and Choose from Menu

Functional Requirements:

The system shall provide a search bar for users to input keywords to search for specific tea items.
The system shall display a menu of tea items that match the user’s search query.
The system shall allow users to browse the menu of tea items by category, such as green tea, black tea, and herbal tea.
The system shall display the name, price, and description of each tea item in the menu.
The system shall allow users to add a tea item to their cart by clicking on the corresponding “Add to Cart” button.
The system shall allow users to adjust the quantity of each tea item in their cart before submitting their order.
The system shall display the total cost of the items in the user’s cart.
The system shall provide a “Submit” button for users to submit their order.
The system shall display an error message if the user attempts to checkout without specifying a valid delivery address.
The system shall display a confirmation message with the details of the order, including the estimated delivery time and the seats allocated for the user, after the user successfully submits their order.
 


## Other Nonfunctional Requirements
### 5.1 Performance Requirements
Response time for all user interactions should be less than 2 seconds under normal load conditions.
The website should be able to handle up to 100 concurrent users at any given time.
The website should be able to handle a peak load of up to 500 users without experiencing any downtime or significant degradation in performance.
The website should be able to handle a high volume of orders and payment transactions without any errors or delays.
The website should be optimized for fast page load times and should aim to deliver a fully rendered page in under 3 seconds.
### 5.2 Safety Requirements
Since the Your Tea website is not a safety-critical system, there are no safety requirements that need to be addressed.
### 5.3 Security Requirements
Secure data transmission: The website must use HTTPS to encrypt data transmission between the user's browser and the server to ensure that user data is protected during transmission.
Compliance with data protection regulations: The website must comply with all relevant data protection regulations to ensure the privacy and security of user data. This includes regulations such as GDPR and CCPA.
User data access and deletion: The website should provide users with the ability to access and delete their personal data.
### 5.4 Software Quality Attributes
Usability: The website should be easy to use and navigate for users with varying levels of technical expertise. Users should be able to quickly and easily place orders and find relevant information.
Reliability: The website should be available and responsive at all times to prevent any loss of clients.
Security: The website should be designed to protect user data and prevent unauthorized access. This includes implementing secure login processes and encrypting sensitive information such as credit card details.

### 5.5 Business Rules
List any operating principles about the product, such as which individuals or roles can perform which functions under specific circumstances. These are not functional requirements in themselves, but they may imply certain functional requirements to enforce the rules.

## Other Requirements
Define any other requirements not covered elsewhere in the SRS. This might include database requirements, internationalization requirements, legal requirements, reuse objectives for the project, and so on. Add any new sections that are pertinent to the project.
### Appendix A: Glossary
Your Tea website: A web application designed to provide an online platform for customers to order tea products and access information related to tea.
SRS: System Requirements Specification - a document that describes the features, functionalities, and characteristics of a software system that is being developed.
IEEE: Institute of Electrical and Electronics Engineers - a professional organization that develops standards for the engineering and development of software and other technologies.
UI: User Interface - the visual and interactive components of a software system that a user interacts with to perform tasks and access information.
UX: User Experience - the overall experience a user has while interacting with a software system, including the ease of use, functionality, and satisfaction with the product.
HTML: Hypertext Markup Language - a standard markup language used for creating web pages and applications.
CSS: Cascading Style Sheets - a language used for describing the presentation and styling of web pages and applications.
API: Application Programming Interface - a set of protocols and tools used for building software applications and enabling communication between different systems or applications.
HTTPS: Hypertext Transfer Protocol Secure - a secure version of the HTTP protocol used for secure communication over the internet.
SSL: Secure Sockets Layer - a security protocol used for establishing encrypted links between web servers and browsers to protect sensitive data.
SQL: Structured Query Language - a programming language used for managing and manipulating relational databases.
CRM: Customer Relationship Management - a strategy used for managing interactions with customers and improving customer relationships.
CMS: Content Management System - a software application used for managing the creation and modification of digital content.
### Appendix B: Analysis Models
Optionally, include any pertinent analysis models, such as data flow diagrams, class diagrams, state-transition diagrams, or entity-relationship diagrams.
### Appendix C: To Be Determined List
Collect a numbered list of the TBD (to be determined) references that remain in the SRS so they can be tracked to closure.
