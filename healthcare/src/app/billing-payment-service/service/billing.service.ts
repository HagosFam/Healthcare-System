import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bill } from '../models/Bill';



@Injectable({
  providedIn: 'root'
})
export class BillingService {
  private baseUrl = 'http://api.example.com/bills'; // Read end point here

  constructor(private http: HttpClient) { }

  // Create a new bill
  createBill(bill: Bill): Observable<Bill> {
    return this.http.post<Bill>(this.baseUrl, bill);
  }

  // Get a bill by ID
  getBillById(id: any): Observable<Bill> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Bill>(url);
  }

  // Update a bill
  updateBill(bill: Bill): Observable<Bill> {
    const url = `${this.baseUrl}/${bill.id}`;
    return this.http.put<Bill>(url, bill);
  }

  // Delete a bill
  deleteBill(id: any): Observable<any> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete(url);
  }

  // Get all bills
  getAllBills(): Observable<Bill[]> {
    return this.http.get<Bill[]>(this.baseUrl);
  }
}

