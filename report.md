- Forked repo from "dat350"
- Problems with versions:
- [EL Severe]: metadata: 2021-09-05 17:02:48.906--ServerSession(553871028)--The no.hvl.dat250.jpa.basicexample.Todo class was compiled with an unsupported JDK. Report this error to the EclipseLink open 
source project.
- Installed Java SE11. This fixed the problem. DId not do any further research
- Inspected embedded database using DBeaver 21.2.0
- Added lombok to dependencies in pom.xml
- installed lombok extension in vs code
- Removed setters and getters from Todo class.
- Confirmed that code is still working

Family
- Followed tutorial
- Tests failed on assertion of correct number of People in Family
- Inspected database and could not find the expected join table between People and Family since the mappedby property is set in Family.
- Moved @OneToMany annotation from field (as in tutorial) to the get method. Deleted the database and ran the tests again. All tests passed.

Banking
- created project using maven template in vscode. In the last example I had some problems with paths and folder structure that seems to be important in java/maven. Have not investigated this further.
- Created classes according to class diagram.
- Implemented example object world in junit test. Tested that objectlinks are correct by retrieving objects and compare with the id of the objects I persisted. There are a probably a more efficient way of testing this.


Problems and things to remember:
- I should use the maven and java tool in VS code to make sure the project is properly organized
- 