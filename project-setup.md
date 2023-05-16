# ABOUT THE PROJECTS

in every service there is a docker-compose file , it contains only databases required to run the services for now but will be updated as we gon to include all third party service provides we use.
to run those files, navigate to the service directory from your terminal and run docker-compose-up.

after that you will have it there.
spring version we are using is 2.5.7 , (for the sake of slueth)
spring cloud version 2020.0.3 again for slueth,

in each docker compose file make sure to change the username from "yohannes" to your name.(only for postgress)
in the pom.xml there is a "build-docker image " profile , we will use that to containerize and publish our services to dockerhub later.
