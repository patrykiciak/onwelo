import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {VotesService} from "../../services/votes.service";
import {Voter} from "../voters-overview/voter.model";
import {Candidate} from "../candidates-overview/candidate.model";

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css']
})
export class VoteComponent implements OnInit {
  formGroup: FormGroup = new FormGroup({
    voter: new FormControl(undefined, Validators.required),
    candidate: new FormControl(undefined, Validators.required)
  });

  voters$ = this.votesService.voters$;
  candidates$ = this.votesService.candidates$;

  constructor(
    private votesService: VotesService
  ) { }

  ngOnInit(): void {
  }

  get voter(): Voter {
    return this.formGroup.get('voter')?.value;
  }

  get candidate(): Candidate {
    return this.formGroup.get('candidate')?.value;
  }

  onSubmit(): void {
    this.votesService.sendVote({
      voterId: this.voter.id,
      candidateId: this.candidate.id
    })
  }
}
