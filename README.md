**GT-Helper**

**First Android app - interacts with Google Translate**

This application guides the user how to use Google Translate's camera, to
translate text from Hebrew to Polish, in order to read aloud the Polish text.

This process was done, because reading aloud Hebrew text is not supported in GT.

The application was tested on Google Pixel 2 XL device (resolution of
2880\*1440).

**First screen:** The user has to press the orange button-\> GT app is launched

and the user will hear some additional directions, including focus GT's camera.


**Second screen:** The user has to press the upper (light green) button. This
will help when going to translation step later on.


after upper button was pressed, it will be replaced with lower, black button.

The user has to press the black button, which location is as GT's camera taking
photo location.


**Third screen:** after taking the photo with GT's camera and going to
translation,

we now have a blank screen. On this screen, the user has to swipe up using
finger.


**Fourth screen:** The user has to press the red button. This will lead to the
last step, which is copying the translated text from GT, to the clipboard.

Now, the user will hear the translated text read aloud, in Polish.



**Code:**

**MainActivity.java:** The first screen.

<https://github.com/LiorBob/GT-Helper/blob/master/app/src/main/java/com/example/user/firstbuttonapp/MainActivity.java>

**SecondActivity.java:** The second screen.

<https://github.com/LiorBob/GT-Helper/blob/master/app/src/main/java/com/example/user/firstbuttonapp/SecondActivity.java>

**ThirdActivity.java:** The third screen.

<https://github.com/LiorBob/GT-Helper/blob/master/app/src/main/java/com/example/user/firstbuttonapp/ThirdActivity.java>

**FourthActivity.java:** The fourth screen.

<https://github.com/LiorBob/GT-Helper/blob/master/app/src/main/java/com/example/user/firstbuttonapp/FourthActivity.java>

**OnSwipeTouchListener.java:** A class for the swipe up gesture. Found on the
net, used by ThirdActivity.java above.

<https://github.com/LiorBob/GT-Helper/blob/master/app/src/main/java/com/example/user/firstbuttonapp/OnSwipeTouchListener.java>

**YouTube demo:**

<http://www.youtube.com/watch?v=yW6o3kT9zvk>
