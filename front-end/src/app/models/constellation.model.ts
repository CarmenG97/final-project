import { Star } from "./star.model";

export class Constellation {
    constructor(
        private _id: number,
        private _constellationName: string,
        private _alphaStarName: string,
        private _numberOfStars: number,
        private _starCuriousDTOList: Star[],
        private _profilePicture: string,
        private _secondProfilePicture: string,
        private _history: string,
    ){}

    public get history(): string {
        return this._history;
    }
    public set history(value: string) {
        this._history = value;
    }
    public get secondProfilePicture(): string {
        return this._secondProfilePicture;
    }
    public set secondProfilePicture(value: string) {
        this._secondProfilePicture = value;
    }
    public get starCuriousDTOList(): Star[] {
        return this._starCuriousDTOList;
    }
    public set starCuriousDTOList(value: Star[]) {
        this._starCuriousDTOList = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get profilePicture(): string {
        return this._profilePicture;
    }
    public set profilePicture(value: string) {
        this._profilePicture = value;
    }
    public get alphaStarName(): string {
        return this._alphaStarName;
    }
    public set alphaStarName(value: string) {
        this._alphaStarName = value;
    }
    public get numberOfStars(): number {
        return this._numberOfStars;
    }
    public set numberOfStars(value: number) {
        this._numberOfStars = value;
    }

    public get constellationName(): string {
        return this._constellationName;
    }
    public set constellationName(value: string) {
        this._constellationName = value;
    }

    public toJSON(): any {
        return {
            id: this._id,
            constellationName: this._constellationName,
            alphaStarName: this._alphaStarName,
            numberOfStars: this._numberOfStars,
            starCuriousDTOList: this._starCuriousDTOList,
            profilePicture: this._profilePicture,
            secondProfilePicture: this._secondProfilePicture,
            history: this._history,
        };
    }
}

