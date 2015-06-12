# Interview HQ

[![Join the chat at https://gitter.im/hashd/interview-hq](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/hashd/interview-hq?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/hashd/interview-hq.svg?branch=master)](https://travis-ci.org/hashd/interview-hq) ![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)

This is a simple web application built using Spring boot to hold a pool of interview questions within an organization with security enabled.

#### Login details

> Until mechanism is improved
```
username: test
password: test1234
```

### Developer Notes

#### Using Spring-Loaded hot deployment
Use the maven target spring-boot:run to run the application with springloaded agent on your jvm, springloaded will hot deploy any classes which have changed in the target folder.

```
mvn spring-boot:run
```

> Kindly note that IDEA users will have to enable 'Make project automatically' in settings window to compile the project as and when the source is being changed. Eclipse users will not have to do any change wrt this.
