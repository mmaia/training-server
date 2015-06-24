# training-server

Camel Router WAR Project with Web Console and REST Support
==========================================================

This project bundles the Camel Web Console, REST API, and some sample routes. You can either:

1. build the WAR by running

   ```
   mvn install
   ```

   and then run the project by dropping the WAR into your favorite web container, or

2. just run

   ```
   mvn jetty:run
   ```

   to start up and deploy to Jetty.


Web Console
===========

You can view the Web Console by pointing your browser to http://localhost:9999/

You should be able to do things like

* browse the available endpoints
* browse the messages on an endpoint if it is a BrowsableEndpoint
* send a message to an endpoint
* create new endpoints

For more help see the Apache Camel documentation

    http://camel.apache.org/
    
