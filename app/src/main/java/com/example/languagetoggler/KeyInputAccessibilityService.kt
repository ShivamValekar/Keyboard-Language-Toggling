package com.example.languagetoggler
import android.accessibilityservice.AccessibilityService
//--the above imports the base class for extending our service, it allows the app to-
//--run in background, Monitor system-wide UI events, understand what the keyboard is writing
import android.view.accessibility.AccessibilityEvent
//--this import helps with identifying if any activity took place like clicking something and many more.


class KeyInputAccessibilityService : AccessibilityService() {
    /*this line makes it so that, my class aka "Key inputAccessibilityService"
     inherits(also known as "extends") resources from AccessibilityService
      class which we imported above
     */
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        /*This function gets triggered every time an accessibility
        like a user typing or selecting something occurs
        event: AccessibilityEvent? parameter gives
        you details about what changed — like the package name, source view, and new text
         */
    }
    override fun onInterrupt() {
        /*This is used to close the app when the program
        is forcibly shutdown.
        Releases resources,cancel tasks, or log that the
        service was interrupted
         */
    }
}