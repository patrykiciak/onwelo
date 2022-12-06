import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CandidatesOverviewComponent } from './components/candidates-overview/candidates-overview.component';
import { VoteComponent } from './components/vote/vote.component';
import { VotersOverviewComponent } from './components/voters-overview/voters-overview.component';
import {VotesService} from "./services/votes.service";
import {ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDividerModule} from "@angular/material/divider";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatDialogModule} from "@angular/material/dialog";
import {TextInputDialogComponent} from "./components/text-input-dialog/text-input-dialog.component";
import {MatInputModule} from "@angular/material/input";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    VotersOverviewComponent,
    CandidatesOverviewComponent,
    VoteComponent,
    TextInputDialogComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatDividerModule,
    MatSidenavModule,
    MatToolbarModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    MatInputModule
  ],
  providers: [
    VotesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
