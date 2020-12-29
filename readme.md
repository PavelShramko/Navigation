Project contains 4 activities: Login, List, Item and Camera.

Login screen must be launched first.

If user is already logged in - login screen must be closed and List screen must be opened.
_____________

On the list screen user can use camera feature.

Request permission for camera usage.

Remember that permission request should be user-friendly. 

When the permission is granted, please, open the CameraActivity.
_____________

On the ListActivity fabStartSomething must open ItemActivity.

On the ItemActivity startAgainButton must open ItemActivity again.

But it should look like the screen is updated and new screen should not be added to back stack.

On the ItemActivity logout button must logout user and open Login screen.

Think about user expirience. (Should other activities will be kept in the back stack?)
_____________


UserLogin object keeps the info about user login.
_____________

Additional task:

Implement radio group with 2 buttons: "own camera" / "another camera app".

When "own camera" is active flow, described above should work.

When "another camera app" is active, try to open differnt camera activity.
