import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-text-input-dialog',
  templateUrl: './text-input-dialog.component.html',
  styleUrls: ['./text-input-dialog.component.css']
})
export class TextInputDialogComponent implements OnInit {
  formGroup = new FormGroup({
    value: new FormControl(undefined, Validators.required)
  });

  constructor(
    private matDialogRef: MatDialogRef<TextInputDialogComponent>
  ) { }

  get value(): string | undefined {
    return this.formGroup.get('value')?.value;
  }

  ngOnInit(): void {

  }

  onSubmit() {
    this.matDialogRef.close(this.value);
  }
}
