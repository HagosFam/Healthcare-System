import { Payment } from "./Payment"

export class Bill {
    id:any
    patientId:any
    servicesRendered:string=""
    payment:Payment[] = new Array()
}