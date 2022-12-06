import {BehaviorSubject, lastValueFrom, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

export interface PostVoteDTO {
  voterId: number;
  candidateId: number;
}

export interface GetCandidateDTO {
  id: number;
  name: string;
  votes: number;
}

export interface GetVoterDTO {
  id: number;
  name: string;
  votedFor: any;
}

export interface PostVoter {
  name: string;
}

export interface PostCandidate {
  name: string;
}

@Injectable()
export class VotesService {
  private _candidatesSubject = new BehaviorSubject<GetCandidateDTO[] | undefined>(undefined);
  candidates$: Observable<GetCandidateDTO[] | undefined> = this._candidatesSubject.asObservable();

  private _votersSubject = new BehaviorSubject<GetVoterDTO[] | undefined>(undefined);
  voters$: Observable<GetVoterDTO[] | undefined> = this._votersSubject.asObservable();

  constructor(
    private httpClient: HttpClient
  ) {
    this.loadCandidates();
    this.loadVoters();
  }

  private loadCandidates(): void {
    this.httpClient.get<GetCandidateDTO[]>('http://localhost:8080/votes').subscribe(value => {
      this._candidatesSubject.next(value);
    })
  }

  private loadVoters(): void {
    this.httpClient.get<GetVoterDTO[]>('http://localhost:8080/voters').subscribe(value => {
      this._votersSubject.next(value);
    })
  }

  public sendVote(vote: PostVoteDTO): void {
    this.httpClient.post('http://localhost:8080/votes', vote, {observe: "response"}).subscribe(() => {
      this.loadVoters();
      this.loadCandidates();
    });
  }

  addVoter(name: string): void {
    const request: PostVoter = {
      name: name
    }
    lastValueFrom(this.httpClient.post('http://localhost:8080/voters', request, {observe: 'response'})).then(() => {
      this.loadVoters();
    });
  }

  addCandidate(name: string): void {
    const request: PostCandidate = {
      name: name
    }
    lastValueFrom(this.httpClient.post('http://localhost:8080/candidates', request, {observe: 'response'})).then(() => {
      this.loadCandidates();
    });
  }
}
