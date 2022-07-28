export class Star {
     constructor(
        private _sao: number,
        private _starName: string,
        private _starDesignation: string,
        private _constellation: string,
        private _constellationId: number,
        private _brightness: number,
        private _type: string,
        private _colour: string,
        private _distance: number,
        private _image: string,
    ){}

    public get constellationId(): number {
        return this._constellationId;
    }
    public set constellationId(value: number) {
        this._constellationId = value;
    }
    public get image(): string {
        return this._image;
    }
    public set image(value: string) {
        this._image = value;
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
    public get distance(): number {
        return this._distance;
    }
    public set distance(value: number) {
        this._distance = value;
    }
    public get colour(): string {
        return this._colour;
    }
    public set colour(value: string) {
        this._colour = value;
    }
    public get type(): string {
        return this._type;
    }
    public set type(value: string) {
        this._type = value;
    }
    public get brightness(): number {
        return this._brightness;
    }
    public set brightness(value: number) {
        this._brightness = value;
    }
    public get constellation(): string {
        return this._constellation;
    }
    public set constellation(value: string) {
        this._constellation = value;
    }
    public get sao(): number {
        return this._sao;
    }
    public set sao(value: number) {
        this._sao = value;
    }

    public toJSON(): any {
        return {
            sao: this._sao,
            starName: this._starName,
            starDesignation: this._starDesignation,
            constellation: this._constellation,
            constellationId: this._constellationId,
            brightness: this._brightness,
            type: this._type,
            colour: this._colour,
            distance: this._distance,
            image: this._image,
        };
    }
}

