** Test Plan for String Data Processing Application **
**Introduction**
This test plan outlines the testing strategy for the Java application that processes a multiline string containing customer data. 
The application is expected to generate reports on unique customerId counts by contractId and geozone, 
calculate the average buildduration by geozone, and list unique customerIds for each geozone.

################ Test Objective ###################
Verify the application correctly parses the input string and convert it to a List Of JSON Payload and then it should return all these values with respective fields in response.
Ensure the application accurately computes:
The number of unique customerIds for each contractId.
The number of unique customerIds for each geozone.
The average buildduration for each geozone.
The list of unique customerIds for each geozone.
Validate the application’s performance with large datasets.
Ensure the application handles invalid inputs gracefully.

######### Test Items ########
1) API(Java Application)
2) Input Data (Multiline String - Json Payload)
3) Output Json Payload

######## Test Approach ########
1) Api Testing
2) Performance/Load Testing

#################### Test Cases ####################
1) Test Case 1 ::-> Validate the Success response from API with the Multiline String Input(List of Json Payload)
   input -> List of Json Payload
   output -> response with 200 Status code as OK

2) Test Case 2 ::-> Validate the API return all the fields with respective values parsed from input Json
   Input -> List of Json Payload
   output -> All the fiedls as CustomerID, ContractID, geoZone, ProjectCode, TeamCode and BuilDuration should contains all test data passed from the Json Input

3) Test Case 3 ::->  Unique customerId Count for Each contractId
   Objective: Validate the unique count of customerId for each contractId. (Api should parse the json response and group the customerID per ContractID and return them
Input: multiline string input/List Json Payload
Expected Result:
2345: 3 unique customerIds
2346: 2 unique customerIds

4) Test Case 4 ::-> Unique customerId Count for Each geozone
   Objective: Validate the unique count of customerId for each geozone. (Api should parse the json response and group the customerID per geoZone and return them)
Input: multiline string input/List Json Payload
Expected Result:
us_east: 1 unique customerId
us_west: 2 unique customerIds
eu_west: 2 unique customerIds

5) Test Case 5 ::-> Average buildduration for Each geozone
   Objective: Ensure the average buildduration is calculated correctly for each geozone. Validate API should calculate the average based on the number of Build duration values
Input: multiline string input/List Json Payload 
Expected Result:
us_east: Average of 3445s (only one value hence its the same)
us_west: Average of 2221s and 2211s (two values hence API should calculate the average M+N/2)
eu_west: Average of 4322s and 4122s (two values hence API should calculate the average M+N/2)

6) Test Case 6 ::-> Unique customerId List for Each geozone
   Objective: Validate the list of unique customerIds for each geozone.
Input: multiline string input/List Json Payload
Expected Result:
us_east: [2343225]
us_west: [1223456, 1233456]
eu_west: [3244332, 3244132]

#######################  Negative Scenario ############################
7) Test Case 7 ::-> Empty String Input/ Json payload contains only Null Value
Objective: Validate the API handles the Empty input Json gracefully and returns the Error code  from API
input -> Empty or Null json payload/ empty String
output -> 400 Bad Request {No Data in payload}

8) Test Case 8 ::-> Invalid String input/ invalid Json Payload
   Objective :- Validate API should handle the Invalid Values passed in json such as
   1) passing geoZone value as null in payload
   2) passing as some regex/special characters in team code project code and geoZone
   3) passing extra space in some fields values
   4) removing some Keys and hitting APIs
   5) Non numeric CustomerID and ContractId
  
  ETC
  Output -> 400 Bad Request {Data is invalid}

###################### Imporatant Edge Case scenarios ########################
9) Test case 9 -> Single line String input/ only one Json payload object instead of the List
Objective :-> API should handle if User send only one part of the payload instead of the whole list, in this case API should only update the respective fields only once

10) Test Case 10 -> All CustomerIDs are Identical
Objective :-> Check if API handles the scenario where all customerID values are the same accross different ContractId and GeoZones
e,g; -> All ContractID and geoZone have one CustomerID

11) Test Case 11 :-> All data in one geoZone
Objective :-> Check if API correctly handles cases where all records belong to same GeoZone
e.g ; -> if we have only one geoZone value in every key then "US_West" then it has 5 unique CustomerID

12) Test Case 12 :-> Extreme large build duration
Objective :-> Check if API handles very large build durations without error or overflow issue
e.g; "8888888888s", "100000000000s"

13) Test case 13 -> Zero build duration
Objective :-> Check if API handles zer0 build durations without error or overflow issue
e.g; "0s", "0s"

14) Test case 14 -> Negative build duration
Objective :-> Check if API handles Negative build durations without error or overflow issue
e.g; "-888s", "-666s"

15) Test Case 15 -> Missing geoZone
objective :-> Varify the API identifies and report missing of geoZone and pass 400 bad request

########################  Some Performance/Load testing scenarios ########################
suppose requirement API  should support till 17000 concurrent users hit
16) test case 16 :-> Concurrent user as 10000
objective :- Hit the API through Jmeter with 10000 concurrent user
output :- API should successfully creates the records

16) test case 16 :-> Concurrent user as 16999
objective :- Hit the API through Jmeter with 16999 concurrent user
output :- API should successfully creates the records

16) test case 16 :-> Concurrent user as 17000
objective :- Hit the API through Jmeter with 17000 concurrent user
output :- API should successfully creates the records

16) test case 16 :-> Concurrent user as 17001
objective :- Hit the API through Jmeter with 17001 concurrent user
output :- API should not successfully creates the records
