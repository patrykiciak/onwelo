import { Component, OnInit } from '@angular/core';
import {Candidate} from "./candidate.model";
import {VotesService} from "../../services/votes.service";
import {lastValueFrom, map, Observable} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {TextInputDialogComponent} from "../text-input-dialog/text-input-dialog.component";

@Component({
  selector: 'app-candidates-overview',
  templateUrl: './candidates-overview.component.html',
  styleUrls: ['./candidates-overview.component.css']
})
export class CandidatesOverviewComponent implements OnInit {
  candidates$: Observable<Candidate[] | undefined> = this.votesService.candidates$.pipe(
    map(votes => votes?.map(vote => ({
      name: vote.name,
      votes: vote.votes
    } as Candidate)))
  );

  constructor(
    private votesService: VotesService,
    private matDialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  async addCandidate(): Promise<void> {
    const dialogRef = this.matDialog.open(TextInputDialogComponent, {
      restoreFocus: false
    });

    const result = await lastValueFrom(dialogRef.afterClosed())
    if (result != null) {
      this.votesService.addCandidate(result);
    }
  }
}
