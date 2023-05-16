# Do not push to master
# Create your own branch as repo to your service
# We will build and deploy the services individually later

# Health care system core functinality steps ( high level)

# Healthcare-System
Microservices health care system

Health care system 

patient comes  (users,, receiptionist, patient are interacting here)

- Request for insurance information

register patient ( we can leverage kafka messaging here)
 if (emergency) 
      - autometically admitted to docter
     - medical history is created ( prescipto, doctor, examnation result, if he has appointment, medications list, he will stay or leave)
if(not emergency)
     - create appointment
     - appintment info is created (appintment date and time, docter name, patient id, appoitment room,  ) ( we have docter here)
         ( 
                  - he can change the appointment (requests) ( can be apprved or rejected)
                  - he can cancel the appointment ( request)   ( approved or rejected) 
                          after the above two actions, messaging for notification service ( email, system is also notified with messaging and events)
                  - or he can attend the appointment 
        if he attends the appointment, medical history is created like the above
              medical history is created ( prescipto, doctor, examnation result, if he has appointment, medications list, he will stay or leave)

- After the examnation, he will go to payment service to pay for the exanmation

- then he get back to the doctor to get his results

= After getting results, the doctor will create presicription ( recomendations, appointment info, medication )

                       
                Basic tech we are using
- Spring boot framework
- Docker
-  
