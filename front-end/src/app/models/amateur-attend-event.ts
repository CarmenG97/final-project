export class AmateurAttentEvent {
    constructor(
        private _id: number | null,
        private _amateurId: number,
        private _eventId: number, //private _eventList: Event[],
    ) { }

    public get eventId(): number {
        return this._eventId;
    }
    public set eventId(value: number) {
        this._eventId = value;
    }
    public get amateurId(): number {
        return this._amateurId;
    }
    public set amateurId(value: number) {
        this._amateurId = value;
    }
    public get id(): number | null {
        return this._id;
    }
    public set id(value: number | null) {
        this._id = value;
    }
    
    public toJSON(): any {
        return {
            id: this._id,
            amateurId: this._amateurId,
            eventId: this._eventId,
        };
    }
}