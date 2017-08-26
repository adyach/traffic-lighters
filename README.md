# Traffic lighters
The program controls the change of traffic lights for the intersection.

## Build
The command will clean the project, build it and run tests (takes up to 1 minute)
`./gradlew clean build`

## Run
The program accepts one parameter, which represents minute from 
which provide the output for the light changes for the next thirty minute period.
For example, providing 10 as argument, will start output the light changes after 
10 minutes of program work for the next 30 minutes. 
Output starts from minute 0 by default 
`java -jar build/libs/traffic-lighter-1.0-SNAPSHOT.jar 10`