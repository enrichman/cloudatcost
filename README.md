CloudAtCost
=================

CloudAtCost API client for Java applications

-- still in development

Download
--------

The library is still on development.

If you want to try it add the OSS repository to your pom:

```xml
<repositories>
    <repository>
        <id>OSS</id>
        <url>https://oss.sonatype.org/content/groups/public</url>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```

and check the latest snapshot from [here](https://oss.sonatype.org/content/groups/public/it/enricocandino/cloudatcost/1.0-SNAPSHOT/) 
( currently: 1.0-20151130.225947-3 )

Add the dependency via Gradle:
```groovy
compile 'it.enricocandino:enricocandino:1.0-20151130.225947-3'
```
or Maven:
```xml
<dependency>
    <groupId>it.enricocandino</groupId>
    <artifactId>cloudatcost</artifactId>
    <version>1.0-20151130.225947-3</version>
</dependency>
```


Examples
--------

Create the client with your apiKey and login email
```java
CACClient cacClient = new CACClient(API_KEY, LOGIN);
```

Then define a callback and execute the request.
For synchronous request you can call "execute".
Call "async" for asynchronous ones.

```java
// sync
cacClient.listServers().callback(callback).execute();

// async
cacClient.listServers().callback(callback).async();
```

You can do all in one-line if you want:

```java
cacClient.powerOp()
    .setSid("my-sid")
    .setAction(PowerOpRequest.ACTION.ON)
    .callback(powerOpCallback)
    .async();
```

Check the [CloudAtCost API specification](https://github.com/cloudatcost/api) for more information.

If you find any problem, please open an issue and feel free to contribute!


Developed By
--------

Enrico Candino - www.enricocandino.it

<a href="https://twitter.com/enrichmann">
  <img alt="Follow me on Twitter"
       src="http://icons.iconarchive.com/icons/danleech/simple/96/twitter-icon.png" />
</a>
<a href="https://plus.google.com/+EnricoCandino">
  <img alt="Follow me on Google+"
       src="http://icons.iconarchive.com/icons/danleech/simple/96/google-plus-icon.png" />
</a>
<a href="https://it.linkedin.com/in/enrico-candino-78995553">
  <img alt="Follow me on LinkedIn"
       src="http://icons.iconarchive.com/icons/danleech/simple/96/linkedin-icon.png" />
</a>


License
--------

    The MIT License (MIT)

    Copyright (c) 2015 Enrico Candino

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    