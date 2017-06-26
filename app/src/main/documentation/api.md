## GET users/:owner/events
List someone events
## GET /repos/:owner/:repo/events
List repository events
## GET /repos/:owner/:repo/issues/events
List issue events for a repository
## GET /orgs/:org/events
List public events for an organization
## GET /users/:username/received_events
List events that a user has received
## GET /users/:username/received_events/public
List public events that a user has received

# star
## GET /users/:username/starred
List repositories being starred
## GET /user/starred
List repositories being starred by the authenticated user.
### Parameters
Name	Type	Description
sort	string	One of created (when the repository was starred) or updated (when it was last pushed to). Default: created
direction	string	One of asc (ascending) or desc (descending). Default: desc
## GET /user/starred/:owner/:repo
Check if you are starring a repository
Requires for the user to be authenticated
Response if this repository is starred by you
Status: 204 No Content
Response if this repository is not starred by you
Status: 404 Not Found
## PUT /user/starred/:owner/:repo
Star a repository
Requires for the user to be authenticated.
Note that you'll need to set Content-Length to zero when calling out to this endpoint. For more information, see "https://developer.github.com/v3/#http-verbs"
Response
Status: 204 No Content
## DELETE /user/starred/:owner/:repo
Unstar a repository
Requires for the user to be authenticated.
Response
Status: 204 No Content
# repository
