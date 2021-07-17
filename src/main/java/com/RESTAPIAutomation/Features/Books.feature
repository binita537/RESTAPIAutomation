Feature: Add new Books


@AddBook
Scenario: Add new Book successfully
         Given Add Books Payloads
         When User hit "AddBooks" Payload with "Post" Request
         Then Books added successfully with status code 200
         Then Verify the response should have "id"
         
         
          
         
Scenario Outline:Add new book with scinario outline  
                  
         Given Add Books Payloads with "<id>" "<title>" "<description>" "<pageCount>" "<excerpt>" "<publishDate>"
         When User hit "AddBooks" Payload with Post Request
         Then Books added successfully with status code 200
         And Verify the response should have  "id" is equal to  "<id>" 

Examples:

| id     | title     | description        | pageCount    |  excerpt  |   publishDate               |
| 201    | java      | this is java       | 100          |  erthd    |   2021-07-11T08:23:25.162Z  |
| 220    | paython   | this is java       | 10           |  erthd    |   2021-07-11T08:23:25.162Z  |