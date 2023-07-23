Prerequisites: 
 - java 17 (I realized it said Java 11 way too late, and switching back to 11 would just take more time 
to find compatible versions for all other dependencies. I didn't use anything specific to Java 11+ in actual code)
 - Gradle (I used version 8.2.1, it supports all Java versions from 6 and up to 20)
 - Docker client

How to start:
 - You can start the application by calling 'docker compose up' from the root of the project.

Reasoning: 
 - Most of my reasoning was influenced by technical restraints and wireframe requirements.
 - I have also implemented everything our future front-end team might need to implement the UI from wireframes 
in the form of API endpoints.
 - All links in the UI can be implemented by calling 'getXById' or 'getXByNumber' API endpoints. 
I could, probably, use HATEOAS, but ran out of time. 
 - I have also used H2 in-memory db for quick local testing, removed all of it from final version 
in favor of containerized MySQL. 