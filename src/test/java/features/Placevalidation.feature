Feature: Validating place API

@Addplace
Scenario Outline: Verify if place is being successfully added using Add place API
Given Add place Payload with "<name>" "<language>" "<address>"
When user calls "AddplaceAPI" api with "POST" http request
Then API should success with status code 200
And "status" should be "OK"
And "scope" should be "APP"
And verify place_Id created maps to "<name>" using "GetplaceAPI"

Examples:
  |name  | language |address |
  |Deepak| English  |Azadpur |
  |Nitesh| English  | UP     |
  |Nitin | French   | Sonipat|
 
 @Deleteplace
Scenario: Verify if delete place functionalty is working fine
 Given Delete place Payload
 When user calls "DeleteplaceAPI" api with "POST" http request
 Then API should success with status code 200
 And "status" should be "OK"
 
