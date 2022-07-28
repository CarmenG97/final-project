export class StarAstronomical {
    constructor(
        private _sao: number,
        private _starName: string,
        private _starDesignation: string,
        private _constellation: string,
        private _constellationId: number,
        private _appMagnitude: number,
        private _absMagnitude: number,
        private _spectrum: number,
        private _colour: number,
        private _rightAscension: number,
        private _declination: number,
        private _distance: number,
        private _image: string,
    ){}

    public get image(): string {
        return this._image;
    }
    public set image(value: string) {
        this._image = value;
    }
    public get distance(): number {
        return this._distance;
    }
    public set distance(value: number) {
        this._distance = value;
    }
    public get declination(): number {
        return this._declination;
    }
    public set declination(value: number) {
        this._declination = value;
    }
    public get rightAscension(): number {
        return this._rightAscension;
    }
    public set rightAscension(value: number) {
        this._rightAscension = value;
    }
    public get colour(): number {
        return this._colour;
    }
    public set colour(value: number) {
        this._colour = value;
    }
    public get spectrum(): number {
        return this._spectrum;
    }
    public set spectrum(value: number) {
        this._spectrum = value;
    }
    public get absMagnitude(): number {
        return this._absMagnitude;
    }
    public set absMagnitude(value: number) {
        this._absMagnitude = value;
    }
    public get appMagnitude(): number {
        return this._appMagnitude;
    }
    public set appMagnitude(value: number) {
        this._appMagnitude = value;
    }
    public get constellation(): string {
        return this._constellation;
    }
    public set constellation(value: string) {
        this._constellation = value;
    }
    public get starDesignation(): string {
        return this._starDesignation;
    }
    public set starDesignation(value: string) {
        this._starDesignation = value;
    }
    public get starName(): string {
        return this._starName;
    }
    public set starName(value: string) {
        this._starName = value;
    }
    public get sao(): number {
        return this._sao;
    }
    public set sao(value: number) {
        this._sao = value;
    }
    public get constellationId(): number {
        return this._constellationId;
    }
    public set constellationId(value: number) {
        this._constellationId = value;
    }

    public toJSON(): any {
        return {
            sao: this._sao,
            starName: this._starName,
            starDesignation: this._starDesignation,
            constellation: this._constellation,
            constellationId: this._constellationId,
            appMagnitude: this._appMagnitude,
            absMagnitude: this._absMagnitude,
            spectrum: this._spectrum,
            colour: this._colour,
            rightAscension: this._rightAscension,
            declination: this._declination,
            distance: this._distance,
            image: this._image,
        }
    }
    
}