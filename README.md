# springboot-mqtt-example
An example of integrating MQTT messaging into Spring Boot.

## Building the Example
Run the following command to build the example:

    ./gradlew clean buildImage
    
This command builds the example as a set of Docker images.

## Running the Example
Follow the steps below to run the example:

1. Run the following command to start the example:

        docker-compose up
        
   The Docker Compose script starts the following containers:
   
   * 1 - Eclipse Mosquitto MQTT Broker
   * 1 - [mqtt-service](mqtt-service) to collect temperature statistics.
   * 2 - [temp-sensor](temp-sensor) to generate temperature data.
        
2. Execute the following command to get the current count and average of temperature observations:

        curl http://localhost:8080/temps/stats
        
    If successful, you will see a response similar to the following:

        {"count":16,"average":71.03261965593954}
    
## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/springboot-mqtt-example/issues).

## License
MIT License

Copyright (c) 2019 Greg Whitaker

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