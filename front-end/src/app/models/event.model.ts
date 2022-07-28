export class Event {
    constructor(
        private _id: number,
        private _eventName: string,
        private _date: string,
        private _location: string,
        private _description: string,
        private _photo: string,
    ){}

    public get photo(): string {
        return this._photo;
    }
    public set photo(value: string) {
        this._photo = value;
    }
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    public get location(): string {
        return this._location;
    }
    public set location(value: string) {
        this._location = value;
    }
    public get date(): string {
        return this._date;
    }
    public set date(value: string) {
        this._date = value;
    }
    public get eventName(): string {
        return this._eventName;
    }
    public set eventName(value: string) {
        this._eventName = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public toJSON(): any {
        return {
            id: this._id,
            eventName: this._eventName,
            date: this._date,
            location: this._location,
            description: this._description,
        };
    }
}