export class Patient {
    id: number=0;
    firstName: string="";
    lastName: string="";
    phoneNumber: string="";
    insuranceId: string="";
    email: string="";
    address!: Address;
  }
  
  export class Address {
    id: number=0;
    street: string="";
    city: string="";
    state: string="";
    zipCode: string="";
  }
  