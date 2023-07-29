import { Component } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //template:` <h1>This in line template</h1> `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'myBootApp';

  //baseLink : string = "http://localhost:8080/";

  
  ItemArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
 
  id: Number=0;
  itemName: String="";
  quantity: Number=0;
  price: Number=0;
  grade: Number=0

  

constructor(private http: HttpClient )
  {
    this.getAllInfo();   
    //handleError(error: HttpErrorResponse );  
  }
  getAllInfo(){
    alert("Item Rettrived Successfully");
    this.http.get("http://localhost:8080/adduser")
     .subscribe((resultData: any)=>{
      this.isResultLoaded = true;
        console.log(resultData);
        this.ItemArray = resultData;
        alert("Item Rettrived Successfully"+resultData);
    })
    

  }

    register()
  {
  
    let bodyData = {
      "itemName" : this.itemName,
      "id" : this.id,
      "quantity" : this.quantity,
      "price" : this.price,
      "grade" : this.grade
    };
 //xmlns="http://www.w3.org/2000/svg"
   // this.http.post("http://localhost:8080/users",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
     this.http.post("http://localhost:8080/users",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
       {
        console.log(resultData);
        alert("Item Registered Successfully");
        this.getAllInfo();
        this.id = 0;
        this.itemName = '';
        this.quantity  = 0;
        this.price = 0;
        this.grade = 0;
    });
  }
  setUpdate(data: any)
  {
      this.id = data.id;
      this.itemName = data.itemName;
      this.quantity  = data.quantity;
      this.price = data.price;
      this.grade = data.grade;
  }
 
  UpdateRecords()
  {
    let bodyData = {
      "itemName" : this.itemName,
      "id" : this.id,
      "quantity" : this.quantity,
      "price" : this.price ,
      "grade" : this.grade,     
   };
   alert("itemName="+this.itemName);
    
    this.http.put("http://localhost:8080/updateItem",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    { alert("Item Registered Updateddd")
        console.log(resultData);
       

        this.getAllInfo();
        this.id = 0;
        this.itemName = '';
        this.quantity  = 0;
        this.price = 0;
        this.grade = 0;

    });
  }
 
  save()
  {
    if(this.id == 0)
    {
        this.register();
    }
      else
      {
       this.UpdateRecords();
      }      
 
  }
 
  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8080/deleteItem"+ "/"+ data.id,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Item Deletedddd")


        this.getAllInfo();
        this.id = 0;
        this.itemName = '';
        this.quantity  = 0;
        this.price = 0; 
        this.grade = 0;  
    });
 
  }
/*
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
    // A client-side or network error occurred. Handle it accordingly.
    console.error('An error occurred:', error.error);
    } else {
    // The backend returned an unsuccessful response code.
    // The response body may contain clues as to what went wrong.
    console.error(
    `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
    }

*/




}
