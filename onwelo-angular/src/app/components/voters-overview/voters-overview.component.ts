import {Component, OnInit} from '@angular/core';
import {VotesService} from "../../services/votes.service";
import {map, Observable} from "rxjs";
import {Voter} from "./voter.model";
import {MatDialog} from "@angular/material/dialog";
import {TextInputDialogComponent} from "../text-input-dialog/text-input-dialog.component";

@Component({
  selector: 'app-voters-overview',
  templateUrl: './voters-overview.component.html',
  styleUrls: ['./voters-overview.component.css']
})
export class VotersOverviewComponent implements OnInit {
  voters$: Observable<Voter[] | undefined> = this.votesService.voters$.pipe(
    map(voters => voters?.map(voter => ({
      id: voter.id,
      name: voter.name,
      hasVoted: voter.hasVoted
    } as Voter)))
  );

  constructor(
    private votesService: VotesService,
    private matDialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  addVoter() {
    const dialogRef = this.matDialog.open(TextInputDialogComponent, {
      restoreFocus: false
    })

    dialogRef.afterClosed().subscribe(result => {
      if (result != null) {
        this.votesService.addCandidate(result);
      }
    })
  }
}
