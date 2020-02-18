# stocktracker
1. Extract the zip file
2. From your IDE (I used eclipse) Select File->Import->General->Existing projects into workspace
3. Select as the root directory, the directory to which you extracted the project.
4. Press Finish.
5. The project is now in your workspace.
6. Right-click on the project and select Maven->Update Project.
7. Once maven update is completed you can launch the project from App.java (Run As->Java Application)
8. Currently, the application is sampling the stock data from the provider once in a minute. It compares the data with the previous sample, in case the new sample matches one of the rules, it will print the notification to the console.
9. I also implemented part of the vending API, I use it to print the data, once it's updated in our system.   
10.Unit tests can be launched from AppTest.java (Run As ->JUnit Test)
