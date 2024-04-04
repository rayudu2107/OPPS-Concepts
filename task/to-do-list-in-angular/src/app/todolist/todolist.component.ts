import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.css']
})
export class TodolistComponent {
  // Array to store To-Do items
  itemArray = [{ itemName: 'Laptop', isCompleted: false }];

  // Function to handle form submission
  onSubmit(form: NgForm) {
    // Check if the form is valid
    if (form.valid) {
      // Push new item to itemArray
      this.itemArray.push({
        itemName: form.controls['item'].value,
        isCompleted: false
      });
      // Reset the form
      form.resetForm();
    }
  }

  // Function to handle item deletion
  onDelete(index: number) {
    // Remove item from itemArray based on index
    this.itemArray.splice(index, 1);
  }

  // Function to handle checkbox toggling
  onCheck(index: number) {
    // Toggle the completion status of the item
    this.itemArray[index].isCompleted = !this.itemArray[index].isCompleted;
  }
}
