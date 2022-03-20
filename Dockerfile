FROM ubuntu:latest 
RUN apt -y update && apt-get -y install curl
CMD /bin/bash