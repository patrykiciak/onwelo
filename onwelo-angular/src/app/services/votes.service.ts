import {BehaviorSubject, lastValueFrom, Observable} from "rxjs";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";

export interface PostVoteDTO {
  author: number;
  votedFor: number;
}

export interface GetCandidateDTO {
  id: number;
  name: string;
  votes: number;
}

export interface GetVoterDTO {
  id: number;
  name: string;
  hasVoted: boolean;
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
    this._candidatesSubject.next(this.getCandidates());
    this._votersSubject.next(this.getVoters());
  }

  private getCandidates(): GetCandidateDTO[] {
    return [
      {id: 1, name: 'Hyzio', votes: 0},
      {id: 2, name: 'Dyzio', votes: 0},
      {id: 3, name: 'Zyzio', votes: 0},
    ]
  }

  private getVoters(): GetVoterDTO[] {
    return [
      {id: 1, name: 'Patryk', hasVoted: false},
      {id: 2, name: 'Adrian', hasVoted: false},
      {id: 3, name: 'Mikołaj', hasVoted: false},
      {id: 4, name: 'Ryszard', hasVoted: false},
    ]
  }

  public sendVote(vote: PostVoteDTO): void {
    console.log('Vote', vote.author, vote.votedFor)
  }

  async addCandidate(name: string): Promise<HttpResponse<Object>> {
    const request: PostCandidate = {
      name: name
    }
    console.log('Adding candidate', name);
    return await lastValueFrom(this.httpClient.post('http://localhost:8080/candidates', request, {observe: 'response'}));
  }

  async addVoter(name: string): Promise<HttpResponse<Object>> {
    const request: PostVoter = {
      name: name
    }
    return await lastValueFrom(this.httpClient.post('http://localhost:8080/candidates', request, {observe: 'response'}));
  }
}
